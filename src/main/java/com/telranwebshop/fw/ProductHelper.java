package com.telranwebshop.fw;

import com.telranwebshop.models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class ProductHelper extends BaseHelper {
    public ProductHelper(WebDriver driver) {
        super(driver);
    }

    public void openHomePage() {
         driver.get("https://demowebshop.tricentis.com");
     }

    public void assertProductAdded() {
           WebElement notification = driver.findElement(By.cssSelector("p.content"));
           Assert.assertTrue(notification.getText().contains("The product has been added to your shopping cart"),
                   "Товар не добавлен в корзину!");
       }

    public void selectProductByIndex(int index) {
           List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
           products.get(index - 1).click();
       }

    public void addToCart() {
           click(By.cssSelector("input[value='Add to cart']"));
       }

    public void openCategory() {
           click(By.linkText("Books"));
       }

    public void verifyProductAddedToCart() {
          Assert.assertTrue(driver.findElement(By.cssSelector("p.content"))
                  .getText().contains("The product has been added to your shopping cart"));
      }

    public void selectProduct() {
          List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
          products.get(0).click();  // выбираем первый товар
      }

    public int getSize() {
        // проверяем, есть ли сообщение о пустой корзине
        List<WebElement> emptyCart = driver.findElements(By.cssSelector(".order-summary-content"));
        if (!emptyCart.isEmpty() && emptyCart.get(0).getText().contains("Your Shopping Cart is empty!")) {
            return 0;
        }

        // если сообщение не найдено, считаем строки с товарами
        return driver.findElements(By.cssSelector(".cart-item-row")).size();
    }


    public void goToCart() {
           click(By.cssSelector("a[href='/cart']"));
       }

    public void removeFirstProduct() {
        click(By.cssSelector("input[name='removefromcart']"));
        click(By.name("updatecart"));

        // ждём пока корзина обновится
        new WebDriverWait(driver, Duration.ofSeconds(5))
                .until(ExpectedConditions.or(
                        ExpectedConditions.textToBePresentInElementLocated(
                                By.cssSelector(".order-summary-content"),
                                "Your Shopping Cart is empty!"),
                        ExpectedConditions.numberOfElementsToBe(
                                By.cssSelector(".cart-item-row"), 0)
                ));
    }

    public void addProductToCart(Product product) {
        // открыть категорию
        click(By.linkText(product.getCategory()));

        // выбрать товар по индексу
        List<WebElement> products = driver.findElements(By.cssSelector(".product-item .product-title a"));
        products.get(product.getIndex() - 1).click();

        // кликнуть "Add to cart"
        click(By.cssSelector("input[value='Add to cart']"));

        // добавить явное ожидание уведомления
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement notification = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.cssSelector("p.content")
        ));

        // проверить текст уведомления
        Assert.assertTrue(notification.getText().contains("The product has been added to your shopping cart"),
                "Товар не добавлен в корзину!");
    }
}
