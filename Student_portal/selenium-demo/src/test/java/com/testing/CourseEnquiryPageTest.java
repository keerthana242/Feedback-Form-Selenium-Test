package com.testing;

import java.nio.channels.SelectionKey;

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
import com.pages.LoginPage;

public class CourseEnquiryPageTest {

    WebDriver driver;
    CourseEnquiryPage CourseEnquiry ;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
         driver.get("file:///C:/Users/ggkee/Downloads/student-portal-testing-project/student-portal-testing-project/course-enquiry.html");
         CourseEnquiry = new CourseEnquiryPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
    driver.quit();    
    }

     @Test
    public void CourseEnquiryPageTitlet(){
         String actualTitle = driver.getTitle();
          String expectedTitle = "Course Enquiry";
           Assert.assertEquals(actualTitle, expectedTitle);
}

    @Test
    public void verifystudentNamePlaceholder() {

    String actualPlaceholder = CourseEnquiry.getstudentNamePlaceholder();
    Assert.assertEquals(actualPlaceholder, "Enter student name");
}


    @Test
    public void verifyemailPlaceholder() {

    String actualPlaceholder = CourseEnquiry.getemailPlaceholder();
    Assert.assertEquals(actualPlaceholder, "Enter email");
}


    @Test
    public void verifymobilePlaceholder() {

    String actualPlaceholder = CourseEnquiry.getmobilePlaceholder();
    Assert.assertEquals(actualPlaceholder, "Enter mobile number");
}

@Test
    public void validateEmptyBox(){
         CourseEnquiry.clickSubmit();

        String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Student name is required");
    }

    @Test
    public void usernameTest(){
         CourseEnquiry.enterStudentName("abc");
         CourseEnquiry.clickSubmit();

        String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Email is required");
    }

     @Test
    public void invalidemail(){
         CourseEnquiry.enterStudentName("abc");
         CourseEnquiry.enterEmail("abc");
         CourseEnquiry.clickSubmit();

        String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Invalid email format");
    }

     @Test
    public void ivalidmobile(){
         CourseEnquiry.enterStudentName("abc");
         CourseEnquiry.enterEmail("abc.@gmail.com");
         CourseEnquiry.enterMobile("557855");
         CourseEnquiry.clickSubmit();

        String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Mobile number should be exactly 10 digits");
    }

     @Test
    public void courseTest(){
         CourseEnquiry.enterStudentName("abc");
         CourseEnquiry.enterEmail("abc.@gmail.com");
         CourseEnquiry.enterMobile("5578554835");
         CourseEnquiry.clickSubmit();

        String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Course is required");
    }

    @Test
    public void verifyCourseSelection() {
         CourseEnquiry.enterStudentName("abc");
         CourseEnquiry.enterEmail("abc.@gmail.com");
         CourseEnquiry.enterMobile("5578554835");
         CourseEnquiry.selectCourse("Java Full Stack");
         CourseEnquiry.selectOnlineMode();
         CourseEnquiry.clickSubmit();

          String value = CourseEnquiry.getMessage();
        Assert.assertEquals(value, "Course enquiry submitted successfully");
        

}
    } 



