package com.ust.purchase.service;

import java.util.List;

import com.ust.purchase.model.Purchase;

public interface PurchaseService {

	
	public List<Purchase> findAll();
	
	public Purchase findById(int theId);
	
	public void save(Purchase thePurchase);
	
	public void deleteById(int theId);
	
}
