package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.RegisterPage;
import utilities.ScreenshotUtil;
import utilities.TestData;

public class RegisterTest extends BaseTest {

    @Test
    public void verifyRegistrationAndLogin() {

        try {

            String username =
                    "Snehal" + System.currentTimeMillis();

            TestData.username = username;

            String password =
                    TestData.password;

            RegisterPage register =
                    new RegisterPage(driver);

            register.registerUser(username);

            WebDriverWait wait =
                    new WebDriverWait(driver,
                    Duration.ofSeconds(10));

            wait.until(
                    ExpectedConditions
                    .visibilityOfElementLocated(
                    By.linkText("Log Out")));

            Assert.assertTrue(
                    driver.findElement(
                    By.linkText("Log Out"))
                    .isDisplayed());

            System.out.println(
                    "Registration Successful");

            System.out.println(
                    "Username : " + username);

            driver.findElement(
                    By.linkText("Log Out"))
                    .click();

            LoginPage login =
                    new LoginPage(driver);

            login.login(username, password);

            wait.until(
                    ExpectedConditions
                    .visibilityOfElementLocated(
                    By.linkText("Accounts Overview")));

            Assert.assertTrue(
                    driver.findElement(
                    By.linkText("Accounts Overview"))
                    .isDisplayed());

            System.out.println(
                    "Login Successful");

        }

        catch (Exception e) {

            ScreenshotUtil
            .captureScreenshot(
            driver,
            "RegisterTestFailed");

            throw new RuntimeException(e);
        }
    }
}