package com.telranwebshop.qa48;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public  void precondition(){
        openHomePage();
    }@Test
public void addToCarts() {
        openCategory();
        selectProductByIndex(1);
        addToCart();
        assertProductAdded();
}
    @Test
    public void addBookToCartTest() {
        addProductToCart(new Product().setCategory("Books").setIndex(1));   // категория Books, первый товар
    }
}
