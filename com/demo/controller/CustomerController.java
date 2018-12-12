package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entity.Customer;
import com.demo.service.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	@GetMapping("/list")
	public String listCustomers(Model theModel) {	
		
		List<Customer> theCustomers = customerService.getCustomers();
				
		theModel.addAttribute("customers", theCustomers);
		
		return "records-list";
	}
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		Customer theCustomer = new Customer();
		
		theModel.addAttribute("customer", theCustomer);
		
		return "customer-form";
	}
	
	@PostMapping("/saveCustomer")
	public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
		
		customerService.saveCustomer(theCustomer);
				
		return "redirect:/customer/list";
	}
	
	@PostMapping("/editCustomer")
	public String editCustomer(@ModelAttribute("customer") Customer theCustomer) {		
		customerService.editCustomer(theCustomer);
				
		return "redirect:/customer/list";
	}
	@GetMapping("/delete")
	public String deleteCustomer(@RequestParam("customerCode") String theCustomerCode)
	{
		customerService.deleteCustomer(theCustomerCode);
		return "redirect:/customer/list";	
	}
	
	@GetMapping("/editForm")
	public String editForm(@RequestParam("customerCode") String theCustomerCode, Model theModel) {
		
		Customer theCustomer =customerService.getCustomer(theCustomerCode);
		
		theModel.addAttribute("customer", theCustomer);
		
		return "edit-form";
	}
	
	
	
	
}


