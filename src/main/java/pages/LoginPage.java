package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    WebDriver driver;

    By username = By.id("username");
    By password = By.id("password");
    By loginBtn = By.id("submit"); 

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(String user, String pass) {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(username));
        driver.findElement(username).sendKeys(user);

        driver.findElement(password).sendKeys(pass);
        driver.findElement(loginBtn).click();
    }
}