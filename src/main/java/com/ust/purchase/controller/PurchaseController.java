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

import com.ust.purchase.exception.SupplierNotFound;
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
	public ResponseEntity<?> save(@RequestBody Purchase purchase) {
		try {
		return new ResponseEntity<Purchase>( purchaseService.savePurchase(purchase),HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<String>("Wrong Input",HttpStatus.CONFLICT);
		}
	}

	@GetMapping("/allPurchases")
//	public ResponseEntity<List<Purchase>> findAll() {
//
//		List<Purchase> purchaseList = purchaseService.findAll();
//		return new ResponseEntity<List<Purchase>>(purchaseList, HttpStatus.OK);

	public List<Purchase> getAllUsers() {
		List<Purchase> allUsers =purchaseService.findAll();
//		return new ResponseEntity<>(allUsers, HttpStatus.OK);
		return allUsers;
	}

	@GetMapping("/purchases/{supplierName}")
	public ResponseEntity<?> getPurchaseById(@PathVariable("supplierName") String SupplierName) {
		
		try {
		return new ResponseEntity<Purchase>(purchaseService.findByName(SupplierName), HttpStatus.OK);}
		catch(Exception e){ 
			return new ResponseEntity<String>("Wrong Input",HttpStatus.CONFLICT);
		}
	}

	@PutMapping("/purchases/")
	public ResponseEntity<?> updatePurchase(@RequestBody  Purchase purchase) throws Exception {

		try {
			return new ResponseEntity<Purchase>(purchaseService.updatePurchase(purchase), HttpStatus.OK);
		} catch (SupplierNotFound e) {
			return new ResponseEntity<String>(e.getMessage(),HttpStatus.OK);
		}

	}

	@DeleteMapping("/purchases/{supplierName}")
	public ResponseEntity<Purchase> deleteOrder(@PathVariable("supplierName") String supplierName) {
		boolean purchase = purchaseService.deleteByName(supplierName);
		return new ResponseEntity<Purchase>(HttpStatus.OK);
	}

}
