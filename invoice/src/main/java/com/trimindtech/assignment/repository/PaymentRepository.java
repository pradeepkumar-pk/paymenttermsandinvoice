package com.trimindtech.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trimindtech.assignment.model.PaymentTerms;

public interface PaymentRepository extends JpaRepository<PaymentTerms, Long> {
	
	public PaymentTerms findByCode(String code);

}
