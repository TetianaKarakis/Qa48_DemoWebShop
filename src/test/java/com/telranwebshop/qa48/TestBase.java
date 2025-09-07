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

    public boolean isLogoutLinkDisplayed() {
         return driver.findElement(By.linkText("Log out")).isDisplayed();
     }

    public void registrationPagaEnterPassword() {
         driver.findElement(By.id("Password")).clear();
         driver.findElement(By.id("Password")).sendKeys("Tati123!");
         driver.findElement(By.id("ConfirmPassword")).clear();
         driver.findElement(By.id("ConfirmPassword")).sendKeys("Tati123!");
     }

    public void clickOnRegistrationButton() {
         driver.findElement(By.id("register-button")).click();
     }

    public void registrationPageEnterEmail() {
         String email = "tati" + System.currentTimeMillis() + "@gmail.com";
         driver.findElement(By.id("Email")).clear();
         driver.findElement(By.id("Email")).sendKeys(email);
     }

    public void enterLastName() {
         driver.findElement(By.id("LastName")).clear();
         driver.findElement(By.id("LastName")).sendKeys("Karakis");
     }

    public void enterFirstName() {
         driver.findElement(By.id("FirstName")).clear();
         driver.findElement(By.id("FirstName")).sendKeys("Tetiana");
     }

    public void registerSelectGender() {
         driver.findElement(By.id("gender-male")).click(); // или "gender-female"
     }

    public void fillRegisterForm() {
         driver.findElement(By.cssSelector("a[href='/register']")).click();
     }

    protected boolean isLogoutButtonDisplayed() {
        return driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed();
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void fillRegiserLoginForm(String email, String password) {
        type(By.id("Email"), email);
        type(By.id("Password"), password);
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a[href='/login']"));
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
           return driver.findElements(By.cssSelector(".cart-item-row")).size();
       }

    public void goToCart() {
           click(By.cssSelector("a[href='/cart']"));
       }

    public void removeFirstProduct() {
         click(By.cssSelector("input[name='removefromcart']"));


         click(By.name("updatecart"));
     }


    // удаления одного товара из корзины по индексу

}




