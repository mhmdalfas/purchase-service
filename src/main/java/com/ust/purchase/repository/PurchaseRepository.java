package com.ust.purchase.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ust.purchase.model.Purchase;

public interface PurchaseRepository extends MongoRepository<Purchase,Integer>{
	
	//public Purchase findBysupplierName(String supplierName);

}
