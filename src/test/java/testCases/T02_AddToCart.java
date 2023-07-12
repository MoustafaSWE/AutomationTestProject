package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.P01_Homepage;

import java.time.Duration;
import java.util.List;

public class T02_AddToCart {

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
    P01_Homepage homepage;
    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.saucedemo.com/");

        homepage = new P01_Homepage(driver);
    }

    @Test (priority = 1)
    public void userLoginWebsite (){
        /*
        2- Login using username: standard_user
        3- Login using password: secret_sauce
        4- Click on Login button   // Assert that you are logged in
         */

        homepage.username().sendKeys("standard_user");
        homepage.password().sendKeys("secret_sauce");
        homepage.loginButton().click();


        Assert.assertFalse(driver.getCurrentUrl().equals("https://www.saucedemo.com/"));
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html"));


    }

    @Test (priority = 1, dependsOnMethods = "userLoginWebsite")
    public void userAddProductToCart (){
        /*
        5- Click on "Add to cart" button, for item "Sauce Labs Backpack"
        6- Go to Cart
        7- Assert that the same product found on cart
        8- Assert that the same Name of the selected product found on cart
         */

        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();

        String priceOfFirstProduct = driver.findElements(By.className("inventory_item_price"))
                .get(0).getText();

        //line1
        List<WebElement> products_names = driver.findElements(By.className("inventory_item_name"));
        String product_name = products_names.get(0).getText();

        driver.findElement(By.className("shopping_cart_link")).click();

        String priceOfProductInsideCart = driver.findElement(By.className("inventory_item_price"))
                .getText();

        //line2
        String product_names_inside_cart = driver.findElement(By.className("inventory_item_price")).getText();


        Assert.assertEquals(priceOfProductInsideCart,priceOfFirstProduct);
        //line3
        Assert.assertEquals (( product_names_inside_cart, product_name);
    }



    @AfterClass
    public void tearDown (){
        driver.quit();
    }






}