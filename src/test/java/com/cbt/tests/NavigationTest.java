package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class NavigationTest {

    public static void main(String[] args) {
        testWithChrome();
//        testWithFirefox();
//        testWithSafari();

    }

    public static void testWithChrome(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        String expectedTitleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String expectedTitleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(expectedTitleEtsy, driver.getTitle());
        driver.quit();
    }

    public static void testWithFirefox(){
        WebDriver driver = BrowserFactory.getDriver("firefox");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        String expectedTitleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String expectedTitleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(expectedTitleEtsy, driver.getTitle());
        driver.quit();
    }

    public static void testWithSafari(){
        WebDriver driver = BrowserFactory.getDriver("safari");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://google.com");
        String expectedTitleGoogle = driver.getTitle();
        driver.get("http://etsy.com");
        String expectedTitleEtsy = driver.getTitle();
        driver.navigate().back();
        StringUtility.verifyEquals(expectedTitleGoogle, driver.getTitle());
        driver.navigate().forward();
        StringUtility.verifyEquals(expectedTitleEtsy, driver.getTitle());
        driver.quit();
    }

}
