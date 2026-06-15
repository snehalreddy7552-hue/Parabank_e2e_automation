package testcases;

import org.testng.annotations.Test;
import base.BaseTest;
import pages.BillPayPage;
import pages.LoginPage;
import utilities.ScreenshotUtil;
import utilities.TestData;

public class BillPayTest extends BaseTest {
    @Test
    public void verifyBillPayment()
            throws InterruptedException {
        String username =
                TestData.username;
        String password =
                TestData.password;
        LoginPage login =
                new LoginPage(driver);
        login.login(username,
                password);
        Thread.sleep(3000);
        System.out.println(
                "Current URL = "
                + driver.getCurrentUrl());
        System.out.println(
                "Page Title = "
                + driver.getTitle());
        BillPayPage billPay =
                new BillPayPage(driver);
        billPay.payBill();
        System.out.println(
                "Bill Payment Completed");
        ScreenshotUtil.captureScreenshot(
                driver,
                "BillPayPassed");
    }
}