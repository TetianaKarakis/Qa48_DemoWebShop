package com.telranwebshop.qa48;

import com.telranwebshop.models.Product;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public  void precondition(){
        if  (!app.getUser().isLoginLinkPresent()){
            app.getUser().clickOnSignOutButton();
        }
        app.getProduct().openHomePage();
    }


    @Test
public void addToCarts() {
        app.getProduct().openCategory();
        app.getProduct().selectProductByIndex(1);
        app.getProduct().addToCart();
        app.getProduct().assertProductAdded();
}
    @Test
    public void addBookToCartTest() {
        app.getProduct().addProductToCart((new Product().setCategory("Books").setIndex(1)));   // категория Books, первый товар
    }
}
