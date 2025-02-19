package com.trimindtech.assignment.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.trimindtech.assignment.model.PaymentTerms;
import com.trimindtech.assignment.model.PaymentTermsDTO;
import com.trimindtech.assignment.service.PaymentTermsService;

@RestController
public class PaymentTermsController {

	@Autowired
	PaymentTermsService paymentTermsService;
	
	  @GetMapping("/all")
	    public List<PaymentTerms> getAllEmployees() {
			return paymentTermsService.getAllPaymentTerms();
	    }
	
	  @GetMapping("/code/{code}")
	    public PaymentTermsDTO getPaymentTermsByCode(@PathVariable("code") String code) {
//			return paymentTermsService.getPaymentTermsByCode(code);
		  ModelMapper modelMapper = new ModelMapper();
		  PaymentTerms paymentTerms = paymentTermsService.getPaymentTermsByCode(code);
		  PaymentTermsDTO paymentTermsDto = modelMapper.map(paymentTerms, PaymentTermsDTO.class);
		  return paymentTermsDto;
	    }
	  
		@PostMapping("/create")
		public Long savePts(@RequestBody PaymentTerms paymentTerms) {
			paymentTermsService.saveOrUpdate(paymentTerms);
			return paymentTerms.getId();
		}
	
}
