package testCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.P01_Homepage;

import java.time.Duration;

public class T01_Login {
    WebDriver driver;
    P01_Homepage homepage;
    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.navigate().to("https://www.saucedemo.com/v1/");
    }

    @Test
    public void testCase01 (){
        homepage = new P01_Homepage(driver);

        homepage.login().sendKeys("standard_user");
        homepage.password().sendKeys("secret_sauce");
        homepage.loginButton().click();

        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("inventory.html"));
        Assert.assertTrue(driver.getCurrentUrl().contains("https://www.saucedemo.com/v1/inventory.html"));
    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
