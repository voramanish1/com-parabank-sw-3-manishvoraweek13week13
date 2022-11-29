package testsuite;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.Utility;

public class RegisterTest extends Utility {
    String baseURL = "https://parabank.parasoft.com/parabank/index.htm";

    @Before
    public void setup() {
        openBrowser(baseURL);
    }

    @Test
    public void verifyThatSigningUpPageDisplay() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Verify the text ‘Signing up is easy!’
        verifyText("Signing up is easy!",
                By.xpath("//h1[contains(text(),'Signing up is easy!')]"),
                "Text not matched");
    }

    @Test
    public void userShouldRegisterAccountSuccessfully() {
        //click on the ‘Register’ link
        driver.findElement(By.xpath("//a[contains(text(),'Register')]")).click();
        //Enter First name
        sendTextToElement(By.id("customer.firstName"), "Abc");
        //Enter Last name
        sendTextToElement(By.id("customer.lastName"), "Xyz");
        //Enter Address
        sendTextToElement(By.id("customer.address.street"), "10,Downing Street");
        //Enter City
        sendTextToElement(By.id("customer.address.city"), "Westminster");
        //Enter State
        sendTextToElement(By.id("customer.address.state"), "London");
        //Enter Zip Code
        sendTextToElement(By.id("customer.address.zipCode"), "EC1A 2AA");
        //Enter Phone
        sendTextToElement(By.id("customer.phoneNumber"), "0208987654");
        //Enter SSN
        sendTextToElement(By.id("customer.ssn"), "123456");
        //Enter Username
        sendTextToElement(By.id("customer.username"), "Manish");
        //Enter Password
        sendTextToElement(By.id("customer.password"), "Abcd123");
        //Enter Confirm
        sendTextToElement(By.id("repeatedPassword"), "Abcd123");
        //Click on REGISTER button
        clickOnElement(By.xpath("//tbody/tr[13]/td[2]/input[1]"));
        //Verify the text 'Your account was created successfully. You are now logged in.’
        verifyText("Your account was created successfully. You are now logged in.",
                By.xpath("//p[contains(text(),'Your account was created successfully. You are now logged in.')]"),
                "Text not matched");
    }

    @After
    public void tearDown() {
        closeBrowser();
    }
}

