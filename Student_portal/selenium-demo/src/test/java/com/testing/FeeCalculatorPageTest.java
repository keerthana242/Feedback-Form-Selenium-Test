package com.testing;

import java.nio.channels.SelectionKey;
import java.util.Stack;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.google.common.base.Equivalence;
import com.pages.CourseEnquiryPage;
import com.pages.FeeCalculatorPage;
import com.pages.LoginPage;

public class FeeCalculatorPageTest {

    WebDriver driver;
    FeeCalculatorPage FeeCalculator ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
         driver.get("file:///C:/Users/ggkee/Downloads/student-portal-testing-project/student-portal-testing-project/fee-calculator.html");
         FeeCalculator = new FeeCalculatorPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
    
    @Test
    public void FeeCalculatorPageTitlet(){
         String actualTitle = driver.getTitle();
          String expectedTitle = "Fee Calculator";
           Assert.assertEquals(actualTitle, expectedTitle);

    }

     @Test
    public void verifystudentNamePlaceholder() {

    String actualPlaceholder = FeeCalculator.getdiscountPercentage();
    Assert.assertEquals(actualPlaceholder, "Enter discount percentage");
   }

   @Test
    public void validateEmptyBox(){
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getMessage();
        Assert.assertEquals(value, "Course is required");
    }

     @Test
    public void verifyCourseSelection() {
         FeeCalculator.selectCourse("Java Full Stack - Rs.30000");
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getMessage();
        Assert.assertEquals(value, "Discount is required");

   }

   @Test
    public void verifyDiscountNumber() {
         FeeCalculator.selectCourse("Java Full Stack - Rs.30000");
         FeeCalculator.enterDiscountPercentage("jbug"); 
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getMessage();
        Assert.assertEquals(value, "Discount should be a number");

    }

    @Test
    public void verifyDiscountNumber1() {
         FeeCalculator.selectCourse("Java Full Stack - Rs.30000");
         FeeCalculator.enterDiscountPercentage("-5"); 
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getMessage();
        Assert.assertEquals(value, "Discount should be between 0 and 50");

   }

   @Test
    public void verifyDiscountNumber2() {
         FeeCalculator.selectCourse("Java Full Stack - Rs.30000");
         FeeCalculator.enterDiscountPercentage("60"); 
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getMessage();
        Assert.assertEquals(value, "Discount should be between 0 and 50");

    }

    @Test
    public void  CalculateJavaFullStackfee() {
         FeeCalculator.selectCourse("Java Full Stack - Rs.30000");
         FeeCalculator.enterDiscountPercentage("10"); 
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getResult();
        Assert.assertEquals(value, "Final Fee: Rs.27000");

    }

     @Test
    public void  CalculateSoftwareTestingfee() {
         FeeCalculator.selectCourse("Software Testing - Rs.25000");
         FeeCalculator.enterDiscountPercentage("20"); 
         FeeCalculator.clickSubmit();

        String value = FeeCalculator.getResult();
        Assert.assertEquals(value, "Final Fee: Rs.20000");

    }






}    
