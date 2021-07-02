package com.ust.purchase.service;

import java.util.List;

import com.ust.purchase.exception.PurchaseAlreadyExists;
import com.ust.purchase.model.Purchase;

public interface PurchaseService {

	
	public List<Purchase> findAll();
	
	public Purchase findById(int theId);
	
	public Purchase save(Purchase thePurchase) throws PurchaseAlreadyExists;
	
	public Purchase deleteById(int theId);
	
	Purchase updatePurchase(Purchase purchase) throws Exception;
	
}
