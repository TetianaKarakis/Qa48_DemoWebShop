package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

public class FindElementWebShopTest extends TestBase {

    @Test
    public void findElementByTagName() {

        WebElement element = app.driver.findElement(By.tagName("h2"));
        System.out.println(element.getText());

        WebElement element1 = app.driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        List<WebElement> list = app.driver.findElements(By.tagName("a"));
        System.out.println(list.size());


    }

    @Test
    public void findElementBySimpleLocators() {

        app.driver.findElement(By.id("dialog-notifications-success"));

        app.driver.findElement(By.className("master-wrapper-page"));

        app.driver.findElement(By.linkText("Books"));
    }
    @Test
    public void findElementByCssSelectorTest() {

        app.driver.findElement(By.cssSelector("h2"));

        app.driver.findElement(By.cssSelector("#dialog-notifications-success"));

        app.driver.findElement(By.cssSelector(".master-wrapper-page"));

        app.driver.findElement(By.cssSelector("[href='/login']"));

        app.driver.findElement(By.cssSelector("[href*='/reg']"));

        app.driver.findElement(By.cssSelector("[href^='/wis']"));

        app.driver.findElement(By.cssSelector("[href$='cart']"));

        app.driver.findElement(By.cssSelector("div#bar-notification"));

        app.driver.findElement(By.cssSelector("div.master-wrapper-page"));

        app.driver.findElement(By.cssSelector("#bar-notification span[title='Close']")); ////tag+id+[attr='value']
    }

    @Test
    public void findElementByXpath(){

        app.driver.findElement(By.xpath("//h2"));

        app.driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));

        app.driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));

        app.driver.findElement(By.xpath("//div[contains(.,'all')]"));

        app.driver.findElement(By.xpath("//a[.='Build your own expensive computer']"));

        app.driver.findElement(By.xpath("//div[@class='master-wrapper-content']/.."));

        app.driver.findElement(By.xpath("//h2/parent::*"));

        app.driver.findElement(By.xpath("//h2/parent::div"));

        app.driver.findElement(By.xpath("//h2/.."));

        app.driver.findElement(By.xpath("//h2/ancestor::*"));

        app.driver.findElement(By.xpath("//h2/ancestor::div"));

        app.driver.findElement(By.xpath("//h2/ancestor::div[2]"));

        app.driver.findElement(By.xpath("//li/following-sibling::li"));

        app.driver.findElement(By.xpath("//ul/preceding-sibling::*"));





    }
}

