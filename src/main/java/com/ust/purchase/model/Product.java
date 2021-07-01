package com.ust.purchase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name="product")
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String productName;
	private String productDesc;
	private String quantity;
	private int price;
	
	@ManyToOne
	@JoinColumn(name="supplier_id")
	private Purchase  purchase;
	
	
	
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public Purchase getPurchase() {
		return purchase;
	}
	public void setPurchase(Purchase purchase) {
		this.purchase = purchase;
	}
	public Product() {
		super();
		
	}
	public Product(String productName, String productDesc, String quantity, int price ) {
		super();
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.price = price;
		
	}
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", productDesc=" + productDesc + ", quantity=" + quantity
				+ ", price=" + price +"]";
	}
	

	
	
	
}
