package demo1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class H1_Static_Dropdown {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {

        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://the-internet.herokuapp.com/");
    }

    @Test
    public void staticDropdown() {
        WebElement list = driver.findElement(By.cssSelector("//a[contains(text(),'Dropdown')]"));
        list.click();

    }
}

