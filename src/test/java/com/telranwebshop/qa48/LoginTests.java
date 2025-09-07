package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{

    @Test
    public void loginPositiveTest() {
        click(By.cssSelector("a[href='/login']"));

        type(By.id("Email"), "tati123@gmail.com");

        type(By.id("Password"), "Tati123!");

        click(By.cssSelector(".button-1.login-button"));

        Assert.assertTrue(driver.findElement(By.cssSelector("a[href='/logout']")).isDisplayed(),
                "Logout button not found, login failed!");
    }



}
