package com.demo.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "customer")
public class Customer {


	@Column(name = "contact_number")
	private String contactNumber;

	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "customer_address")
	private String customerAddress;

	@Id
	@Column(name = "customer_code")
	private String customerCode;

	@Column(name = "customer_email")
	private String customerEmail;

	@Column(name = "customer_name")
	private String customerName;

	@Column(name = "customer_pincode")
	private String customerPinCode;

	@Column(name = "modified_date")
	/*@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private Date modifiedDate;*/
	private String modifiedDate;


	@Column(name = "registration_date")
	/*@Temporal(javax.persistence.TemporalType.TIMESTAMP)
	@DateTimeFormat(pattern = "dd.MM.yyyy hh:mm")
	private Date registrationDate;*/
	private String registrationDate;


	public Customer() {

	}

	public String getContactNumber() {
		return contactNumber;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public String getCustomerCode() {
		return customerCode;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public String getCustomerName() {
		return customerName;
	}

	public String getCustomerPinCode() {
		return customerPinCode;
	}

	/*	public Date getModifiedDate() {
		return modifiedDate;
	}

	public Date getRegistrationDate() {
		return registrationDate;
	}*/

	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}

@Override
	public String toString() {
		return "Customer [contactNumber=" + contactNumber + ", createdBy=" + createdBy + ", customerAddress="
				+ customerAddress + ", customerCode=" + customerCode + ", customerEmail=" + customerEmail
				+ ", customerName=" + customerName + ", customerPinCode=" + customerPinCode + ", modifiedDate="
				+ modifiedDate + ", registrationDate=" + registrationDate + "]";
	}

public String getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getRegistrationDate() {
		return registrationDate;
	}

	public void setRegistrationDate(String registrationDate) {
		this.registrationDate = registrationDate;
	}

public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public void setCustomerPinCode(String customerPinCode) {
		this.customerPinCode = customerPinCode;
	}


	/*public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}*/

}