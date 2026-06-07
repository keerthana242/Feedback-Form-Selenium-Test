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
import com.pages.LoginPage;

public class AppTest {

    WebDriver driver;
    LoginPage login;

    @BeforeMethod
    public void setup(){
        driver = new ChromeDriver();
         driver.get("file:///C:/Users/ggkee/Downloads/student-portal-testing-project/student-portal-testing-project/index.html");
         login = new LoginPage(driver);
    }

    @AfterMethod
    public void closeBrowser(){
    driver.quit();    
    }

    @Test
    public void validateEmptyBox(){
        login.clickLogin();

        String value = login.getMessage();
        Assert.assertEquals(value, "Username is required");
    }

    @Test
    public void InvalidUser(){
        login.enterEmail("student@test.com");
        login.enterPassword("Student@123");

        login.clickLogin();

        String value = login.getMessage();
        Assert.assertEquals(value, "Invalid username");
    }

    @Test
    public void InvalidPassword(){
        login.enterEmail("student");
        login.enterPassword("Student@1");

        login.clickLogin();

        String value = login.getMessage();
        Assert.assertEquals(value, "Invalid password");
    }

      @Test
    public void EmptyPassword(){
        login.enterEmail("student");
        

        login.clickLogin();

        String value = login.getMessage();
        Assert.assertEquals(value, "Password is required");
    }

     @Test
    public void validCridential(){
        login.enterEmail("student");
        login.enterPassword("Student@123");

        login.clickLogin();

         String actualUrl = driver.getCurrentUrl();
         Assert.assertTrue(actualUrl.contains("dashboard.html"));
    
    }
    
    @Test
    public void loginPageTitlet(){
         String actualTitle = driver.getTitle();
          String expectedTitle = "Student Portal Login";
           Assert.assertEquals(actualTitle, expectedTitle);
}

     @Test
    public void verifyUsernamePlaceholder(){
         String actualPlaceholder = login.getUsernamePlaceholder();
         Assert.assertEquals(actualPlaceholder, "Enter username");
}

    @Test
    public void verifyPasswordPlaceholder() {

    String actualPlaceholder = login.getPasswordPlaceholder();
    Assert.assertEquals(actualPlaceholder, "Enter password");
}
    }