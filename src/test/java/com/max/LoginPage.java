package com.max;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private WebDriver driver;
    private By loginInput = By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/input");
    private By passwordInput = By.xpath("/html/body/div[2]/div[7]/div/form/div[2]/input");
    private By submitButton = By.xpath("/html/body/div[2]/div[7]/div/form/div[4]/input");
    private By errorMessages = By.xpath("/html/body/div[2]/div[7]/div/form/div[1]/ul");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void enterCredentials(String login, String password) {
        driver.findElement(loginInput).sendKeys(login);
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void enterEmail(String email) {
        driver.findElement(loginInput).sendKeys(email);
    }

    public void submitForm() {
        driver.findElement(submitButton).click();
    }

    public boolean hasErrorMessages() {
        return !driver.findElements(errorMessages).isEmpty();
    }

}
