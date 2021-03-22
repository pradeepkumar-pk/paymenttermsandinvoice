package com.trimindtech.assignment.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Invoice {
	
	@Id
	private String invoiceNumber;
	private LocalDate invoiceDate;
	private String paymentTerm;
	private String status;
	
	
	public Invoice() {
		super();
	}

	public Invoice(String invoiceNumber, LocalDate invoiceDate, String paymentTerm, String status) {
		super();
		this.invoiceNumber = invoiceNumber;
		this.invoiceDate = invoiceDate;
		this.paymentTerm = paymentTerm;
		this.status = status;
	}
	
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public LocalDate getInvoiceDate() {
		return invoiceDate;
	}
	public void setInvoiceDate(LocalDate invoiceDate) {
		this.invoiceDate = invoiceDate;
	}
	public String getPaymentTerm() {
		return paymentTerm;
	}
	public void setPaymentTerm(String paymentTerm) {
		this.paymentTerm = paymentTerm;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Invoice [invoiceNumber=" + invoiceNumber + ", invoiceDate=" + invoiceDate + ", paymentTerm="
				+ paymentTerm + ", status=" + status + "]";
	}
	
	
	
	
	
}
