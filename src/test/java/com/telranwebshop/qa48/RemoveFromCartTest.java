package com.telranwebshop.qa48;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class RemoveFromCartTest extends TestBase{
@BeforeMethod
public void precondition() {
    openHomePage();
    openCategory();
    selectProduct();
    addToCart();
    verifyProductAddedToCart();
}

    @Test
    public void removeFromCartTest() {
    goToCart();
    int sizeBefore = getSize();
    Assert.assertTrue(sizeBefore > 0, "Корзина пуста, нечего удалять!");
    removeFirstProduct();
    int sizeAfter = getSize();
    Assert.assertEquals(sizeAfter, sizeBefore - 1,
                "Товар не удалился из корзины!");
    }

}