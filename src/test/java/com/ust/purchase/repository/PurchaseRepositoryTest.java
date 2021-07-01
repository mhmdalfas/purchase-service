package com.ust.purchase.repository;

import java.util.NoSuchElementException;

import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.ust.purchase.model.Purchase;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class PurchaseRepositoryTest {

	@Autowired
	private PurchaseRepository repo;

	Purchase purchase = new Purchase(01,"John","Doe",null);

	@Test
	public void registerPurchaseTest() {
		repo.save(purchase);
		Purchase fetchedUser = repo.findById(01).get();
		Assert.assertEquals(purchase.getSupplierId(), fetchedUser.getSupplierId());
	}

	@Test
	public void deletePurchaseTest() {
		Assertions.assertThrows(NoSuchElementException.class, () -> {
			repo.save(purchase);
			Purchase fetchedPurchase = repo.findById(1).get();
			Assert.assertEquals(1, fetchedPurchase.getSupplierId());
			repo.delete(fetchedPurchase);
			fetchedPurchase = repo.findById(1).get();
		});
	}

	@Test
	public void updatePurchaseTest() {
		repo.save(purchase);
		Purchase fetchedPurchase = repo.findById(1).get();
		repo.save(fetchedPurchase);
		fetchedPurchase = repo.findById(1).get();
		Assert.assertEquals(1, fetchedPurchase.getSupplierId());
	}

	@Test
	public void getPurchaseByIdTest() {
		repo.save(purchase);
		Purchase fetchedPurchase = repo.findById(1).get();
		Assert.assertEquals(purchase.getSupplierId(), fetchedPurchase.getSupplierId());
	}
}
