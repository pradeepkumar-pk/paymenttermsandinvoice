package com.trimindtech.assignment.model;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PaymentTerms {
	
	@Id
	private Long id;
	private String code;
	private String description;
	private Date creationDate;
	private int days;	
	private int remindBeforeDays;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	public int getRemindBeforeDays() {
		return remindBeforeDays;
	}
	public void setRemindBeforeDays(int remindBeforeDays) {
		this.remindBeforeDays = remindBeforeDays;
	}
	
	@Override
	public String toString() {
		return "PaymentTerms [id=" + id + ", code=" + code + ", description=" + description + ", creationDate="
				+ creationDate + ", days=" + days + ", remindBeforeDays=" + remindBeforeDays + "]";
	}
	
	

}
