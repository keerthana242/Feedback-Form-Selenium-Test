package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class  FeeCalculatorPage {
    WebDriver driver;
    
   
    By pageTitle = By.id("pageTitle");
    By courseDropdown = By.id("course");
    By discount = By.id("discount");
    By calculateButton = By.id("calculateBtn");
    By messageBox = By.id("message");
    By resultBox = By.id("result");


    public FeeCalculatorPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getdiscountPercentage() {
    return driver.findElement(discount).getAttribute("placeholder");
    }

     public String getMessage(){
        return driver.findElement(messageBox).getText();
    }

    public void clickSubmit() {
    driver.findElement(calculateButton).click();
   }

   public String getResult() {
    return driver.findElement(resultBox).getText();
}

    public void selectCourse(String courseName) {
    Select select = new Select(driver.findElement(courseDropdown));
    select.selectByVisibleText(courseName);
   }

   public String getSelectedCourse() {
    Select select = new Select(driver.findElement(courseDropdown));
    return select.getFirstSelectedOption().getText();
   }

   public void enterDiscountPercentage(String value) {
    driver.findElement(discount).sendKeys(value);
}


}