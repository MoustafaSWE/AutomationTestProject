package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.P01_Homepage;

import java.time.Duration;

public class T03_AddToCart {
    WebDriver driver;
    P01_Homepage homepage;

    /*  -- assert by product name -- assert by product price
    1- Open URL: https://www.saucedemo.com/  *
    2- Login using username: standard_user
    3- Login using password: secret_sauce
    4- Click on Login button   // Assert that you are logged in
    5- Click on "Add to cart" button, for item "Sauce Labs Bike Light"
    6- Click on "Add to cart" button, for item "Sauce Labs Bolt T-Shirt"
    6- Go to Cart
    7- Assert that the same product found on cart
    */



    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();  // Open GoogleChrome Browser

        driver.manage().window().maximize();  // Maximize Browser
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));  // implicit

        driver.get("https://www.saucedemo.com/"); // Open URL

        homepage = new P01_Homepage(driver);
    }

    @Test(priority = 1)
    public void userLoginWebsite (){

        homepage.username().sendKeys("standard_user");

        homepage.password().sendKeys("secret_sauce");

        homepage.loginButton().click();


    }

    @Test (priority = 1, dependsOnMethods = "userLoginWebsite")
    public void userAddProductToCart (){


        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();

        String NameOfFirstProduct = driver.findElements(By.className("inventory_item_name"))
                .get(2).getText();

        driver.findElement(By.className("shopping_cart_link")).click();

        String NameOfProductInsideCart = driver.findElement(By.className("inventory_item_name"))
                .getText();


        Assert.assertEquals(NameOfProductInsideCart,NameOfFirstProduct);



    }

    @AfterClass
    public void tearDown (){
       // driver.quit();
    }

}
