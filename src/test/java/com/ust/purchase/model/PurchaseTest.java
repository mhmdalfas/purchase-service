package com.ust.purchase.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class PurchaseTest {
	

	
	@Test
    public void PurchaseTest() {
        new BeanTester().testBean(Purchase.class);
    }


}
