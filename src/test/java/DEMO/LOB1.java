package DEMO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class LOB1 {
   WebDriver Driver;
   public void openBrowser(){
       Driver=new ChromeDriver();
       Driver.manage().window().maximize();
       Driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
       Driver.get("https://the-internet.herokuapp.com/");
   }
@Test
    public void staticDropdown(){


    }
}
