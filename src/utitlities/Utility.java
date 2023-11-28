package utitlities;

import browserfactory.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;

public class Utility extends BaseTest {

    // This method will send text on element
    public void sendTextToElement(By by, String text) {
        driver.findElement(by).sendKeys(text);

    }

    // This Method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //Retrieving Text Method
    public String getTextFromElement(By by) {

        return driver.findElement(by).getText();
    }

}
