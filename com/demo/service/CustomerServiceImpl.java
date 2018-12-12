package com.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.CustomerDAO;
import com.demo.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {
	// need to inject customer dao
	@Autowired
	private CustomerDAO customerDAO;

	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
	}
	@Override
	@Transactional
	public void deleteCustomer(String theCustomerCode)
	{
		customerDAO.deleteCustomer(theCustomerCode);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(String theCustomerCode) {
		
		return customerDAO.getCustomer(theCustomerCode);
	}
	@Override
	@Transactional
	public void editCustomer(Customer theCustomer) {
		System.out.println(theCustomer.getRegistrationDate());
		String date=theCustomer.getRegistrationDate();
		System.out.println("hi");
		date=date.substring(0, 10);
		System.out.println(date);	
	String newDate=""+date.charAt(8)+""+date.charAt(9)+"/"+date.charAt(5)+date.charAt(6)+"/"+date.charAt(0)+date.charAt(1)+date.charAt(2)+date.charAt(3);
	System.out.println("newdate");
	System.out.println(newDate);
   
	theCustomer.setRegistrationDate(newDate);
		customerDAO.editCustomer(theCustomer);

	}

	
	

}
