package com.telranwebshop.qa48;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementWebShopTest {

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

    @Test
    public void findElementByTagName() {

        WebElement element = driver.findElement(By.tagName("h2"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        List<WebElement> list = driver.findElements(By.tagName("a"));
        System.out.println(list.size());


    }

    @Test
    public void findElementBySimpleLocators() {

        driver.findElement(By.id("dialog-notifications-success"));

        driver.findElement(By.className("master-wrapper-page"));

        driver.findElement(By.linkText("Books"));
    }
    @Test
    public void findElementByCssSelectorTest() {

        driver.findElement(By.cssSelector("h2"));

        driver.findElement(By.cssSelector("#dialog-notifications-success"));

        driver.findElement(By.cssSelector(".master-wrapper-page"));

        driver.findElement(By.cssSelector("[href='/login']"));

        driver.findElement(By.cssSelector("[href*='/reg']"));

        driver.findElement(By.cssSelector("[href^='/wis']"));

        driver.findElement(By.cssSelector("[href$='cart']"));

        driver.findElement(By.cssSelector("div#bar-notification"));

        driver.findElement(By.cssSelector("div.master-wrapper-page"));

        driver.findElement(By.cssSelector("#bar-notification span[title='Close']")); ////tag+id+[attr='value']
    }

    @Test
    public void findElementByXpath(){

        driver.findElement(By.xpath("//h2"));

        driver.findElement(By.xpath("//div[@id='dialog-notifications-error']"));

        driver.findElement(By.xpath("//div[@class='master-wrapper-page']"));

        driver.findElement(By.xpath("//div[contains(.,'all')]"));

        driver.findElement(By.xpath("//a[.='Build your own expensive computer']"));

        driver.findElement(By.xpath("//div[@class='master-wrapper-content']/.."));

        driver.findElement(By.xpath("//h2/parent::*"));

        driver.findElement(By.xpath("//h2/parent::div"));

        driver.findElement(By.xpath("//h2/.."));

        driver.findElement(By.xpath("//h2/ancestor::*"));

        driver.findElement(By.xpath("//h2/ancestor::div"));

        driver.findElement(By.xpath("//h2/ancestor::div[2]"));

        driver.findElement(By.xpath("//li/following-sibling::li"));

        driver.findElement(By.xpath("//ul/preceding-sibling::*"));





    }
}

