package assertionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.time.Duration;

public class AssertionTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp (){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }


    @Test
    public void test01 () {

        // Assert
        // SoftAssert



        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        System.out.println("1st assert executed");
        Assert.assertEquals(driver.getCurrentUrl(),"Https:/www.google.com/");
        System.out.println("2nd assert executed \nand 2nd assert fail");
        Assert.assertEquals(driver.getCurrentUrl(),"https://www.saucedemo.com/");
        System.out.println("3rd assert executed");


    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
