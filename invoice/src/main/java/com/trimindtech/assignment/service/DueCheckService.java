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

@Component
public class DueCheckService {
	
	
	@Autowired
	InvoiceService invoiceService;
	
	    @Scheduled(cron="*/5 * * * * *")
		public void checkDue() {
	    	System.out.println("--------due check service--------");
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
	    	final String uri = "http://payterms:8080/code/{code}";
	        RestTemplate restTemplate = new RestTemplate();
	        Map<String, String> params = new HashMap<>();
	        params.put("code", strCode);
	        return restTemplate.getForObject(uri, PaymentTerms.class, params);

//	        PaymentTerms paymentTerms = modelMapper.map(restTemplate.getForObject(uri, PaymentTerms.class, params), PaymentTerms.class);
//	        return paymentTerms;
	    }


}
