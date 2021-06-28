package com.ust.purchase.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="purchase")
public class Purchase {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	private int supplierId;
	private String supplierName;
	private String sAddress;
	
	
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
	
	
	
	public Purchase(String supplierName, String sAddress) {
		super();
		this.supplierName = supplierName;
		this.sAddress = sAddress;
	}
	@Override
	public String toString() {
		return "Purchase [supplierId=" + supplierId + ", supplierName=" + supplierName + ", sAddress=" + sAddress + "]";
	}
	
	
	
}
