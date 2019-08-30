package com.cbt.tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

public class EtsySearchTest {
    public static void main(String[] args) {
        etsyTest();

    }

    public static void etsyTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://ebay.com");
        driver.findElement(By.id("gh-ac")).sendKeys("wooden spoon", Keys.ENTER);
        String totalNumOfResultStr = driver.findElement(By.className("srp-controls__count-heading")).getText();
        int totalNumOfResultInt = Integer.parseInt(totalNumOfResultStr.substring(0, totalNumOfResultStr.indexOf(" ")).replace("," , ""));
        driver.findElement(By.xpath("//*[text()='All']")).click();
        String totalNumOfResultStrAll = driver.findElement(By.className("srp-controls__count-heading")).getText();
        int totalNumOfResultIntall = Integer.parseInt(totalNumOfResultStrAll.substring(0, totalNumOfResultStrAll.indexOf(" ")).replace("," , ""));
        SeleniumUtils.verifyBiggerThan(totalNumOfResultInt, totalNumOfResultIntall);
        driver.navigate().back();

        driver.navigate().back();


        driver.quit();

    }

}
