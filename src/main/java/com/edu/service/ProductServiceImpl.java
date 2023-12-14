package com.edu.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.dao.Customer;
import com.edu.dao.Product;
import com.edu.error.ProductNotFoundException;
import com.edu.repository.CustomerRepository;
import com.edu.repository.ProductRepository;

@Service 
public class ProductServiceImpl implements ProductService
{
	@Autowired
     private ProductRepository productRepository;
	@Autowired
	private CustomerRepository customerRepository;
     
	@Override
	public Product saveProduct(Product product) {
		// TODO Auto-generated method stub
		return productRepository.save(product);
	}
   
	@Override
	public Product productassigntocustomer(Integer productid, Integer custometid) {
		// TODO Auto-generated method stub
	     Product p=productRepository.findById(productid).get();
	     Customer c=customerRepository.findById(custometid).get();
	     p.productassigntocustomer(c);
		return productRepository.save(p);
	}

	@Override
	public List<Product> findAllProduct() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Product updateProductById(Integer productid, Product product) throws ProductNotFoundException 
	{
		Optional<Product> p1=productRepository.findById(productid);
		if(p1.isPresent())
		{
			Product p=productRepository.findById(productid).get();
			if(p!=null)
			{
				p.setProductname(product.getProductname());
				return productRepository.save(p);
			}
			return p;
		}
		else
		{
			throw new ProductNotFoundException(productid+" ID Not Present");
		}
		
	}

	

}
