package assertionDemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class DropDownTest {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.com.eg/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test01() throws Exception{

        driver.findElement(By.name("q")).sendKeys("AMIT");
        Thread.sleep(3000);
        List<WebElement> y = driver.findElements(By.cssSelector("ul[class=\"G43f7e\"] li"));  // 1 of 10
        y.get(2).click();
        Thread.sleep(3000);
    }
}
