package seleniumWebCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class T02_Dynamic_Dropdown {

//    Static dropdown list:	dropdowns having tagName "Select"
//    Dynamic dropdown list:	dropdowns having different tagName other than "Select"
//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose


    WebDriver driver;

    @BeforeMethod
    public void openBrowser() {
        //1- Define Bridge
        // 2- Create new object from chromedriver
        driver = new ChromeDriver();

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2- Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // 4- Navigate to website
        driver.get("https://www.google.com/");

    }


    @Test
    public void dynamicDropdown() throws InterruptedException {

        //1- search on "selenium"
        driver.findElement(By.name("q")).sendKeys("selenium");

        // 2- dynamic dropdown list
        // We couldn't use Select class with dynamic lists, instead we could handle it with findelements() method
        Thread.sleep(7000);
        List<WebElement> list = driver.findElements(By.cssSelector("li[class=\"sbct\"]"));  // 11 weblements
        list.get(6).click();

    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
