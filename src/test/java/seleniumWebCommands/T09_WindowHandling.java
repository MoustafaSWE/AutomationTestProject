package seleniumWebCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T09_WindowHandling {

//    Don't apply Thread.sleep -> it is for you to see the execution ; remove it once you learn the script's purpose

    WebDriver driver = null;

    @Test(priority = 1)
    public void handlingTwoTabs() throws InterruptedException {
        //1- click on twitter
        driver.findElement(By.cssSelector("a[href='https://twitter.com/nopCommerce']")).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(7));
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //2- get window list inside array


        //3- switch from tab 0 to tab 1


        //4- switch from tab 1 to tab 0



        //Difference between driver.quit() and driver.close()



        // reload


    }


    @BeforeMethod
    public void openBrowser() {
        //1- Define Bridge
        // 2- Create new object from chromedriver
        driver = new ChromeDriver();

        // 3- Configuration
        //3.1- Maximize browser
        driver.manage().window().maximize();

        //3.2- Set implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        // 4- Navigate to website
        driver.get("https://demo.nopcommerce.com/");
    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();

        // driver.quit  !=  driver.close
    }
}
