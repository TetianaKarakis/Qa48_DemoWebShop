package com.telranwebshop.qa48;

import org.testng.annotations.Test;

public class RemoveFromCartTest extends TestBase{

@Test
    public void removeFirstItemFromCartTest() {
        // Добавляем товар в корзину
        addToCart("Books", 1);

        // Удаляем первый товар
        removeItemFromCart(1);
    }
}

