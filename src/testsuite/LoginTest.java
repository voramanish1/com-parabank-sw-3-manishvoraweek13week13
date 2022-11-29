package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class LoginTest extends Utility {
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        // Enter valid username
        sendTextToElement(By.name("username"), "Manish");
        //Enter valid password
        sendTextToElement(By.name("password"), "Abcd123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@class='button']"));
        //Verify the ‘Accounts Overview’ text is display
        verifyText("Accounts Overview",
                By.xpath("//h1[contains(text(),'Accounts Overview')]"),
                "Text not matched");
    }

    @Test
    public void verifyTheErrorMessage() {
        //Enter invalid username
        sendTextToElement(By.name("username"), "Manishvora");
        //Enter valid password
        sendTextToElement(By.name("password"), "Abcd123");
        //Click on Login button
        clickOnElement(By.xpath("//input[@class='button']"));
        //Verify the error message ‘The username and password could not be verified.’
        verifyText("Error!",
                By.xpath("//h1[text()='Error!']"),
                "Text not matched");
    }

    @Test
    public void userShouldLogOutSuccessfully() {
        //Enter valid username
        sendTextToElement(By.name("username"), "Manish");
        //Enter valid password
        sendTextToElement(By.name("password"), "Abcd123");
        //Click on ‘LOGIN’ button
        clickOnElement(By.xpath("//input[@class='button']"));
        //Click on ‘Log Out’ link
        clickOnElement(By.xpath("//a[contains(text(),'Log Out')]"));
        //Verify the text ‘Customer Login’
        verifyText("Customer Login",
                By.xpath("//h2[contains(text(),'Customer Login')]"),
                "Text not matched");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}
