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

import java.util.concurrent.TimeUnit;

public class YandexCheckWrongLanguageTest {
    private WebDriver webDriver;

    @BeforeMethod
    public void initDriver() {
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        webDriver = new ChromeDriver();
    }

    @Test
    public void changeOfLanguage() {
        webDriver.get("https://www.yandex.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement input = webDriver.findElement(By.name("text"));
        input.sendKeys("руддщ ццщкдв", Keys.ENTER);
        Assert.assertTrue(webDriver.getTitle().contains("hello world"), "Title not contains \"hello world\"");
        WebElement expectedField = webDriver.findElement(By.name("text"));
        Assert.assertEquals(expectedField.getAttribute("value"), "hello world", "Value failed");
    }

    @AfterMethod
    public void closeDriver() {
        webDriver.quit();
    }
}
