package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class  CourseEnquiryPage {
    WebDriver driver;
    
   
    By studentName = By.id("studentName");
    By email = By.id("email");
    By mobile = By.id("mobile");
    By courseDropdown = By.id("course");
    By pageTitle = By.id("pageTitle");
    By messageBox = By.id("message");
    By submitButton = By.id("submitBtn");
    By onlineCheckbox = By.id("online");

     public CourseEnquiryPage(WebDriver driver) {
        this.driver = driver;
    }
    
    
    public String getstudentNamePlaceholder() {
    return driver.findElement(studentName).getAttribute("placeholder");
    }

    public String getemailPlaceholder() {
    return driver.findElement(email).getAttribute("placeholder");
    }

     public String getmobilePlaceholder() {
    return driver.findElement(mobile).getAttribute("placeholder");
    }

    public void selectCourse(String courseName) {
    Select select = new Select(driver.findElement(courseDropdown));
    select.selectByVisibleText(courseName);
   }

   public String getSelectedCourse() {
    Select select = new Select(driver.findElement(courseDropdown));
    return select.getFirstSelectedOption().getText();
   }


     public void enterStudentName(String name) {
        driver.findElement(studentName).sendKeys(name);
    }

    public void enterEmail(String mail) {
        driver.findElement(email).sendKeys(mail);
    }

    
    public void enterMobile(String number) {
        driver.findElement(mobile).sendKeys(number);
    }

    public void selectOnlineMode() {
    driver.findElement(onlineCheckbox).click();
   }

    public boolean isOnlineSelected() {
    return driver.findElement(By.id("online")).isSelected();
    }

     public String getMessage(){
        return driver.findElement(messageBox).getText();
    }

    public void clickSubmit() {
    driver.findElement(submitButton).click();
   }

   



    




}