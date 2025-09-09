package com.telranwebshop.fw;

import com.telranwebshop.models.User;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UserHelper extends BaseHelper {
    public UserHelper(WebDriver driver) {
        super(driver);
    }

    public void registrationPagaEnterPassword() {
         driver.findElement(By.id("Password")).clear();
         driver.findElement(By.id("Password")).sendKeys("Tati123!");
         driver.findElement(By.id("ConfirmPassword")).clear();
         driver.findElement(By.id("ConfirmPassword")).sendKeys("Tati123!");
     }

    public void clickOnRegistrationButton() {
        click(By.id("register-button"));
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
        click(By.id("gender-male"));
    }

    public void fillRegisterForm() {
        click(By.cssSelector("a[href='/register']"));
    }

   public boolean isLogoutButtonDisplayed() {
        return driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed();
    }

    public void clickOnLoginButton() {
        click(By.cssSelector(".button-1.login-button"));
    }

    public void fillRegiserLoginForm(User user) {
        type(By.id("Email"), user.getEmail());
        type(By.id("Password"), user.getPassword());
    }

    public void clickOnLoginLink() {
        click(By.cssSelector("a[href='/login']"));
    }
}
