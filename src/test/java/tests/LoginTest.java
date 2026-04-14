package tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.ITestResult;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

import utils.ScreenshotUtil;

public class LoginTest {

    WebDriver driver;

    @Test
    public void testLogin() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");
        options.addArguments("--disable-gpu");

        driver = new ChromeDriver(options);

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage login = new LoginPage(driver);
        login.login("student", "Password123");

        String currentUrl = driver.getCurrentUrl();

        if (!currentUrl.contains("logged-in-successfully")) {
            throw new RuntimeException("Login Failed");
        }
    }

    // 🔥 Screenshot logic here
    @AfterMethod
    public void captureResult(ITestResult result) {

        String testName = result.getName();

        if (result.getStatus() == ITestResult.FAILURE) {
            ScreenshotUtil.capture(driver, testName + "_FAILED");
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            ScreenshotUtil.capture(driver, testName + "_PASSED");
        }

        driver.quit();
    }
}