package openBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class OpenBrowserTestNGMethod {

    WebDriver driver ;

    @BeforeTest
    public void open_url() {
        driver =new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/");


    }

    @Test
    public void openBrowser (){


        WebElement drop = driver.findElement(By.xpath("//a[@href=\"/dropdown\"]"));
        drop.click();


        Select list = new Select(driver.findElement(By.id("dropdown")));
        list.selectByValue("1");

    }
}
