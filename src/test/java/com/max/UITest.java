package com.max;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;

public class UITest extends BaseTest {

    @Test
    void testGBNotEmailLogin() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterCredentials("login", "password");
        loginPage.submitForm();
        Assertions.assertTrue(loginPage.hasErrorMessages());

    }

    @Test
    void testGBWithoutPassword() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.enterEmail("login@login.ru");
        loginPage.submitForm();
        Assertions.assertTrue(loginPage.hasErrorMessages());

    }

}

