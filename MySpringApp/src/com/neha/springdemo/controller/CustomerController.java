package com.neha.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.neha.springdemo.entity.Customer;
import com.neha.springdemo.service.CustomerService;


@Controller
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	@GetMapping("/list")
	public String listCustomer(Model model) {
		List<Customer> thecustomers = customerService.getCustomers();
		model.addAttribute("customers", thecustomers);
		return "List_Customer";
	}

	@GetMapping("/addForm")
	public String addCustomerForm( Model model) {
		model.addAttribute("customer", new Customer());
//		System.out.println("customer in update form------" + customer);
		return "Add_Customer";
	}

	
	@PostMapping("/processAddCustomer")
	public String addCustomer(@ModelAttribute("customer") Customer customer) {
		boolean bool = customerService.addCustomer(customer);
		return "redirect:/customer/list";
	}

	@GetMapping("/updateForm")
	public String updateCustomerForm(@RequestParam("customerId")int customerId, Model model) {
		Customer customer = customerService.getCustomer(customerId);
		model.addAttribute("customer", customer);
		System.out.println("customer in update form------" + customer);
		return "Update_Customer";
	}

	@PostMapping("/updateCustomer")
	public String updateCustomer(@ModelAttribute("customer") Customer customer) {

		boolean bool = customerService.updtaeCustomer(customer);
		System.out.println("customer in update customer------" + customer);
		return "redirect:/customer/list";
	}

	@RequestMapping("/deleteCustomer")
	public String deleteCustomercontroller(@RequestParam("customerId")int customerId, Model model) {
		boolean bool = customerService.deletCustomer(customerId);
		return "redirect:/customer/list";
	}

}
