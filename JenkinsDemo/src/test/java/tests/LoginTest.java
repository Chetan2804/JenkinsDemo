package tests;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pages.LoginPage;

public class LoginTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
        driver.get("https://example.com/login");

        LoginPage login = new LoginPage(driver);
        login.login("admin", "password");

        String title = driver.getTitle();

        if(title.contains("Dashboard")) {
            System.out.println("Login Successful");
        } else {
            System.out.println("Login Failed");
        }

        driver.quit();
	}

}
