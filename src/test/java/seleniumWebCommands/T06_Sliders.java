package seleniumWebCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T06_Sliders {

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
        driver.get("https://www.jumia.com.eg/");
    }


    @Test(priority = 1)
    public void HandlingTwoTabs() throws InterruptedException {

        driver.findElement(By.cssSelector("button[aria-label=\"newsletter_popup_close-cta\"]")).click();
        Thread.sleep(1000);

        driver.findElement(By.cssSelector("button[class=\"cls\"][aria-label=\"Close\"]")).click();
        Thread.sleep(1000);

//        driver.findElement(By.cssSelector("button[aria-label=\"Close banner\"]")).click();
//        Thread.sleep(1000);

        JavascriptExecutor js = (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", driver.findElements(By.cssSelector("div[id=\"sl-topblock\"] label[aria-label*=\"Go to slide\"][class=\"dot\"]")).get(6));
        Thread.sleep(1000);

        js.executeScript("arguments[0].click();", driver.findElements(By.cssSelector("div[class=\"sldr _img _main -rad4 -oh -fsh0 -mhm\"] a")).get(6));

    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }

}
