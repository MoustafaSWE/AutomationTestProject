package Assertion;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;

public class Assertion {

    WebDriver driver ;


    @BeforeTest
    public void open_url() {
        driver =new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
    }

    @Test
    public void invalid_login (){

        // user name
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("locked_out_user");

        // password
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        //login
        WebElement login_button = driver.findElement(By.id("login-button"));
        login_button.click();
    }


    @Test
    public void assert_message (){

        String text = "Epic sadface";
        String expectedText = driver.findElement(By.className("error-message-container error")).getText();
        Assert.assertTrue(expectedText.contains(text));



    }

}
