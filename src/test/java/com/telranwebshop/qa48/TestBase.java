package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class TestBase {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    public boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }


    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }
    // добавления товара в корзину
    public void addToCart(String category, int productIndex) {
        // Переходим в категорию
        click(By.linkText(category));

        // Находим список товаров и выбираем нужный
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
        if (products.size() < productIndex || productIndex <= 0) {
            throw new IllegalArgumentException("Нет товара с таким индексом: " + productIndex);
        }

        products.get(productIndex - 1).click();

        // Нажимаем "Add to cart"
        click(By.cssSelector("input[value='Add to cart']"));

        // Проверяем уведомление о добавлении в корзину
        WebElement notification = driver.findElement(By.cssSelector("p.content"));
        Assert.assertTrue(notification.getText().contains("The product has been added to your shopping cart"),
                "Товар не добавлен в корзину!");
    }

    // удаления одного товара из корзины по индексу
    public void removeItemFromCart(int itemIndex) {
        // Переходим в корзину
        click(By.cssSelector("a[href='/cart']"));

        // Получаем список чекбоксов удаления
        List<WebElement> removeCheckboxes = driver.findElements(By.cssSelector("input[name='removefromcart']"));

        if (removeCheckboxes.isEmpty()) {
            throw new IllegalStateException("Корзина пуста, нечего удалять!");
        }

        if (itemIndex <= 0 || itemIndex > removeCheckboxes.size()) {
            throw new IllegalArgumentException("Нет товара с таким индексом: " + itemIndex);
        }

        // Отмечаем нужный товар для удаления
        removeCheckboxes.get(itemIndex - 1).click();

        // Обновляем корзину
        click(By.name("updatecart"));

        // Проверяем, что количество товаров уменьшилось
        List<WebElement> remainingItems = driver.findElements(By.cssSelector("input[name='removefromcart']"));
        Assert.assertEquals(remainingItems.size(), removeCheckboxes.size() - 1,
                "Товар не был удалён из корзины!");
    }
}




