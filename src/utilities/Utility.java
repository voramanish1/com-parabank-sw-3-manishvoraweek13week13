package utilities;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Utility extends BaseTest {
    //This method will click on element
    public void clickOnElement(By by) {
        driver.findElement(by).click();
    }

    //This method will find element and send data
    public void sendTextToElement(By by, String text){
        driver.findElement(by).sendKeys(text);
    }

    //This method will verify expected and actual text or message
    public void verifyText(String expectedMessage, By by, String message) {
        WebElement actualTextMessageElement = driver.findElement(by);
        String actualMessage = actualTextMessageElement.getText();
        Assert.assertEquals(message, expectedMessage, actualMessage);
    }
}
