package com.ust.purchase.exception;

@SuppressWarnings("serial")
public class PurchaseAlreadyExists extends Exception {

	public PurchaseAlreadyExists(String message) {
		super(message);
	}
}