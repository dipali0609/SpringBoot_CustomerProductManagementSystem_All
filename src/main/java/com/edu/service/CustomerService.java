package com.edu.service;

import java.util.List;

import com.edu.dao.Customer;
import com.edu.error.CustomerNotFoundException;

public interface CustomerService {

	public Customer saveCustomer(Customer customer);

	public Customer updateCustomerById(Integer custometid, Customer customer) throws CustomerNotFoundException;

	public List<Customer> findAllCostomer();

}
