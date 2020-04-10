package com.cbt.tests.locators_tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SeleniumUtils;
import com.cbt.utilities.StringUtility;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackShortcutFunctionality {

    String dashboardBtnLocator = "//h1[@class='oro-subtitle']";
    String usernameLocator = "prependedInput";
    String passwordLocator = "prependedInput2";
    String shortcutBtnLocator = ".fa-share-square";
    String seeFullListLocator = "//*[text()='See full list']";
    String opportunitiesLocator = "//*[@href][text()='Opportunities']";
    String vehicleServiceLogsLocator = "//a[@href][text()='Vehicle Services Logs']";
    String errorMessageLocator = "//div[text()='You do not have permission to perform this action.']";

    @Test
    public void ShortcutFunctionalityTest(){

        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        driver.findElement(By.id(usernameLocator)).sendKeys("salesmanager101");
        driver.findElement(By.id(passwordLocator)).sendKeys("UserUser123", Keys.ENTER);
        String expectedDashboardPage = "Dashboard";
        String actualDashboardPage = driver.findElement(By.xpath(dashboardBtnLocator)).getText();
        StringUtility.verifyEquals(expectedDashboardPage,actualDashboardPage);
        SeleniumUtils.waitPlease(10);
        driver.findElement(By.cssSelector(shortcutBtnLocator)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(seeFullListLocator)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(opportunitiesLocator)).click();
        String expectedOpportunitiesPage = "Open Opportunities";
        String actualOpportunitiesPage = driver.findElement(By.xpath(dashboardBtnLocator)).getText();
        StringUtility.verifyEquals(expectedOpportunitiesPage, actualOpportunitiesPage);
        SeleniumUtils.waitPlease(10);
        driver.findElement(By.cssSelector(shortcutBtnLocator)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(seeFullListLocator)).click();
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath(vehicleServiceLogsLocator)).click();
        String expectedErrorMessage = "You do not have permission to perform this action.";
        SeleniumUtils.waitPlease(2);
        String actualErrorMessage = driver.findElement(By.xpath(errorMessageLocator)).getText();
        if(actualErrorMessage.equals(expectedErrorMessage)){
            System.out.println("Passed");
            System.out.println("Error message verified that it is equals to expected error message");
        }else{
            System.out.println("Failed");
        }
        SeleniumUtils.waitPlease(2);
        StringUtility.verifyEquals("Open Opportunities", driver.findElement(By.cssSelector(".clearfix h3")).getText());

        driver.quit();

    }

}
