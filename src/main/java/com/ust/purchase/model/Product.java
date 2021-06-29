package com.ust.purchase.model;

public class Product {

	private int productId;
	private String productName;
	private String productDesc;
	private String quantity;
	private int price;
	
	
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
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
	public Product(int productId, String productName, String productDesc, String quantity, int price) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.productDesc = productDesc;
		this.quantity = quantity;
		this.price = price;
	}
	public Product() {
		super();
	
	}
	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", productDesc=" + productDesc
				+ ", quantity=" + quantity + ", price=" + price + "]";
	}
	
	
	
	
}
