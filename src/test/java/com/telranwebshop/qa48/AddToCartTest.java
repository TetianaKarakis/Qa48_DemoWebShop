package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class AddToCartTest extends TestBase {

    @Test
    public void addFirstItemFromApparelTest() {
        addToCart("Apparel & Shoes", 1);
    }


    public void addSecondItemFromBooksTest() {
        addToCart("Books", 2);
    }
}

