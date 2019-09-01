package com.cbt.tests.locators_tests;

import com.cbt.utilities.BrowserFactory;
import com.cbt.utilities.SeleniumUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class VytrackTitleTest {
//    public static void main(String[] args) {
//        TitleTest();
//    }

    @Test
    public void TitleTest(){
        WebDriver driver = BrowserFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("http://qa2.vytrack.com/user/login");
        String username = "prependedInput";
        String password = "prependedInput2";
        driver.findElement(By.id(username)).sendKeys("salesmanager110");
        driver.findElement(By.id(password)).sendKeys("UserUser123", Keys.ENTER);
        SeleniumUtils.waitPlease(5);
        driver.findElement(By.xpath("//*[@id='user-menu']/a")).click();
        driver.findElement(By.xpath("//*[text()='My Configuration']")).click();
        SeleniumUtils.waitPlease(2);
        String expectedTitle = "Moriah";
        String actualTitle = driver.findElement(By.xpath("//*[@id='user-menu']/a")).getText();
        if(actualTitle.startsWith(expectedTitle)){
            System.out.println("Title is verified, it starts with " + expectedTitle);
        }else{
            System.out.println("Title is not verified, it is not starts with " + expectedTitle);
        }

        driver.quit();
    }

}
