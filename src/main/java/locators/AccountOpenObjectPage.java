package locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AccountOpenObjectPage {
    public static WebDriver driver;

    public By usernameField = By.id("username");
    public By passwordField = By.id("password");
    public By loginButton = By.xpath("(//input[@value='Login'])[1]");
    public By myAccountButton = By.xpath("(//span[normalize-space()='My Account'])[1]");
    public By loginOption = By.xpath("(//a[normalize-space()='Login'])[1]");
    public By emailTextField = By.xpath("(//input[@id='input-email'])[1]");
    public By passwordTextField = By.xpath("(//input[@id='input-password'])[1]");
    public By alertText = By.xpath("(//div[@class='alert alert-danger alert-dismissible'])[1]");

    public  By registerOption = By.xpath("(//a[normalize-space()='Register'])[1]");
    public  By firstName = By.xpath("(//input[@id='input-firstname'])[1]");
    public  By lastName = By.xpath("(//input[@id='input-lastname'])[1]");
    public  By email = By.xpath("(//input[@id='input-email'])[1]");
    public  By telephone = By.xpath("(//input[@id='input-telephone'])[1]");
    public  By password = By.xpath("(//input[@id='input-password'])[1]");
    public  By confirmPassword = By.xpath("(//input[@id='input-confirm'])[1]");
    public  By privacyCheckbox = By.xpath("(//input[@name='agree'])[1]");
    public  By continueButton = By.xpath("(//input[@value='Continue'])[1]");
    public  By accountCreated = By.xpath("(//h1[normalize-space()='Your Account Has Been Created!'])[1]");
    public  By AdvanceButton = By.xpath("//button[@class = 'secondary-button small-link']");
    public  By proceedLink = By.xpath("//a[@id= 'proceed-link']");





//    public static WebElement getRegisterOption() throws InterruptedException {
//        Thread.sleep(2000);
//        return driver.findElement(registerOption);
//
//    }
}
