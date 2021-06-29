//package com.ust.purchase.controller;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.assertFalse;
//import static org.junit.jupiter.api.Assertions.assertNull;
//import static org.junit.jupiter.api.Assertions.assertTrue;
//
//import java.util.List;
//
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.TestMethodOrder;
//import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
//import org.junit.jupiter.api.Order;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import com.ust.purchase.model.Purchase;
//import com.ust.purchase.repository.PurchaseRepository;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
//@TestMethodOrder(OrderAnnotation.class)
//class PurchaseControllerTest {
//
//	
//	   @Autowired
//	    private PurchaseRepository repo;
//	
//	   @Test
//	   @Rollback(false)
//	   @Order(1)
//	   void testFindAll() {
//		
//		 Purchase savedPurchase = new Purchase("Tata", "India");
//		 repo.save(savedPurchase);
//	     
////		    assertThat(savedPurchase.getSupplierId()).isGreaterThan(0);
//		
//		
//	}
//	   
//	   @Test
//	   @Rollback(false)
//	   @Order(2)
//	   public void testCreateProduct() {
//	       Purchase savedProduct = repo.save(new Purchase("Honda", "Japan"));
//	        
//	       assertThat(savedProduct.getSupplierId()).isGreaterThan(0);
//	   }
//	   
//	   
////
////	@Test
////	void testAddPurchase() {
////		fail("Not yet implemented");
////	}
////
//	@Test
//	@Rollback(false)
//	@Order(3)
//	void testGetPurchaseBySupplierName() {
//		String name="Honda";
//		Purchase purchase=repo.findBysupplierName(name);
//		
//		assertThat(purchase.getSupplierName()).isEqualTo(name);
//	}
//	
//	@Test
//	@Rollback(false)
//	@Order(4)
//	void testGetPurchaseByInvalidSupplierName() {
//		String name="Suzuki";
//		Purchase purchase=repo.findBysupplierName(name);
//		
//		assertNull(purchase);
//	}
//	
//
//
//	@Test
//	@Rollback(false)
//	@Order(5)
//	void testUpdatePurchase() {
//		
//		String sName="Toyota";
//		Purchase purchase=new Purchase(sName,"Japan");
//		purchase.setSupplierId(2);
//		
//		repo.save(purchase);
//		
//		Purchase updatedPurchase=repo.findBysupplierName(sName);
//		assertThat(updatedPurchase.getSupplierName()).isEqualTo(sName);
//		
//	}
//	
//	@Test
//	@Rollback(false)
//	public void testListProducts() {
//		
//	List <Purchase> purchase=repo.findAll();
//	
//	for(Purchase purchases :purchase) {
//		System.out.println(purchases);
//	}
//	
//	assertThat(purchase).size().isGreaterThan(0);
//		
//	}
//	
//	
//	@Test
//	@Rollback(false)
//	@Order(6)
//	void testDeletePurchase() {
//		Integer id=2;
//		boolean isExistBeforeDelete=repo.findById(id).isPresent();
//		repo.deleteById(id);
//		
//		boolean notExistAfterDelete=repo.findById(id).isPresent();
//		assertTrue(isExistBeforeDelete);
//		assertFalse(notExistAfterDelete);
//	}
//
//}
