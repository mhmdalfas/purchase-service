package com.ust.purchase.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "purchase")
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String supplierName;
	private String sAddress;

	@OneToMany(targetEntity = Product.class, cascade = CascadeType.ALL)
	private List<Product> product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	public Purchase(int id, String supplierName, String sAddress, List<Product> product) {
		super();
		this.id = id;
		this.supplierName = supplierName;
		this.sAddress = sAddress;
		this.product = product;
	}

	public Purchase() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Purchase [ supplierName=" + supplierName + ", sAddress=" + sAddress + ", product="
				+ product + "]";
	}

	
	}


