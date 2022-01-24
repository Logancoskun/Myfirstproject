package com.myfirstproject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Day07_Actions2 extends com.myfirstproject.utilities.TestBase {
    WebDriver driver;
    //    Create a class: Actions2
//    Create test method : hoverOver() and test the following scenario:
//    Given user is on the https://www.amazon.com/
//    When use click on “Account” link
//    Then verify the page title contains “Your Account”
    @Test
    public void hoverOver() throws InterruptedException {
        driver.get("https://www.amazon.com/");
        WebElement accountList = driver.findElement(By.id("nav-link-accountList"));
//        1. Crete actions class
        Actions actions = new Actions(driver);
//        2. Use proper actions method
//        Move the mouse over account list element
        actions.moveToElement(accountList).perform();
        Thread.sleep(3000);
//        clicking on Account option
        driver.findElement(By.linkText("Account")).click();
//    Then verify the page title contains “Your Account”
        Assert.assertEquals("Your Account",driver.getTitle());
    }
}