package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveFromCartTest extends TestBase{
@BeforeMethod
public void precondition() {
    app.getProduct().openHomePage();
    app.getProduct().openCategory();
    app.getProduct().selectProduct();
    app.getProduct().addToCart();
    app.getProduct().verifyProductAddedToCart();
}

    @Test
    public void removeFromCartTest() {
    app.getProduct().goToCart();
    int sizeBefore = app.getProduct().getSize();
    Assert.assertTrue(sizeBefore > 0, "Корзина пуста, нечего удалять!");
    app.getProduct().removeFirstProduct();
    int sizeAfter = app.getProduct().getSize();
    Assert.assertEquals(sizeAfter, sizeBefore - 1,
                "Товар не удалился из корзины!");
    }

}