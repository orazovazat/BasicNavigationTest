package com.cbt.tests.locators_tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SeleniumUtils;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class GoogleResultsTitle {

    SoftAssert softAssert = new SoftAssert();

    @Test
    public void googleResultsTitleTest() throws InterruptedException {
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");
        for (String searchStr : searchStrs) {
            driver.findElement(By.name("q")).sendKeys(searchStr, Keys.ENTER);
            String expectedUrl = driver.findElement(By.cssSelector(".iUh30")).getText();
            driver.findElement(By.cssSelector(".ellip")).click();
            String actualUrl = driver.getCurrentUrl();
            softAssert.assertEquals(expectedUrl, actualUrl , searchStr);
            driver.navigate().back();
            driver.findElement(By.name("q")).clear();
        }
        softAssert.assertAll();
        driver.quit();

    }









    @Test
    public void GoogleResultsTitle() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();
        WebDriverManager.chromedriver().setup();    // 1.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");  // 2.
        List<String> searchStrs = Arrays.asList("Java", "JUnit", "REST Assured");//3
        for (String searchStr : searchStrs) {
            WebElement search = driver.findElement(By.name("q"));
            search.sendKeys(searchStr, Keys.ENTER);
            WebElement link = driver.findElement(By.cssSelector(".iUh30"));
            String actual = link.getText();
            link.click();
            String expected = driver.getCurrentUrl();
            softAssert.assertEquals(actual, expected, searchStr);
            driver.navigate().back();
            SeleniumUtils.waitPlease(2);
            driver.findElement(By.name("q")).clear();
        }
        softAssert.assertAll();
    }


    }
