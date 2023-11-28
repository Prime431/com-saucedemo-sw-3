package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import utitlities.Utility;

import java.time.Duration;
import java.util.List;

/**
 * 4. Write down the following test into ‘LoginTest’
 * class
 * 1. userSholdLoginSuccessfullyWithValid
 * Credentials
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify the text “PRODUCTS”
 * 2. verifyThatSixProductsAreDisplayedOnPage
 * * Enter “standard_user” username
 * * Enter “secret_sauce” password
 * * Click on ‘LOGIN’ button
 * * Verify that six products are displayed
 * on page
 */


// 4.0 Login class created
public class LoginTest extends Utility {
    String baseUrl = "https://www.saucedemo.com/";

    @Before
    public void setUp() {
        openBrowser(baseUrl);

    }

    @Test
// 4.1 userShouldLoginSuccessfullyWithValid method created
    public void userShouldLoginSuccessfullyWithValid() {
        //Input Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 4.1.1  Enter “standard_user” username
        sendTextToElement(By.id("user-name"), "standard_user");
        // driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        //4.2.1  Enter “secret_sauce” password
        sendTextToElement(By.name("password"), "secret_sauce");
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        //4.2.1 Click on Login button
        clickOnElement(By.name("login-button"));
        //driver.findElement(By.xpath("//input[@id='login-button']")).click();
        //4.3.1 Declaring expected text
        String expectedResult = "Products";
        //4.3.2 Getting actual Text
        //String actualResult = driver.findElement(By.xpath("//span[@class='title']")).getText();
        String actualResult = getTextFromElement(By.xpath("//span[@class='title']"));
        //4.4.0 Verify the Txt "Products"
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void verifyThatSixProductsAreDisplayedOnPage() {
        //Input Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // 4.1.1  Enter “standard_user” username
        //driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        sendTextToElement(By.xpath("//input[@id='user-name']"), "standard_user");
        //4.2.1  Enter “secret_sauce” password
        //driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");
        sendTextToElement(By.xpath("//input[@id='password']"), "secret_sauce");
        //4.2.1 Click on Login button
        //driver.findElement(By.xpath("//input[@id='login-button']")).click();
        clickOnElement(By.xpath("//input[@id='login-button']"));
        int productCount = driver.findElements(By.className("inventory_item")).size();
        Assert.assertEquals("Error ", productCount, 6);
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
