package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackShortcutFunctionality {
//    public static void main(String[] args) {
//        ShortcutFunctionalityTest();

//    }

    @Test
    public void ShortcutFunctionalityTest(){
        String dashboardBtnLocator = "//*[text()='Dashboard'][@class='title title-level-2']";
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        String username = "prependedInput";
        String password = "prependedInput2";
        driver.findElement(By.id(username)).sendKeys("salesmanager110");
        driver.findElement(By.id(password)).sendKeys("UserUser123", Keys.ENTER);
//        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(dashboardBtnLocator))));
        SeleniumUtils.waitPlease(6);
//        driver.findElement(By.xpath(dashboardBtnLocator)).click();
        ////dashboard
        String shortcutBtnLocator = "[class='fa-share-square']";
        driver.findElement(By.cssSelector(shortcutBtnLocator)).click();
//        String seeFullListLocator = "//*[text()='See full list']";
//        driver.findElement(By.xpath(seeFullListLocator)).click();
//        String opportunitiesLocator = "//*[@href][text()='Opportunities']";
//        driver.findElement(By.xpath(opportunitiesLocator)).click();
//        ////// open opportunities
//        driver.findElement(By.cssSelector(shortcutBtnLocator)).click();
//        String vehicleServiceLogsLocator = "//*[@href][text()='Vehicle Services Logs']";
//        driver.findElement(By.xpath(vehicleServiceLogsLocator)).click();
        driver.quit();

    }

}
