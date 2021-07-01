package com.ust.purchase.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ust.purchase.model.Purchase;
import com.ust.purchase.repository.PurchaseRepository;

@Service
public class PurchaseServiceImpl implements PurchaseService {

	private PurchaseRepository repo;

	@Autowired
	public PurchaseServiceImpl(PurchaseRepository thePurchaseRepository) {
		repo = thePurchaseRepository;
	}

	@Override
	public List<Purchase> findAll() {
		return repo.findAll();
	}

	@Override
	public Purchase findById(int theId) {
		Optional<Purchase> result = repo.findById(theId);
		Purchase thePurchase = null;
		if (result.isPresent()) {
			thePurchase = result.get();
		} else {
			throw new RuntimeException("Did not find supplier id - " + theId);
		}

		return thePurchase;
	}

	
	
	@Override
	public Purchase findByName(String name) {
		Optional<Purchase> result = repo.findBySupplierName(name);
		Purchase thePurchase = null;
		if (result.isPresent()) {
			thePurchase = result.get();
		} else {
			throw new RuntimeException("Did not find supplier Name - " + name);
		}

		return thePurchase;
	}
	
	
	@Override
	public Purchase savePurchase(Purchase thePurchase) {
      		 repo.save(thePurchase);
      		 return thePurchase;
      		

	}

	@Override
	public boolean deleteByName(String name) {
		@SuppressWarnings("unused")
		Optional<Purchase> optional =repo.findBySupplierName(name);
		Purchase supplierByName = repo.findBySupplierName(name).get();
		repo.delete(supplierByName);
		return true;
		

	}
	
	

	
	@Override
	public Purchase updatePurchase(Purchase purchase) throws Exception {
		Optional<Purchase> tempPurchase=repo.findById(purchase.getId());
		if(! tempPurchase.isPresent()) {
			throw new Exception("Supplier is not  present");
		}
		
		
		return repo.save(purchase);
		
	}

//		if(repo.existsById(purchase.getId())) {
//			Purchase save = repo.save(purchase);
//					return save;
//		}
//		else
////			throw new Exception();
//	try {
//		
//		return repo.findBySupplierName(name).get();
//	}
//	catch (NoSuchElementException e){
//		throw new Exception();
//	}
		
	}
	


