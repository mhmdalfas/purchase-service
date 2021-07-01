package com.ust.purchase.controller;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withCreatedEntity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.ust.purchase.model.Product;
import com.ust.purchase.model.Purchase;
import com.ust.purchase.service.PurchaseService;


@RunWith(SpringRunner.class)
@WebMvcTest
class PurchaseControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	PurchaseService purchaseService;
	@InjectMocks
	PurchaseController purchaseController;
	
	
	Purchase purchase;
	Product product = null;
	
	
	 List<Product> product1 = new ArrayList<Product>();

	    public void setProduct(List<Product> product1) {
	        product1.add(new Product("Karnataka", "123456","647",5));
	    }
	 @BeforeEach
	    public void setUp() {
	  
//	        Product add=new Product(6,"String1","String2","String3",123456);
//	        purchase=new Purchase(10,"String1","String2",product );
	        
//	        product = new Product(6,"String1","String2");
//			purchase = new Purchase(10,"String1","String2",product);
//			allUsers.add(user2);
			
			purchase = new Purchase(01,"John","Doe",(List<Product>) product1);
	       

	    }
//	 @Test
//		public void insertPersonTest() throws Exception {
//			when(purchaseService.save(purchase)).thenReturn(true);
//			mockMvc.perform(MockMvcRequestBuilders.post("/api/add").contentType(MediaType.APPLICATION_JSON)
//					.content(new Gson().toJson(purchase))).andExpect(MockMvcResultMatchers.status().isExpectationFailed());
//		}

	        
//	 @Test
//		void testSaveUserAndReturnSavedDetails() throws Exception {
//			when(purchaseService.savePurchase(purchase)).thenReturn(purchase);
//			
//			mockMvc.perform(post("/api/add")
//					.contentType(MediaType.APPLICATION_JSON)
//					.content(convertStringtoJSON(purchase)))
//				.andExpect(status().isCreated())
//				.andDo(MockMvcResultHandlers.print());
//			
//			verify(purchaseService, times(1)).savePurchase(purchase);
//		}
	 
	 @Test
		public void insertPersonTest() throws Exception {
			when(purchaseService.savePurchase(purchase)).thenReturn(purchase);
			mockMvc.perform(MockMvcRequestBuilders.post("/api/add").contentType(MediaType.APPLICATION_JSON)
					.content(new Gson().toJson(purchase))).andExpect(MockMvcResultMatchers.status().is2xxSuccessful());
	 }
	 
	 @Test
	    void updateData() throws Exception {
	        when(purchaseService.updatePurchase(purchase)).thenReturn(purchase);
	        mockMvc.perform(MockMvcRequestBuilders.put("/api/purchases/").contentType(MediaType.APPLICATION_JSON)
	                .content(new Gson().toJson(purchase))).andExpect(MockMvcResultMatchers.status().isOk());

	    }
	 
	 
	 
	 public static String convertStringtoJSON(Object object) throws Exception {
			try {
				return new ObjectMapper().writeValueAsString(object);
				
			}catch(Exception e) {
				throw new Exception();
			}
	       
	    }}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@SuppressWarnings("deprecation")
//@Before
//	public void setUp() {
//		MockitoAnnotations.initMocks(this);
//		mockMvc = MockMvcBuilders.standaloneSetup(purchaseController).build();
//	     
//		Product add =new Product(6,"String1","String2","String3",123456);
//		purchase=new Purchase(11,"String1","String2",product);
//		
//		
//
//	}
//
//	@Test
//	void registerSupplierTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(purchaseService.save(purchase)).thenThrow(new NullPointerException("Error occurred"));
//			mockMvc.perform(
//					post("/add").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//					.andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//		});
//
//	}
//
//	@Test
//	void updateSupplierTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(purchaseService.updatePurchase(purchase)).thenThrow(new NullPointerException("Invalid Input"));
//			mockMvc.perform(
//					put("/customer/kkkk").contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON))
//					.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//	}
//
//	@Test
//	void deletePurchaseTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(purchaseService.deleteById(4)).thenReturn(purchase);
//			mockMvc.perform(MockMvcRequestBuilders.delete("/user/Jack998").contentType(MediaType.APPLICATION_JSON))
//					.andExpect(MockMvcResultMatchers.status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//
//	}
//
//	@Test
//	void getCustomerBySupplierIdTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(purchaseService.findById(1)).thenReturn(purchase);
//			mockMvc.perform(get("/api/purchases").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk())
//					.andDo(MockMvcResultHandlers.print());
//		});
//
//	}
//
//	@SuppressWarnings("unchecked")
//	@Test
//	void getAllPurchaseTest() throws Exception {
//		Assertions.assertThrows(NullPointerException.class, () -> {
//			when(purchaseService.findAll()).thenReturn((List<Purchase>) purchase);
//			mockMvc.perform(get("/api/find").contentType(MediaType.APPLICATION_JSON))
//					.andExpect(status().isOk()).andDo(MockMvcResultHandlers.print());
//		});
//	}


