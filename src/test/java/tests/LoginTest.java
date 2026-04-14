package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import pages.LoginPage;

public class LoginTest {

    @Test
    public void testLogin() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new"); // for Jenkins
        options.addArguments("--disable-gpu");

        WebDriver driver = new ChromeDriver(options);

        driver.get("https://practicetestautomation.com/practice-test-login/");

        LoginPage login = new LoginPage(driver);
        login.login("student", "Password123");

        
        String currentUrl = driver.getCurrentUrl();

        if (currentUrl.contains("logged-in-successfully")) {
            System.out.println("Test Passed");
        } else {
            throw new RuntimeException("Test Failed");
        }

        driver.quit();
    }
}