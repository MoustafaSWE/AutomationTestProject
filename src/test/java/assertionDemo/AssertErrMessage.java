package assertionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriverInfo;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class AssertErrMessage {
    WebDriver driver;
    @BeforeMethod
    public void openbrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.saucedemo.com/");

    }
    @Test
    public void login(){

        WebElement username = driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.xpath("//*[@id=\"password\"]"));
        password.sendKeys("secret");
        WebElement login_btn =driver.findElement(By.xpath("//*[@id=\"login-button\"]"));
        login_btn.click();
        WebElement error = driver.findElement(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));
//        System.out.println(error.getText());
        String expectederrmsg = "Epic sadface: Username and password do not match any user in this service";
        Assert.assertEquals(error.getText(), expectederrmsg);


    }

}
