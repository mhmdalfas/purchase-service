package com.ust.purchase.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.purchase.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase,Integer>{
	
	public Purchase findBysupplierName(String supplierName);

}
