package com.ust.purchase.model;

import org.junit.jupiter.api.Test;
import org.meanbean.test.BeanTester;

public class ProductTest {

	@Test
    public void ProductTest() {
        new BeanTester().testBean(Product.class);
    }

}
