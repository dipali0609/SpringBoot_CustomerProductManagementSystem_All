package com.edu.controller;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder.In;
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

import com.edu.dao.Product;
import com.edu.error.ProductNotFoundException;
import com.edu.service.ProductService;

@RestController
public class ProductController {
    
	@Autowired
	private ProductService productService;
	
//	@PostMapping("/saveProduct")
//	public Product saveProduct(@RequestBody Product product)
//	{
//		return productService.saveProduct(product);
//		
//	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<Product> saveProduct(@Valid @RequestBody Product product)
	{
		Product prod=productService.saveProduct(product);
		return new ResponseEntity<Product>(prod,HttpStatus.CREATED);
		
	}
	
	@PutMapping("/productassigntocustomer/{pid}/customer/{cid}")
	public Product productassigntocustomer(@PathVariable("pid") Integer productid,@PathVariable("cid") Integer customeid)
	{
		return productService.productassigntocustomer(productid, customeid);
		
	}
	
    @PutMapping("/updateProductById/{pid}")
    public Product updateProductById(@PathVariable("pid") Integer productid, @RequestBody Product product) throws ProductNotFoundException
    {
		return productService.updateProductById(productid,product);
    	
    }
	
	@GetMapping("/findAllProduct")
	public List<Product> findAllProduct()
	{
		return productService.findAllProduct();
		
	}
	
	
	
}
