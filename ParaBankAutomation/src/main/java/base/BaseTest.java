package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import utilities.ConfigReader;

public class BaseTest {

    public static WebDriver driver;

    ConfigReader config =
            new ConfigReader();

    @BeforeMethod
    public void setup() {

        driver = new ChromeDriver();

        driver.manage()
              .window()
              .maximize();

        driver.get(config.getUrl());

        System.out.println(
                "Browser Started");
    }

    @AfterMethod
    public void tearDown() {

        if(driver != null) {

            driver.quit();
        }
    }
}