package com.trimindtech.assignment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.trimindtech.assignment.model.Invoice;
import com.trimindtech.assignment.repository.InvoiceRepository;

@Service
public class InvoiceService {
	
	@Autowired
	InvoiceRepository invoiceRepository;
     
    public List<Invoice> getAllInvoices(){
        return invoiceRepository.findAll();
    }
    
    public List<Invoice> getInvoiceByStatusUnpaid(){
        return invoiceRepository.findByUnpaidStatus();
    }

}
