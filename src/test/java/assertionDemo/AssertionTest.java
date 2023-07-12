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
    public void test01 () throws Exception{

        driver.findElement(By.id("user-name")).sendKeys("test");
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).clear();
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys("stand ard_user");
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys(Keys.TAB,"ssss");
        driver.findElement(By.id("user-name")).sendKeys(Keys.TAB,Keys.TAB,"ssss");
        Thread.sleep(3000);
        driver.findElement(By.id("user-name")).sendKeys(Keys.ENTER);

    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
