package com.cbt.tests.basic_navigation_tests;

import com.cbt.utilities.BrowserFactory;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class navigationTestWithTestNG {
    WebDriver driver;

    @Test
    public void chromeNavTest(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @Test
    public void firefoxNavTest(){
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    @Test
    public void safariNavTest(){
        driver = new SafariDriver();
    }

    @AfterMethod
    public void tearDown(){
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        String  expectedTitle3 = driver.getTitle();
        driver.get("http://etsy.com");
        String  expectedTitle5 = driver.getTitle();
        driver.navigate().back();
        String actualTitle3 = driver.getTitle();
        Assert.assertEquals(actualTitle3, expectedTitle3);
        driver.navigate().forward();
        String actualTitle5 = driver.getTitle();
        Assert.assertEquals(actualTitle5, expectedTitle5);
        driver.quit();
    }


}
