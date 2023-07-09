package pages;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P01_Homepage {
WebDriver driver;

    // Constructor
    public P01_Homepage(WebDriver driver){
        this.driver = driver;
    }

    // element
    By loginField = By.id("user-name");
    By passwordField = By.id("password");
    By loginButton = By.id("login-button");

    // Action
    public WebElement login (){
        return driver.findElement(loginField);
    }

    public WebElement password (){
        return driver.findElement(passwordField);
    }

    public WebElement loginButton (){
        return driver.findElement(loginButton);
    }


}
