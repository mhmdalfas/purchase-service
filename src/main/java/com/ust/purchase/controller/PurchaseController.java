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

	

	@PostMapping("/add")
	public ResponseEntity<Purchase> save(@RequestBody Purchase purchase) {
		return new ResponseEntity<Purchase>(purchaseService.save(purchase), HttpStatus.CREATED);

	}
	
	
	@GetMapping("/allPurchases")
	public ResponseEntity<List<Purchase>> findAll() {

		List<Purchase> purchaseList = purchaseService.findAll();
		return new ResponseEntity<List<Purchase>>(purchaseList, HttpStatus.OK);

	}

	
	

	@GetMapping("/purchases/{supplierId}")
	public ResponseEntity<Purchase> getPurchaseById(@PathVariable("supplierId") int supplierId) {
			return new ResponseEntity<Purchase>(purchaseService.findById(supplierId), HttpStatus.OK);
	}
	
	
	@PutMapping("/purchases")
	public ResponseEntity<Purchase> updatePurchase(@RequestBody Purchase purchase) throws Exception {

		Purchase purchase1 = purchaseService.updatePurchase(purchase);
		if (purchase1 != null) {
			return new ResponseEntity<>(purchase1, HttpStatus.OK);
		}

		throw new Exception();

	}
	
	@DeleteMapping("/purchases/{supplierId}")
	public ResponseEntity<Purchase> deleteOrder(@PathVariable("supplierId") int supplierId) {
		Purchase purchase = purchaseService.deleteById(supplierId);
		return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
	}

}
