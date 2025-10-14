package com.example.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver driver;

    private By username = By.name("username");
    private By password = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By errorMsg = By.xpath("//p[contains(@class,'oxd-alert-content-text')]"); // sample

    public LoginPage(WebDriver driver){
        this.driver = driver;
    }

    public void open(String url){
        driver.get(url);
    }

    public void enterUsername(String user){
        WebElement el = driver.findElement(username);
        el.clear();
        el.sendKeys(user);
    }

    public void enterPassword(String pass){
        WebElement el = driver.findElement(password);
        el.clear();
        el.sendKeys(pass);
    }

    public void clickLogin(){
        driver.findElement(loginBtn).click();
    }

    public boolean isLoggedIn() {
        try {
            return driver.getCurrentUrl().contains("dashboard");
        } catch (Exception e) {
            return false;
        }
    }

    public String getErrorMessage() {
        try {
            return driver.findElement(errorMsg).getText();
        } catch (Exception e) {
            return null;
        }
    }

    public void login(String url, String user, String pass){
        open(url);
        enterUsername(user);
        enterPassword(pass);
        clickLogin();
        System.out.println("Working fine");
    }
}
