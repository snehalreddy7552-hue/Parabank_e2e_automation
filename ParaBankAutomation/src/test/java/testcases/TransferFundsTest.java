package testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.TransferFundsPage;
import utilities.ScreenshotUtil;
import utilities.TestData;

public class TransferFundsTest extends BaseTest {

    @Test
    public void verifyTransferFunds() throws InterruptedException {

        String username = TestData.username;
        String password = TestData.password;

        System.out.println(
                "Username Used = " + username);

        LoginPage login =
                new LoginPage(driver);

        login.login(username, password);

        Thread.sleep(3000);

        System.out.println(
                "Current URL = "
                + driver.getCurrentUrl());

        System.out.println(
                "Page Title = "
                + driver.getTitle());

        if (driver.getPageSource()
                .contains(
                "The username and password could not be verified")) {

            Assert.fail(
                    "LOGIN FAILED - Invalid Username or Password");
        }

        WebDriverWait wait =
                new WebDriverWait(driver,
                Duration.ofSeconds(20));

        wait.until(
                ExpectedConditions
                .presenceOfElementLocated(
                By.partialLinkText("Accounts")));

        System.out.println(
                "LOGIN SUCCESS");

        TransferFundsPage transfer =
                new TransferFundsPage(driver);

        transfer.transferAmount("100");

        Thread.sleep(5000);

        System.out.println(
                "Funds Transfer Successful");

        ScreenshotUtil.captureScreenshot(
                driver,
                "TransferFundsPassed");
    }
}