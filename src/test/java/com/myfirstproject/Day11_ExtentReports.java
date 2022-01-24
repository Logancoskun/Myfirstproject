package com.myfirstproject;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
public class Day11_ExtentReports extends myfirstproject.utilities.TestBase {
    //    3 libraries to remember?????
    @Test
    public void extentReportsTest(){
        extentTest.pass("Going to the google home page");
        driver.get("https://www.google.com");
        extentTest.pass("Searching for iphone");
        driver.findElement(By.name("q")).sendKeys("iphone x"+ Keys.ENTER);
        extentTest.pass("Printing the result");
//        Logging as failed
        extentTest.fail("THIS WILL FAIL");
//        logging as sipped
        extentTest.skip("THI IS SKIPPED");
// bu bir denemedir
        ///bugun githup ogrendik
    }
}