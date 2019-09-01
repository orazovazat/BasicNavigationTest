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

import java.util.concurrent.TimeUnit;

public class EbaySearchTest {
    SoftAssert softAssert = new SoftAssert();

    @Test
    public void ebayTest() throws InterruptedException {
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

        String searchBoxValue = driver.findElement(By.id("gh-ac")).getAttribute("value");
        System.out.println(searchBoxValue);//just to check what is value of searchBoxValue
        softAssert.assertEquals(searchBoxValue , "wooden spoon");
        driver.navigate().back();
        Thread.sleep(2000);
        String searchBoxValueOfHomePage = driver.findElement(By.id("gh-ac")).getAttribute("value");
        softAssert.assertEquals(searchBoxValueOfHomePage , "");
        softAssert.assertAll();

        driver.quit();
    }


    @Test
    public void Ebay() throws InterruptedException {
        WebDriverManager.chromedriver().setup(); // 1.
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com");  // 2.
        WebElement search = driver.findElement(By.id("gh-ac"));
        //3.Search for wooden spoon
        search.sendKeys("wooden spoon", Keys.ENTER);
        //4.Save the total number of results
        String results = driver.findElement(By.className("srp-controls__count-heading")).getText();//12,546 result
        results = results.replaceAll("[^0-9]", "");
        int res1 = Integer.parseInt(results);//we convert string to int
        System.out.println(res1);
        Thread.sleep(3000);
        WebElement all = driver.findElement(By.xpath("//span[contains(text(),'All')]"));
        all.click();
        Thread.sleep(3000);
        String allResults = driver.findElement(By.cssSelector(".srp-controls__count-heading")).getText();
        allResults = allResults.replaceAll("[^0-9]", "");
        int allRes1 = Integer.parseInt(allResults);//we convert string to int
        System.out.println(allRes1);
        softAssert.assertTrue(res1 < allRes1, "All results is smaller");
        softAssert.assertAll();
        driver.navigate().back();       // 7.
        Thread.sleep(3000);

        WebElement searchBack = driver.findElementByCssSelector("#gh-ac");
        searchBack.click();
        System.out.println("***" + driver.findElementByCssSelector("#gh-ac").getText());
        System.out.println(searchBack.getAttribute("value"));
        String s = searchBack.getAttribute("value");
        softAssert.assertEquals(s, "wooden spoon");
        driver.navigate().back();       // 7.
        Thread.sleep(3000);

        WebElement searchAtHomePage = driver.findElementByCssSelector("#gh-ac");
        searchAtHomePage.click();
        String g = searchAtHomePage.getText();
        softAssert.assertEquals(g, "");
        softAssert.assertAll();
        driver.quit();
    }

}
