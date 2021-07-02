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

import com.ust.purchase.exception.PurchaseAlreadyExists;
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
	public ResponseEntity<?> save(@RequestBody Purchase purchase) throws PurchaseAlreadyExists {
		try {
			purchaseService.save(purchase);
			return new ResponseEntity<Purchase>(purchase, HttpStatus.CREATED);

		} catch (Exception e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/allPurchases")
	public ResponseEntity<?> findAll() {

		try {
			List<Purchase> purchaseList = purchaseService.findAll();
			return new ResponseEntity<List<Purchase>>(purchaseList, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<String>("Empty Data", HttpStatus.FORBIDDEN);
		}
	}

	@GetMapping("/purchases/{supplierId}")
	public ResponseEntity<?> getPurchaseById(@PathVariable("supplierId") int supplierId) {
		try {
			return new ResponseEntity<Purchase>(purchaseService.findById(supplierId), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Supplier ID Not Found", HttpStatus.FORBIDDEN);
		}
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
	public ResponseEntity<?> deleteOrder(@PathVariable("supplierId") int supplierId) {
		try {
			Purchase purchase = purchaseService.deleteById(supplierId);
			return new ResponseEntity<Purchase>(purchase, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>("Supplier ID Not Found", HttpStatus.FORBIDDEN);
		}
	}

}
