package com.ust.purchase.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ust.purchase.model.Purchase;

public interface PurchaseRepository extends JpaRepository<Purchase, Integer> {

	public Optional<Purchase> findBySupplierName(String supplierName);
//	public Optional<Purchase> deleteBySupplierName(String supplierName);

	public Purchase save(Optional<Purchase> getPurchase);

//	public Purchase updateBySupplierName(String supplierName);

}
