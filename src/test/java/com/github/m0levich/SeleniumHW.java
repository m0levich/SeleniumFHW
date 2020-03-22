package com.github.m0levich;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;

import java.util.concurrent.TimeUnit;

public class SeleniumHW {
private WebDriver webDriver;
    @BeforeMethod
    public void initDriver(){
        System.setProperty("webdriver.chrome.driver","src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
    }

    @Test
    public void seleniumHW(){
        webDriver.get("https://www.yandex.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement input = webDriver.findElement(By.name("text"));
        input.sendKeys("руддщ ццщкдв",Keys.ENTER);
        assertThat(webDriver.getTitle()).contains("hello world");
        WebElement expectedField = webDriver.findElement(By.name("text"));
        Assert.assertEquals(expectedField.getAttribute("value"),"hello world");
    }

    @AfterMethod
    public void closeDriver(){
        webDriver.quit();
    }
}
