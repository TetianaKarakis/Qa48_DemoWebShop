package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class AddToCartTest extends TestBase {

    @BeforeMethod
    public  void precondition(){
        driver.get("https://demowebshop.tricentis.com");
    }
@Test
public void addToCarts() {
    // Переходим в категорию
    click(By.linkText("Books"));  // например, выбираем категорию Books

    // Находим список товаров и выбираем 1-й
    List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
    int productIndex = 1; // первый товар

    products.get(productIndex - 1).click();

    // Нажимаем "Add to cart"
    click(By.cssSelector("input[value='Add to cart']"));

    // Проверяем уведомление о добавлении в корзину
    WebElement notification = driver.findElement(By.cssSelector("p.content"));
    Assert.assertTrue(notification.getText().contains("The product has been added to your shopping cart"),
            "Товар не добавлен в корзину!");
}
}
