package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.List;



public class RemoveFromCartTest extends TestBase{
@BeforeMethod
public void precondition() {
    driver.get("https://demowebshop.tricentis.com");
    // Добавляем товар в корзину
    click(By.linkText("Books"));  // выбираем категорию Books
    List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
    products.get(0).click();  // выбираем первый товар
    click(By.cssSelector("input[value='Add to cart']"));
    // Ждем появления уведомления
    Assert.assertTrue(driver.findElement(By.cssSelector("p.content"))
            .getText().contains("The product has been added to your shopping cart"));
}
    @Test
    public void removeFromCartTest() {
        // Переходим в корзину
        click(By.cssSelector("a[href='/cart']"));

        // Считаем количество товаров до удаления
        int sizeBefore = driver.findElements(By.cssSelector(".cart-item-row")).size();
        Assert.assertTrue(sizeBefore > 0, "Корзина пуста, нечего удалять!");

        // Кликаем на чекбокс Remove
        click(By.cssSelector("input[name='removefromcart']"));

        // Жмем кнопку обновить корзину
        click(By.name("updatecart"));

        // Проверяем количество товаров после удаления
        int sizeAfter = driver.findElements(By.cssSelector(".cart-item-row")).size();

        Assert.assertEquals(sizeAfter, sizeBefore - 1,
                "Товар не удалился из корзины!");
    }
}