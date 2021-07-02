package com.ust.purchase.model;

import java.util.List;



import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;



@Document(collection = "supplier")
public class Purchase {

	@Id
	@Indexed(unique=true)
	private int supplierId;
	private String supplierName;
	private String sAddress;
	 
	
	private List<Product> product;
	
	
	
	public int getSupplierId() {
		return supplierId;
	}
	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}
	public String getsAddress() {
		return sAddress;
	}
	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}
	public String getSupplierName() {
		return supplierName;
	}
	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	
	
	
	public Purchase() {
		
	}
	
	
	
	
	
	
	public Purchase(int supplierId, String supplierName, String sAddress, List<Product> product) {
		super();
		this.supplierId = supplierId;
		this.supplierName = supplierName;
		this.sAddress = sAddress;
		this.product = product;
	}
	@Override
	public String toString() {
		return "Purchase [supplierId=" + supplierId + ", supplierName=" + supplierName + ", sAddress=" + sAddress
				+ ", product=" + product + "]";
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	
	
}
