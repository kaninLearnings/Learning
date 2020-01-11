package com.example.automation.Selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;


public class GooglePageTest extends TestReportConfiguration {

    public static WebDriver driver;

    public WebDriver initialize() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        driver = new ChromeDriver();
        return driver;
    }

    public String getBaseUrl() {
        return "https://www.google.com/";
    }

    public void launchBrowser() {
        driver.get(getBaseUrl());
    }

    public void enterText() {
        driver.findElement(By.name("q")).sendKeys("test");
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void submit() {
        driver.findElement(By.name("f")).submit();
    }

    public void close() {
        driver.close();
        driver.quit();
    }

    @Test
    public void pageTest() {
        initialize();
        launchBrowser();
        Assert.assertEquals(getTitle(), "Google");
        close();
    }

    @Test
    public void searchTest() {
        initialize();
        launchBrowser();
        enterText();
        submit();
        Assert.assertEquals(getTitle(), "test - Google Search");
        close();
    }


}
