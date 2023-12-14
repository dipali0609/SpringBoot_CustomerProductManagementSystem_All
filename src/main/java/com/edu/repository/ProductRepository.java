package com.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.dao.Product;

public interface ProductRepository extends JpaRepository<Product, Integer>
{

}
