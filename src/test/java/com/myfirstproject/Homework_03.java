package com.myfirstproject;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Homework_03 extends com.myfirstproject.utilities.TestBase {
    @Test
    public void dropdownTest(){
        driver.get("https://www.amazon.com");
        // searchbox
        WebElement all = driver.findElement(By.id("searchDropdownBox"));
        //Selecting options
        Select options = new Select(all);
        //First Option
        WebElement firstoption =  options.getFirstSelectedOption();
        System.out.println("First Option is : " + firstoption.getText());
        Assert.assertTrue("All Departments".equals(firstoption.getText()));
        //Amazon Department , 4.Option
        options.selectByIndex(3);
        WebElement fourthOption = options.getFirstSelectedOption();
        System.out.println("Fourth option is  : "+ fourthOption.getText());
        Assert.assertFalse("Amazon Devices".equals(fourthOption.getText()));
        //All options
        List<WebElement> allOptions= options.getOptions();
        for ( WebElement eachOption : allOptions) {
            System.out.println("Each option : " + eachOption.getText() + " ");
        }
        //Total number of options
        int sizeOfOptions = allOptions.size();
        System.out.println("Total number of options in the dropbox : " + sizeOfOptions);
        // Check if Alphabetical order
        List<String> strOptions = new ArrayList<>();
        for( WebElement eachOption : allOptions){
            strOptions.add(eachOption.getText());
        }
        List<String> defaultOptions = strOptions;
        System.out.println("Default Options : " + defaultOptions);
        Collections.sort(strOptions);
        System.out.println("Sorted options : " + strOptions);
        List<String > sortedOptions = strOptions;
        Assert.assertTrue(defaultOptions.equals(sortedOptions));
        //Appliances
        if(strOptions.contains("Appliances")){
            System.out.println("True");
        }else{
            System.out.println("False");
        }
    }
}
