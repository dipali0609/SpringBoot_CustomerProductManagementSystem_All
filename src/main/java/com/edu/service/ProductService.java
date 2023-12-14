package com.edu.service;

import java.util.List;

import com.edu.dao.Product;
import com.edu.error.ProductNotFoundException;

public interface ProductService {

	public Product saveProduct(Product product);

	public Product productassigntocustomer(Integer productid, Integer custometid);

	public List<Product> findAllProduct();

	public Product updateProductById(Integer productid, Product product) throws ProductNotFoundException;

}
