package com.myfirstproject;
import com.myfirstproject.utilities.TestBase;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Homework_04 extends TestBase {
    WebDriver driver;
    @Test
    public void iframeTest() throws InterruptedException {
        driver.get("https://html.com/tags/iframe/");
        //Scroll over to the view
        JavascriptExecutor js =  (JavascriptExecutor) driver;
        WebElement scroll = driver.findElement(By.xpath("(//div[@class='render'])[1]"));
        js.executeScript("arguments[0].scrollIntoView(true);",scroll);
        //Swictch to iframe
        WebElement iframe = driver.findElement(By.xpath("(//iframe[@frameborder='0'])[1]"));
        driver.switchTo().frame(iframe);
        //Click on play button
        WebElement play  = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));
        play.click();
        Thread.sleep(10000);
        // Hover over the play button
        WebElement hoverover = driver.findElement(By.xpath("//div[@class='ytp-left-controls']"));
        Actions action= new Actions(driver);
        action.moveToElement(hoverover).perform();
        // Click on stop button
        WebElement stop =driver.findElement(By.xpath("//button[@class='ytp-play-button ytp-button']"));
        stop.click();
        //Switch back to the parent frame
        driver.switchTo().parentFrame();
    }
}
