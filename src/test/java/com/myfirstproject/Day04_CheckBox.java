package com.myfirstproject;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.concurrent.TimeUnit;
public class Day04_CheckBox {
    WebDriver driver;
    @Before
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        driver = new ChromeDriver();
        //Adding implicitly wait
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //When we use implicit wait in before method, then we won't need to put it again an again
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));//dynamic wait
        driver.manage().window().maximize();
    }
    @Test
    public void cssCheckBoxTest(){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement checkbox1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        //Verify that checkbox 1 is not checked
        Assert.assertTrue(!checkbox1.isSelected());
        //Verify that checkbox 2 is SELECTED
        WebElement checkbox2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        Assert.assertTrue(checkbox2.isSelected());
        //How to check or uncheck
        checkbox1.click();
        checkbox2.click();
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(!checkbox2.isSelected());
        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
        Assert.assertTrue(checkbox1.isSelected());
        Assert.assertTrue(checkbox2.isSelected());
    }
}