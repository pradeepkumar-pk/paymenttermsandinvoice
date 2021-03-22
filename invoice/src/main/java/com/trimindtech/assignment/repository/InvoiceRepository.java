package com.trimindtech.assignment.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.trimindtech.assignment.model.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, String>{

	 @Query(value = "SELECT * FROM INVOICE WHERE STATUS='UNPAID'", nativeQuery = true)
	 public List<Invoice> findByUnpaidStatus();
}
