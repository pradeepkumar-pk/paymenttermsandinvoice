package com.trimindtech.assignment.service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.trimindtech.assignment.model.Invoice;
import com.trimindtech.assignment.model.PaymentTerms;
import com.trimindtech.assignment.repository.PaymentRepository;

@Component
public class DueCheckService {
	
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	InvoiceService invoiceService;
	
	    @Scheduled(cron="0 17 01 * * *")
		public void checkDue() {
			List<Invoice> list = invoiceService.getInvoiceByStatusUnpaid();
			for(Invoice inv: list) {
				if(inv.getStatus().equalsIgnoreCase("UNPAID")) {
					String str = inv.getPaymentTerm();
					PaymentTerms payTm = getPaymentTermsByCode(str);
					LocalDate targetDate = inv.getInvoiceDate().plusDays(payTm.getDays()).minusDays(payTm.getRemindBeforeDays());
					if(LocalDate.now().equals(targetDate)) {
						System.out.println("its due date for " + inv.getInvoiceNumber());
					}

				}
			}
		}
	    

	    
	    public PaymentTerms getPaymentTermsByCode(String strCode){
	    	final String uri = "http://localhost:8080/code/{code}";
	        RestTemplate restTemplate = new RestTemplate();
	        Map<String, String> params = new HashMap<>();
	        params.put("code", strCode);
	        return restTemplate.getForObject(uri, PaymentTerms.class, params);
	    }


}
