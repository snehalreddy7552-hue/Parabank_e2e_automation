package pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterPage {

    WebDriver driver;

    public RegisterPage(WebDriver driver) {
        this.driver = driver;
    }

    public void registerUser(String username) {

        // Click Register Link
        driver.findElement(By.linkText("Register")).click();

        // Wait for Registration Form
        WebDriverWait wait =
                new WebDriverWait(driver,
                Duration.ofSeconds(10));

        wait.until(
                ExpectedConditions
                .visibilityOfElementLocated(
                By.id("customer.firstName")));

        // Personal Details
        driver.findElement(
                By.id("customer.firstName"))
                .sendKeys("Snehal");

        driver.findElement(
                By.id("customer.lastName"))
                .sendKeys("Reddy");

        driver.findElement(
                By.id("customer.address.street"))
                .sendKeys("Hyderabad");

        driver.findElement(
                By.id("customer.address.city"))
                .sendKeys("Hyderabad");

        driver.findElement(
                By.id("customer.address.state"))
                .sendKeys("Telangana");

        driver.findElement(
                By.id("customer.address.zipCode"))
                .sendKeys("500001");

        driver.findElement(
                By.id("customer.phoneNumber"))
                .sendKeys("9063373636");

        driver.findElement(
                By.id("customer.ssn"))
                .sendKeys("12345");

        // Login Details
        driver.findElement(
                By.id("customer.username"))
                .sendKeys(username);

        driver.findElement(
                By.id("customer.password"))
                .sendKeys("Admin123");

        driver.findElement(
                By.id("repeatedPassword"))
                .sendKeys("Admin123");

        // Click Register Button
        driver.findElement(
                By.xpath("//input[@value='Register']"))
                .click();
    }
}