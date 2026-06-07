package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    
    By emailBox = By.id("username");
    By passwordBox = By.id("password");
    By loginButton = By.id("loginBtn");
    By messageBox = By.id("message");

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void enterEmail(String email){
        driver.findElement(emailBox).sendKeys(email);
    }

    public void enterPassword(String password){
        driver.findElement(passwordBox).sendKeys(password);
    }

    public void clickLogin(){
        driver.findElement(loginButton).click();
    }

    public String getMessage(){
        return driver.findElement(messageBox).getText();
    }

    public String getUsernamePlaceholder() {
    return driver.findElement(emailBox).getAttribute("placeholder");
    }

    public String getPasswordPlaceholder() {
    return driver.findElement(passwordBox).getAttribute("placeholder");
    }


}
