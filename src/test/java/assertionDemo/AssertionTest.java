package assertionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        driver.get("https://the-internet.herokuapp.com/abtest");
    }

    @Test
    public void test02 (){
        System.out.println("A B C\n D E F");
    }

    @Test
    public void test01 (){

        Assert.assertEquals( driver.getCurrentUrl() , "https://the-internet.herokuapp.com/abtest" );

        // A/B Test Variation 1

       // Assert.assertTrue();

        String text = "Also known as split testing";

        String expectedText = driver.findElement(By.className("example")).getText();

        Assert.assertTrue(expectedText.contains(text));  // pass



    }

    @AfterMethod
    public void tearDown (){
        driver.quit();
    }
}
