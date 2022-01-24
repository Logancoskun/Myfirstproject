package com.myfirstproject;
import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Homework_01 {
    WebDriver driver;
    Faker faker = new Faker();

    @Before

    public void setUp() {

        System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");

        driver = new ChromeDriver();


        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();

    }

    @Test
    public void practice() {

        driver.get("http://automationpractice.com/index.php");
        driver.findElement(By.xpath("//*[@class='login']")).click();
        driver.findElement(By.id("email_create")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.id("SubmitCreate")).click();
        driver.findElement(By.id("id_gender1")).isSelected();
        driver.findElement(By.id("customer_firstname")).sendKeys("Ibrahim");
        driver.findElement(By.id("customer_lastname")).sendKeys("Aygün");
        driver.findElement(By.xpath("//input[@name='passwd']")).sendKeys("Karaca5506");

        WebElement days = driver.findElement(By.cssSelector("select[name='days']"));

        Select day = new Select(days);
        day.selectByIndex(4);

        WebElement months = driver.findElement(By.name("months"));

        Select month = new Select(months);

        month.selectByIndex(5);

        WebElement years = driver.findElement(By.id("years"));
        Select year = new Select(years);
        year.selectByIndex(37);

        driver.findElement(By.xpath("//label[@for='newsletter']")).click();

        driver.findElement(By.xpath("//input[@id='firstname']")).sendKeys("Ibrahim");
        driver.findElement(By.id("lastname")).sendKeys("TachProEd");
        driver.findElement(By.name("address1")).sendKeys(faker.address().streetAddress());
        driver.findElement(By.name("address2")).sendKeys(faker.address().buildingNumber());
        driver.findElement(By.name("city")).sendKeys(faker.address().city());

        WebElement state = driver.findElement(By.id("id_state"));

        Select states = new Select(state);

        states.selectByVisibleText("Florida");

        driver.findElement(By.id("postcode")).sendKeys("11111");

        WebElement country = driver.findElement(By.id("id_country"));

        Select countries = new Select(country);

        countries.selectByVisibleText("United States");

        driver.findElement(By.id("other")).sendKeys("No additional information is required");

        driver.findElement(By.id("phone")).sendKeys("122474884");
        driver.findElement(By.id("phone_mobile")).sendKeys(faker.phoneNumber().cellPhone());

        driver.findElement(By.id("alias")).sendKeys(" ataturk mah ");

        driver.findElement(By.id("submitAccount")).click();

        String text = driver.findElement(By.xpath("//h1")).getText();

        Assert.assertEquals("MY ACCOUNT", text);


    }

    }