package com.myfirstproject;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
public class Day06_NewTabsSel4 {
    @Test
    public void newTabs() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
//        1. open google in the tab 1
        driver.get("https://www.google.com");
        String googleWindowHandle = driver.getWindowHandle();
//        2. open amazon in the tab 2
//        Creating and switching to a new EMPTY Tab
        WebDriver amazonTab = driver.switchTo().newWindow(WindowType.TAB);
        amazonTab.get("https://www.amazon.com");
//        getting the window handle of that window b/c i am working on multiple tabs
        String amazonWindowHandle = driver.getWindowHandle();
//        3. open linkedin in a new tab
//        Crate a new empty tab and switch to that tab automatically
        WebDriver linkedinTab = driver.switchTo().newWindow(WindowType.TAB);
        linkedinTab.get("https://www.linkedin.com");
//        getting the window handle of that window b/c i am working on multiple tabs
        String linkedinWindowHandle = driver.getWindowHandle();
//      Switching back to google tab
        Thread.sleep(3000);
        driver.switchTo().window(googleWindowHandle);
        System.out.println("Google URL => "+driver.getCurrentUrl());

//      Switching back to amazon tab
        Thread.sleep(3000);
        driver.switchTo().window(amazonWindowHandle);
        System.out.println("Amazon URL => "+driver.getCurrentUrl());
//      Switching back to linkedin tab
        Thread.sleep(3000);
        driver.switchTo().window(linkedinWindowHandle);
        System.out.println("Linkedin URL => "+driver.getCurrentUrl());
    }
}
