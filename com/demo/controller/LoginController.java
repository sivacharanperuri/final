package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.demo.entity.User;
import com.demo.service.LoginService;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private LoginService loginService;

	@GetMapping("/newuser")
	public String showFormForAdd(Model theModel) {

		User theUser = new User();

		theModel.addAttribute("user", theUser);

		return "new-user-form";
	}

	@PostMapping("/saveUser")
	public String saveCustomer(@ModelAttribute("user") User theUser) {
		loginService.saveUser(theUser);

		return "new-user-registered";
	}

	@GetMapping("/login")
	public String showLoginForm(Model theModel) {
		User theUser = new User();
		theUser.setUserName("user");
		theModel.addAttribute("user", theUser);

		return "login-form";
	}

	@PostMapping("/validateUser")
	public String validateUser(@ModelAttribute("user") User theUser) {
		if (loginService.validateUser(theUser) != null) {
			  	
			String role=theUser.getRole();
			String operator=theUser.getUserName();
			UserId.userId=operator;
			System.out.println(operator);
			if(role.equals("user"))
			{
				return "redirect:/customer/list?operator="+operator+"";

				
			}
			else if(role.equals("admin"))
			{
			return "redirect:/login/newuser";
			}
		}
		return "login-error";
	}
}
