package com.edu.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.edu.dao.Customer;
import com.edu.dao.Product;
import com.edu.error.CustomerNotFoundException;
import com.edu.service.CustomerService;

@RestController
public class CustomerController {
   
	@Autowired
	private CustomerService customerService;
	
//	@PostMapping("/saveCustomer")
//	public Customer saveCustomer(@RequestBody Customer customer)
//	{
//		return customerService.saveCustomer(customer);	
//	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer customer)
	{
		Customer cust=customerService.saveCustomer(customer);
		return new ResponseEntity<Customer>(cust,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/updateCustomerById/{cid}")
	public Customer updateCustomerById(@PathVariable("cid") Integer custometid, @RequestBody Customer customer) throws CustomerNotFoundException
	{
		return customerService.updateCustomerById(custometid, customer);
		
	}
	
	@GetMapping("/findAllCostomer")
	public List<Customer> findAllCostomer()
	{
		return customerService.findAllCostomer();
		
	}
}
