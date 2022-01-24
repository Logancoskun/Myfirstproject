package com.myfirstproject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
public class Day02_VerifyTitleTest {
    //    Create a new class: VerifyTitleTest 
//    Navigate to google homepage 
//    Verify if google title is “Google”
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com");
        //Actual Title of a page
        String actualTitle = driver.getTitle();
        //Expected title of teh page
        String expectedTitle = "Google";
        //Verification!!!!!!!
        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASS");
        }else{
            System.out.println("FAIL");
            System.out.println("ACTUAL : "+actualTitle);
            System.out.println("EXPECTED : "+expectedTitle);
        }
        //closing the driver
        driver.quit();
    }}
