package com.cbt.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class StringUtility {

   public static WebDriver driver;

    public static void verifyEquals(String expected , String actual){
        if(actual.equals(expected)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("actual: " + actual);
            System.out.println("expected: " + expected);
        }

    }


}
