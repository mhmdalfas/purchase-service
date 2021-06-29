package com.ust.purchase.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.purchase.model.Purchase;
import com.ust.purchase.service.PurchaseService;

@RestController
@RequestMapping("/api")
public class PurchaseController {

	
	
	
	private PurchaseService purchaseService;
	
	@Autowired
	public PurchaseController(PurchaseService thePurchaseService) {
		purchaseService = thePurchaseService;
	}
	
	
	
	
	
	@GetMapping("/purchases")
	public ResponseEntity <List<Purchase>> findAll() {
		
		List<Purchase> purchaseList =purchaseService.findAll();
		return new ResponseEntity<List<Purchase>>( purchaseList,HttpStatus.OK);
		
	}
	
	
	
	
	@PostMapping("/purchases")
	public Purchase addPurchase(@RequestBody Purchase thePurchase) {
		
	
		
		thePurchase.setSupplierId(0);
		
		purchaseService.save(thePurchase);
		
		return thePurchase;
	}
	
	

	
	
	
	
	@GetMapping("/purchases/{supplierId}")
	public Purchase getPurchase(@PathVariable int supplierId){
	
		Purchase purchases = purchaseService.findById(supplierId);
		if(purchases==null) {
			throw new RuntimeException("Supplier id not found");
		}
			return purchases;
		}
	
	
	
	
		
		@PutMapping("/purchases")
		public Purchase updatePurchase(@RequestBody Purchase thePurchase) {
			
			purchaseService.save(thePurchase);
			
			return thePurchase;
		}
		
		
		
		
		
		
		@DeleteMapping("/purchases/{supplierId}")
		public String deletePurchase(@PathVariable int purchaseId) {
			
			Purchase tempPurchase = purchaseService.findById(purchaseId);
			
			
			if (tempPurchase == null) {
				throw new RuntimeException("Purchase id not found - " + purchaseId);
			}
			
			purchaseService.deleteById(purchaseId);
			
			return "Deleted purchase id - " + purchaseId;
		}
		
		
	

	}
