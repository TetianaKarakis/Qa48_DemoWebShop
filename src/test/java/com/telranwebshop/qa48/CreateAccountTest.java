package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends TestBase {

    @Test
    public void newUserRegistrationPositiveTest() {

        //enter email
        driver.findElement(By.cssSelector("a[href='/register']")).click();

        // Выбираем пол
        driver.findElement(By.id("gender-male")).click(); // или "gender-female"

        // Вводим имя и фамилию
        driver.findElement(By.id("FirstName")).clear();
        driver.findElement(By.id("FirstName")).sendKeys("Tetiana");

        driver.findElement(By.id("LastName")).clear();
        driver.findElement(By.id("LastName")).sendKeys("Karakis");

        // Генерируем уникальный email
        String email = "tati" + System.currentTimeMillis() + "@gmail.com";
        driver.findElement(By.id("Email")).clear();
        driver.findElement(By.id("Email")).sendKeys(email);

        // это с одноразовым email
        //driver.findElement(By.id("Email")).clear();
        // driver.findElement(By.id("Email")).sendKeys("tati123@gmail.com");

        //enter Password    Вводим пароль и подтверждение
        driver.findElement(By.id("Password")).clear();
        driver.findElement(By.id("Password")).sendKeys("Tati123!");
        driver.findElement(By.id("ConfirmPassword")).clear();
        driver.findElement(By.id("ConfirmPassword")).sendKeys("Tati123!");


        // click on Registration button
        driver.findElement(By.id("register-button")).click();

        //verify Sing out is displayed
        Assert.assertTrue(driver.findElement(By.linkText("Log out")).isDisplayed(), "Registration failed!");
    }


}