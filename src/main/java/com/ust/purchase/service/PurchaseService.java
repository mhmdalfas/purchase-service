package com.ust.purchase.service;

import java.util.List;


import com.ust.purchase.model.Purchase;

public interface PurchaseService {

	
	public List<Purchase> findAll();
	
	public Purchase findById(int theId);
	
	public Purchase savePurchase(Purchase thePurchase);
	
	public boolean deleteByName(String name);
	
//	Purchase updatePurchase(Purchase purchase) throws Exception;

	Purchase findByName(String name);

	Purchase updatePurchase(Purchase purchase) throws Exception;
	
}
