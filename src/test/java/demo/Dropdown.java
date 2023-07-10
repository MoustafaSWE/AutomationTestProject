package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Dropdown {
    WebDriver driver;

    @BeforeMethod
    public void openbrowser(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/dropdown");

    }

    @Test
    public void selectOption(){
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue("2");
    }

    @AfterMethod
    public void quitbrowser(){
        driver.quit();
    }

}
