package com.cbt.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {

    public static void waitPlease(int seconds){
        try{
            Thread.sleep(seconds * 1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void verifyBiggerThan(int someSearch , int allSearch) {
        if (allSearch > someSearch) {
            System.out.println("PASSED: " + allSearch + " is bigger than " + someSearch);
        } else {
            System.out.println("FAILED: " + allSearch + " is smaller than " + someSearch);
        }
    }

    public static void clickWithWait(WebDriver driver, By xpath, int i) {
    }
}
