package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_Homepage {
    WebDriver driver;

    // constructor
    public P01_Homepage (WebDriver driver){
        this.driver = driver;
    }

    // elements
    By userNameField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButtonField = By.id("login-button");

    // actions
    public WebElement loginButton (){
       return driver.findElement(loginButtonField);
    }

    public WebElement username (){
        return driver.findElement(userNameField);
    }

    public WebElement password (){
        return driver.findElement(passwordField);
    }

    public void enterUsername (String username){
        driver.findElement(userNameField).sendKeys(username);
    }

    public void clear (){
        driver.findElement(userNameField).clear();
    }
}
