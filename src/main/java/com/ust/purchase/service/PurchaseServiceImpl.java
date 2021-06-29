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
	public Purchase save(Purchase thePurchase) {
      	return	repo.save(thePurchase);

	}

	@Override
	public Purchase deleteById(int supplierId) {
		@SuppressWarnings("unused")
		Optional<Purchase> optional =repo.findById(supplierId);
		Purchase supplierById = repo.findById(supplierId).get();
		repo.deleteById(supplierId);
		return supplierById;
		

	}

	@Override
	public Purchase updatePurchase(Purchase purchase) throws Exception {
		if(repo.existsById(purchase.getSupplierId())) {
			Purchase save = repo.save(purchase);
					return save;
		}
		else
			throw new Exception();
	}
	}


