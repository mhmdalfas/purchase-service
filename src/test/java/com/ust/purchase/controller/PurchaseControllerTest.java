package com.ust.purchase.controller;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.ust.purchase.model.Product;
import com.ust.purchase.model.Purchase;
import com.ust.purchase.service.PurchaseService;


//@AutoConfigureTestDatabase(replace = Replace.NONE)
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class PurchaseControllerTest {

	
	@Autowired
	private MockMvc mockMvc;
	@Mock
	PurchaseService service;
	@InjectMocks
	PurchaseController controller;
	private Purchase purchase;

	 List<Product> product1 = new ArrayList<Product>();

	    public void setProduct(List<Product> product1) {
	        product1.add(new Product(5,"Karnataka", "123456","647",5));
	    }
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		purchase = new Purchase(01,"John","Doe",(List<Product>) product1);
	}
	
	 @Test
		public void insertPurchaseTest() throws Exception {
		 
		 mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
			purchase = new Purchase(01,"John","Doe",(List<Product>) product1);
			when(service.save(purchase)).thenReturn(purchase);
			mockMvc.perform(MockMvcRequestBuilders.post("/api/add").contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(purchase))).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	 }
	

//	 @Test
//	    void updateData() throws Exception {
//		 mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//			purchase = new Purchase(01,"John","Doe",(List<Product>) product1);
//	        when(service.updatePurchase(purchase));
//	        mockMvc.perform(MockMvcRequestBuilders.put("/api/purchases").contentType(MediaType.APPLICATION_JSON)
//	                .content(new Gson().toJson(purchase))).andExpect(MockMvcResultMatchers.status().isOk());
//
//	    }
	 
	 
	@Test
	void registerOrderTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockMvc.perform(post("/add").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void updateOrderTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(service.updatePurchase(null)).thenThrow(Exception.class);
			mockMvc.perform(put("/update").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void deleteOrderTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockMvc.perform(MockMvcRequestBuilders.delete("/delete/100").contentType(MediaType.APPLICATION_JSON))
					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void getOrderByOrderIdTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			when(service.findById(1)).thenReturn(purchase);
			mockMvc.perform(get("/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print());
		});
	}

	@Test
	void getAllOrdersTest() throws Exception {
		Assertions.assertThrows(NullPointerException.class, () -> {
			mockMvc.perform(get("/all").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
					.andDo(MockMvcResultHandlers.print());
		});
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
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

}
