package com.demo.dao;

import java.util.List;

import com.demo.entity.Customer;

public interface CustomerDAO {

	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);
	public void deleteCustomer(String theCustomerCode);
	
	public Customer getCustomer(String theCustomerCode);

	void editCustomer(Customer theCustomer);


}
