package com.myfirstproject;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Homework_02 {

    public class Homework_2 extends com.myfirstproject.utilities.TestBase {
        WebDriver driver;
        @Test
        public void locators() {
            driver.get("http://www.saucedemo.com");
            WebElement email = driver.findElement(By.xpath("//input[@placeholder='Username']"));
            email.sendKeys("standard_user");
            WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
            password.sendKeys("secret_sauce");
            driver.findElement(By.id("login-button")).click();
            List<WebElement> allprices = driver.findElements(By.className("inventory_item_price"));
            LinkedList<String> newPrices = new LinkedList<>();
            for(WebElement eachPrice : allprices){
                newPrices.add(eachPrice.getText());
            }
            System.out.println(newPrices);
            LinkedList<Double> doublePrice = new LinkedList<>();
            for (String w: newPrices){
                w=w.substring(1);
                Double d = Double.parseDouble(w);
                doublePrice.add(d);
            }
            System.out.println("Prices in clean format --> "+ doublePrice);
            Collections.sort(doublePrice);
            System.out.println("Sorted Prices-->"+doublePrice);
            Assert.assertTrue(doublePrice.getFirst()>5);
            Assert.assertTrue(doublePrice.getLast()<50);
        }
    }

}
