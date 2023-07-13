package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomapageTest {
    WebDriver driver;

    public void HomepageTest(WebDriver driver) {
        this.driver = driver;
    }

    By unameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    public WebElement username() {
        return driver.findElement(unameField);
    }
    public WebElement password() {
        return driver.findElement(passwordField);
    }
    public WebElement login_btn() {
        return driver.findElement(loginButton);
    }

    public void enterUsername(String username){
        driver.findElement(unameField).sendKeys(username);
    }

    public void enterpassword(String password){
        driver.findElement(passwordField).sendKeys(password);
    }



}
