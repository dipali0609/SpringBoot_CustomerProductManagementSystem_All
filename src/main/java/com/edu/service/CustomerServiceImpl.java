package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Customer;
import com.edu.error.CustomerNotFoundException;
import com.edu.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService
{
    @Autowired
	private CustomerRepository customerRepository;
	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}
	@Override
	public Customer updateCustomerById(Integer custometid, Customer customer) throws CustomerNotFoundException 
	{
		Optional<Customer> cust1=customerRepository.findById(custometid);
		if(cust1.isPresent())
		{
		Customer cust=customerRepository.findById(custometid).get();
		if(cust !=null)
		{
			cust.setCustomername(customer.getCustomername());
			cust.setCustomerlocation(customer.getCustomerlocation());
			return customerRepository.save(cust);
		}
		return cust;
		}
		else
		{
			throw new CustomerNotFoundException(custometid+"ID is not present");
		}
	}
	@Override
	public List<Customer> findAllCostomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}
	

}
