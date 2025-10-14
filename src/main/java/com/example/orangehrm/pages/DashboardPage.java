package com.example.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    private WebDriver driver;
    private By welcome = By.xpath("//h6[text()='Dashboard']");

    public DashboardPage(WebDriver driver){
        this.driver = driver;
    }

    public boolean isDisplayed() {
        try {
            return driver.findElement(welcome).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
