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
	public PurchaseServiceImpl(PurchaseRepository thePurchaseRepository)
	{
		repo=thePurchaseRepository;
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
		}
		else {
			// we didn't find the employee
			throw new RuntimeException("Did not find supplier id - " + theId);
		}
		
		return thePurchase;
	}
		
		
	


	@Override
	public void save(Purchase thePurchase) {
		repo.save(thePurchase);
		
	}


	@Override
	public void deleteById(int theId) {
		repo.deleteById(theId);
		
	}

}
