package utilities;

import java.io.File;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.io.FileHandler;

public class ScreenshotUtil {
    public static void captureScreenshot(
            WebDriver driver,
            String fileName) {
        try {
            TakesScreenshot ts =
                    (TakesScreenshot) driver;
            File source =
                    ts.getScreenshotAs(
                    OutputType.FILE);
            File destination =
                    new File("./Screenshots/"
                    + fileName + ".png");
            FileHandler.copy(source,
                    destination);
            System.out.println(
                    "Screenshot Saved");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}