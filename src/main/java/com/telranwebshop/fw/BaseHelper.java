package com.telranwebshop.fw;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class BaseHelper {
    WebDriver driver;

    public BaseHelper(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isElementPresent(By locator) {
          return driver.findElements(locator).size() > 0;
      }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void type(By locator, String text) {
        if (text!=null){
        WebElement element = driver.findElement(locator);
        element.clear();
        element.sendKeys(text);
    }}

    public boolean isLogoutLinkDisplayed() {
         return driver.findElement(By.linkText("Log out")).isDisplayed();
     }

    public boolean isLoginErrorDisplayed() {
        return isElementPresent(By.cssSelector(".validation-summary-errors"));
    }
}
