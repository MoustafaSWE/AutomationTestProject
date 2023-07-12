package testNGProject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class T00_AddToCart {

    /*  -- assert by product name -- assert by product price
    1- Open URL: https://www.saucedemo.com/  *
    2- Login using username: standard_user
    3- Login using password: secret_sauce
    4- Click on Login button   // Assert that you are logged in
    5- Click on "Add to cart" button, for item "Sauce Labs Backpack"
    6- Go to Cart
    7- Assert that the same product found on cart
    */

    WebDriver driver;

    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");
    }

    @Test (priority = 1)
    public void userLoginWebsite (){
        /*
        2- Login using username: standard_user
        3- Login using password: secret_sauce
        4- Click on Login button   // Assert that you are logged in
         */

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();

        Assert.assertFalse(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));


    }

    @Test (priority = 1, dependsOnMethods = "userLoginWebsite")
    public void userAddProductToCart (){
        /*
        5- Click on "Add to cart" button, for item "Sauce Labs Backpack"
        6- Go to Cart
        7- Assert that the same product found on cart
         */

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String priceOfFirstProduct = driver.findElements(By.className("inventory_item_price"))
                .get(0).getText();

        driver.findElement(By.className("shopping_cart_link")).click();

        String priceOfProductInsideCart = driver.findElement(By.className("inventory_item_price"))
                .getText();

        Assert.assertEquals(priceOfProductInsideCart,priceOfFirstProduct);
    }

    @AfterClass
    public void tearDown (){
        driver.quit();
    }






}