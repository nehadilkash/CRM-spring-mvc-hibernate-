package com.neha.springdemo.service;

import java.util.List;

import com.neha.springdemo.entity.Customer;


public interface CustomerService {

	public List<Customer> getCustomers();

	public boolean addCustomer(Customer customer);

	public Customer getCustomer(int customerId);

	public boolean deletCustomer(int customerId);

	public boolean updtaeCustomer(Customer customer);
}
