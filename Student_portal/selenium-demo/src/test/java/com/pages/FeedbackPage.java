package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FeedbackPage {
    
    WebDriver driver;

    // Locators
    By pageTitle = By.id("pageTitle");
    By studentName = By.id("studentName");
    By ratingDropdown = By.id("rating");
    By commentsBox = By.id("comments");
    By submitButton = By.id("submitBtn");   
    By messageBox = By.id("message");      
    By confirmCheckbox = By.id("confirm");


    public FeedbackPage(WebDriver driver) {
        this.driver = driver;
    }

    

    public String getPageTitle() {
        return driver.findElement(pageTitle).getText();
    }

    public String getStudentName() {
    return driver.findElement(studentName).getAttribute("placeholder");
    }

     public String getcomments() {
    return driver.findElement(commentsBox).getAttribute("placeholder");
    }

    public void clickSubmit() {
    driver.findElement(submitButton).click();
    }

    public String getMessage() {
    return driver.findElement(messageBox).getText();
    }

    public void enterStudentName(String name) {
    driver.findElement(studentName).sendKeys(name);
    }

    public String getSelectedRating() {
    Select select = new Select(driver.findElement(ratingDropdown));
    return select.getFirstSelectedOption().getText();
   }

   public void selectRating(String rating) {
    Select select = new Select(driver.findElement(ratingDropdown));
    select.selectByVisibleText(rating);
   }

   public void enterComments(String comments) {
    driver.findElement(commentsBox).sendKeys(comments);
   }

   public void clickCheckbox() {
    driver.findElement(confirmCheckbox).click();
   }

   public boolean isCheckboxSelected() {
    return driver.findElement(confirmCheckbox).isSelected();
   }

}