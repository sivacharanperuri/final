package com.demo.service;

import java.util.List;

import com.demo.entity.Customer;

public interface CustomerService {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	public void deleteCustomer(String theCustomerCode);

	public Customer getCustomer(String theCustomerCode);

	public void editCustomer(Customer theCustomer);
}
