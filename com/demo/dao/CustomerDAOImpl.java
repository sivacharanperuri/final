package com.demo.dao;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.demo.controller.UserId;
import com.demo.entity.Customer;

@Repository
public class CustomerDAOImpl implements CustomerDAO{
	@Autowired
	private SessionFactory sessionFactory;
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> theQuery = currentSession.createQuery("from Customer ORDER BY customerName", Customer.class);
		List<Customer> customers = theQuery.getResultList();
		return customers;
	}
	@Override
	public void saveCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date=(String)dtf.format(now);
		theCustomer.setRegistrationDate(date);
		theCustomer.setCreatedBy(UserId.userId);
		currentSession.saveOrUpdate(theCustomer);
	}
	@Override
	public void editCustomer(Customer theCustomer) {
		Session currentSession = sessionFactory.getCurrentSession();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		String date=(String)dtf.format(now);
		theCustomer.setModifiedDate(date);
		System.out.println(theCustomer.getModifiedDate());

		currentSession.saveOrUpdate(theCustomer);
	}
	public void deleteCustomer(String theCustomerCode)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		Query theQuery=currentSession.createQuery("delete Customer where customer_code=:customerCode");
		theQuery.setParameter("customerCode",theCustomerCode);
		theQuery.executeUpdate();
	}


	@Override
	public Customer getCustomer(String theCustomerCode)
	{
		Session currentSession=sessionFactory.getCurrentSession();
		Customer theCustomer=currentSession.get(Customer.class, theCustomerCode);
		return theCustomer;
		
	}

	
	

}
