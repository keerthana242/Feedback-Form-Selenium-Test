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
import com.pages.FeedbackPage;
import com.pages.LoginPage;

public class FeedbackPageTest{

    WebDriver driver;
    FeedbackPage Feedback ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
         driver.get("file:///C:/Users/ggkee/Downloads/student-portal-testing-project/student-portal-testing-project/feedback.html");
         Feedback = new FeedbackPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }

    @Test
    public void FeedbackPageTitlet(){
         String actualTitle = driver.getTitle();
          String expectedTitle = "Student Feedback";
           Assert.assertEquals(actualTitle, expectedTitle);

    }

     @Test
    public void verifystudentNamePlaceholder() {

    String actualPlaceholder = Feedback.getStudentName();
    Assert.assertEquals(actualPlaceholder, "Enter student name");
   }

   @Test
    public void verifycommentsPlaceholder() {

    String actualPlaceholder = Feedback.getcomments();
    Assert.assertEquals(actualPlaceholder, "Enter your comments");
   }

   @Test
    public void validateEmptyBox(){
         Feedback.clickSubmit();

        String value = Feedback.getMessage();
        Assert.assertEquals(value, "Student name is required");
    }

      @Test
    public void testRatingRequired() {
        Feedback.enterStudentName("abc");
        Feedback.clickSubmit();

        
        String actualName = Feedback.getMessage();
        Assert.assertEquals(actualName, "Rating is required");
    }

    @Test
    public void testcommentsRequired() {
        Feedback.enterStudentName("abc");
        Feedback.selectRating("Excellent");
        Feedback.clickSubmit();

        
        String actualName = Feedback.getMessage();
        Assert.assertEquals(actualName, "Comments should be minimum 10 characters");
    }

   @Test
    public void validateconfirmation() {
    Feedback.enterStudentName("abc");
    Feedback.selectRating("Excellent");
    Feedback.enterComments("Good session");
    Feedback.clickSubmit();
        
        String actualName = Feedback.getMessage();
        Assert.assertEquals(actualName, "Please confirm your feedback");
    }

    @Test
    public void validateFeedbacksubmit() {
    Feedback.enterStudentName("abc");
    Feedback.selectRating("Excellent");
    Feedback.enterComments("Good session");
    Feedback.clickCheckbox();
    Feedback.clickSubmit();
        
        String actualName = Feedback.getMessage();
        Assert.assertEquals(actualName, "Feedback submitted successfully");
    }




}