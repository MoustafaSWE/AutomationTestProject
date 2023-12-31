package seleniumWebCommands;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class T03_findelements {

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


        // 4- Navigate to website   url should be english  >> ?hl=en
        driver.get("https://www.google.com/?hl=en");

    }


    @Test
    public void findelements() throws InterruptedException {

        //1- search on "selenium"
        driver.findElement(By.name("q")).sendKeys("selenium");

        driver.findElement(By.name("q")).sendKeys(Keys.ENTER);

        //2- loop on all results and make sure that they are all contains the word "selenium"
        int size = driver.findElements(By.cssSelector("div[class=\"g Ww4FFb tF2Cxc\"] h3[class=\"LC20lb MBeuO DKV0Md\"]")).size();
        System.out.println(size);
        for (int i = 0; i < size; i++) {
            String text = driver.findElements(By.cssSelector("div[class=\"g Ww4FFb tF2Cxc\"] h3[class=\"LC20lb MBeuO DKV0Md\"]")).get(i).getText();
            System.out.println(i);
            System.out.println(text);


            Assert.assertTrue(text.toLowerCase().contains("selenium"));
        }


    }

    @AfterMethod
    public void quitDriver() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }


}
