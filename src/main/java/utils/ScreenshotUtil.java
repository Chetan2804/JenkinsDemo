package utils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import org.apache.commons.io.FileUtils;

public class ScreenshotUtil {

    public static void capture(WebDriver driver, String fileName) {

        try {
            String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());

            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            File dest = new File("screenshots/" + fileName + "_" + timestamp + ".png");

            FileUtils.copyFile(src, dest);

            System.out.println("Screenshot saved: " + dest.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}