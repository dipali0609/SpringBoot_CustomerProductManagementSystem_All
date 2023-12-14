package com.edu.dao;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Product 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private int productid;
	@NotBlank
private String productname;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(int productid, @NotBlank String productname) {
		super();
		this.productid = productid;
		this.productname = productname;
	}

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="custometid", referencedColumnName = "custometid")
	Customer cust;
	
	public Customer getCust() {
		return cust;
	}
	public void setCust(Customer cust) {
		this.cust = cust;
	}

	
	
	public int getProductid() {
		return productid;
	}

	public void setProductid(int productid) {
		this.productid = productid;
	}

	public String getProductname() {
		return productname;
	}

	public void setProductname(String productname) {
		this.productname = productname;
	}

	@Override
	public String toString() {
		return "Product [productid=" + productid + ", productname=" + productname + "]";
	}

	public void productassigntocustomer(Customer c) {
		// TODO Auto-generated method stub
		this.cust=c;
	}
	
	
	
}
