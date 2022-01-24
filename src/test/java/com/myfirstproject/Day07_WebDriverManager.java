package com.myfirstproject;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.time.Duration;
public class Day07_WebDriverManager {
    WebDriver driver;
    //    System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//    =>>>>>WebDriverManager.chromedriver().setup();
//    import io.github.bonigarcia.wdm.WebDriverManager;
    @Before
    public void setUp(){
//        System.setProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        From now on, we will use WebDriverManager.chromedriver().setup();
//        WebDriverManager.chromedriver().setup(); calls and setup the driver
//        This is more efficient, no need to give path, automatically used required driver related files
//        easy to use. easy to create different driver
        WebDriverManager.chromedriver().setup();
//        Below will run headless.
//        You will not see the browser opened.
//        But test will execute
//        driver = new ChromeDriver(new ChromeOptions().setHeadless(true));
        driver= new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void test(){
        driver.get("https://www.google.com");
        System.out.println(driver.getTitle());
    }
}