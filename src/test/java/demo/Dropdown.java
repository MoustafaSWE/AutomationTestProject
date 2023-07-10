package demo;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
<<<<<<< HEAD
import org.openqa.selenium.WebElement;
=======
>>>>>>> origin/shrouk
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
<<<<<<< HEAD
        driver.get("https://the-internet.herokuapp.com/");
=======
        driver.get("https://the-internet.herokuapp.com/dropdown");
>>>>>>> origin/shrouk

    }

    @Test
    public void selectOption(){
<<<<<<< HEAD
        WebElement dropdownpage = driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a"));
        dropdownpage.click();
        Select option2 = new Select(driver.findElement(By.id("dropdown")));
        option2.selectByValue("2");
=======
        Select select = new Select(driver.findElement(By.id("dropdown")));
        select.selectByValue("2");
>>>>>>> origin/shrouk
    }

    @AfterMethod
    public void quitbrowser(){
        driver.quit();
    }

}
