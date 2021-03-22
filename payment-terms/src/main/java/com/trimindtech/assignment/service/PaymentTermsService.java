package com.trimindtech.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimindtech.assignment.model.PaymentTerms;
import com.trimindtech.assignment.repository.PaymentTermsRepository;

@Service
public class PaymentTermsService {
	
	@Autowired
	PaymentTermsRepository paymentTermsRepository;
     
    public List<PaymentTerms> getAllPaymentTerms(){
        return paymentTermsRepository.findAll();
    }
    
    public PaymentTerms getPaymentTermsByCode(String code){
        return paymentTermsRepository.findByCode(code);
    }
	
	public void saveOrUpdate(PaymentTerms paymentTerms) {
		paymentTermsRepository.save(paymentTerms);
	}

}
