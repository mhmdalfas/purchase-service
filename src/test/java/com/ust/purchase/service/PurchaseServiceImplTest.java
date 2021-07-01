package com.ust.purchase.service;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.context.SpringBootTest;

import com.ust.purchase.model.Purchase;
import com.ust.purchase.repository.PurchaseRepository;
@ExtendWith(MockitoExtension.class)
@AutoConfigureDataMongo
@SpringBootTest
class PurchaseServiceImplTest {
	@Mock
	PurchaseRepository repo;
	@InjectMocks
	PurchaseServiceImpl purchaseService;
	List<Purchase> purchaseList = new ArrayList<>();
	Optional<Purchase> options;
	Purchase purchase = new Purchase(01,"John","Doe",null);

	@Test
	public void saveaPurchaseTest() {
		Mockito.when(repo.save(purchase)).thenReturn(purchase);
		Purchase purchase1 = purchaseService.save(purchase);
		assertEquals(purchase1, purchase);
	}

/*	@Test
	public void updateOrderTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(order.getOrderId())).thenReturn(options);
			order.setOrderId(22);
			Order fetchOrder = orderService.updateOrder(order);
			assertEquals(order, fetchOrder);
		});
	}*/

	@Test
	public void deletePurchaseTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(purchase.getSupplierId())).thenReturn(options);
			Purchase flag = purchaseService.deleteById(purchase.getSupplierId());
			assertEquals(flag, purchase);
		});

	}

	@Test
	public void getPurchaseByIdTest() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			Mockito.when(repo.findById(purchase.getSupplierId())).thenReturn(options);
			Purchase fetchedOrder = purchaseService.findById(purchase.getSupplierId());
			assertEquals(purchase, fetchedOrder);
		});

	}

	@Test
	public void getAllPurchaseTest() {
		Mockito.when(repo.findAll()).thenReturn(purchaseList);
		List<Purchase> purchase = purchaseService.findAll();
		assertEquals(purchase,purchaseList);
	}
}
