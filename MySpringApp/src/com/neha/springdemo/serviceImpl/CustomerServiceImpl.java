package com.neha.springdemo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.neha.springdemo.DAO.CustomerDAO;
import com.neha.springdemo.entity.Customer;
import com.neha.springdemo.service.CustomerService;




@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDAO customerDAO;
	
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDAO.getCustomers();
	}


	@Transactional
	@Override
	public boolean addCustomer(Customer customer) {
		return customerDAO.addCustomer(customer);
	}


	@Transactional
	@Override
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}


	@Transactional
	@Override
	public boolean deletCustomer(int customerId) {
		return customerDAO.deletCustomer(customerId);
	}


	@Transactional
	@Override
	public boolean updtaeCustomer(Customer customer) {
		return customerDAO.updtaeCustomer(customer);
	}

}
