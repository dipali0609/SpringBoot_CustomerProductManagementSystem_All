package com.edu.dao;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Entity
public class Customer 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="custometid")
private int custometid;
	@Column(length=50)
	@NotBlank(message = "Enter the Costomer Name")
private String customername;
	@Column(length = 50)
	@NotBlank(message = "Enter the Customer Location")
private String customerlocation;
	@Min(value = 18,message = "customer minimum age should be greter than 18")
	@Max(value = 70,message = "customer maximum age should be less than 70")
private int customerage;
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Customer(int custometid, @NotBlank(message = "Enter the Costomer Name") String customername,
			@NotBlank(message = "Enter the Customer Location") String customerlocation,
			@Min(value = 18, message = "customer minimum age should be greter than 18") @Max(value = 70, message = "customer maximum age should be less than 70") int customerage) {
		super();
		this.custometid = custometid;
		this.customername = customername;
		this.customerlocation = customerlocation;
		this.customerage = customerage;
	}
	
//	"customername":"Rutuja",
//    "customerlocation":"Mumbai",
//    "customerage":22
    @OneToMany(mappedBy = "cust")
    Set<Product> prod=new HashSet<>();
	public Set<Product> getProd() {
		return prod;
	}
	public void setProd(Set<Product> prod) {
		this.prod = prod;
	}
	
	
	
	public int getCustometid() {
		return custometid;
	}
	public void setCustometid(int custometid) {
		this.custometid = custometid;
	}
	public String getCustomername() {
		return customername;
	}
	public void setCustomername(String customername) {
		this.customername = customername;
	}
	public String getCustomerlocation() {
		return customerlocation;
	}
	public void setCustomerlocation(String customerlocation) {
		this.customerlocation = customerlocation;
	}
	public int getCustomerage() {
		return customerage;
	}
	public void setCustomerage(int customerage) {
		this.customerage = customerage;
	}
	@Override
	public String toString() {
		return "Customer [custometid=" + custometid + ", customername=" + customername + ", customerlocation="
				+ customerlocation + ", customerage=" + customerage + "]";
	}

	
    

}
