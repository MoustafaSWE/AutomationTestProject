package openBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class OpenBrowserMainMethod {

    public static void main (String [] args){

        // setup driver - browser
        WebDriver driver;

        driver = new ChromeDriver();


        // configuration
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15)); // implicit wait

        // open url
        driver.get("https://the-internet.herokuapp.com/");



        // close - quit
        driver.quit();

    }
}
