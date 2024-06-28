package stepDefinitions.Login;

import ReusableMethods.ExcelDataReader;
import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.AccountOpenObjectPage;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utils.DriverSetup;

import java.io.IOException;
import java.util.List;

public class AccountOpenSteps {
    private WebDriver driver;
    private PageObjectManager reusableMethod;
    private AccountOpenObjectPage loginPage = new AccountOpenObjectPage();

    public AccountOpenSteps(DriverSetup driverSetup) {
        this.driver = driverSetup.driver;
        this.reusableMethod = new PageObjectManager(driver);
    }

    @When("User enter valid username and password in login form")
    public void userEnterValidUsernameAndPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            if (row.length >= 2){
                String username1 = row[0];
                String password = row[1];

                reusableMethod.sendKeysToElement(loginPage.emailTextField, username1);
                reusableMethod.sendKeysToElement(loginPage.passwordTextField, String.valueOf(password));
            }else {
                System.out.println("Invalid data format in Excel row.");

            }

        }
    }
    @And("Clicks on Log in button")
    public void clicksOnLogInButton() {
        reusableMethod.clickElement(loginPage.loginButton);
    }
    @Then("Verify that the username or password is invalid")
    public void verifyThatTheUsernameOrPasswordIsInvalid() {
        Assert.assertEquals(reusableMethod.getTextOfElement(loginPage.alertText),"Warning: No match for E-Mail Address and/or Password.");
    }

    @When("Click on the My Account Button")
    public void clickOnTheMyAccountButton() {
        reusableMethod.waitUntilElementIsVisible(loginPage.AdvanceButton);
        reusableMethod.clickElement(loginPage.AdvanceButton);
        reusableMethod.clickElement(loginPage.proceedLink);
        reusableMethod.waitUntilElementIsVisible(loginPage.myAccountButton);
        reusableMethod.clickElement(loginPage.myAccountButton);

    }

    @And("Click on the Login Option")
    public void clickOnTheLoginOption() {
        reusableMethod.waitUntilElementIsVisible(loginPage.loginOption);
        reusableMethod.clickElement(loginPage.loginOption);
    }

    @When("User enter valid username and invalid password in login form")
    public void userEnterValidUsernameAndInvalidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[0];
            String password = row[2];

            reusableMethod.sendKeysToElement(loginPage.emailTextField, username1);
            reusableMethod.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }

    @When("User enter invalid username and valid password in login form")
    public void userEnterInvalidUsernameAndValidPasswordInLoginForm() throws IOException {
        String filePath = "TestData/Credentials.xlsx";
        String sheetName = "Sheet1";
        List<String[]> excelData = ExcelDataReader.readDataFromExcel(filePath, sheetName);

        for (String[] row : excelData) {
            String username1 = row[3];
            String password = row[1];

            reusableMethod.sendKeysToElement(loginPage.emailTextField, username1);
            reusableMethod.sendKeysToElement(loginPage.passwordTextField, password);
        }
    }

    @And("Click on the Register option")
    public void clickOnTheRegisterOption() throws InterruptedException {
//    AccountOpenObjectPage.getRegisterOption().click();
        reusableMethod.clickElement(loginPage.registerOption);
    }

    @And("Click on the First Name text field and Insert the First Name")
    public void clickOnTheFirstNameTextFieldAndInsertTheFirstName() {
        reusableMethod.sendKeysToElement(loginPage.firstName, reusableMethod.generateRandomFirstName());
    }

    @And("Click on the Last Name text field and Insert the Last Name")
    public void clickOnTheLastNameTextFieldAndInsertTheLastName() {
        reusableMethod.sendKeysToElement(loginPage.lastName, reusableMethod.generateRandomFirstName());
    }

    @And("Click on the Email text field and Insert the Email")
    public void clickOnTheEmailTextFieldAndInsertTheEmail() {
        reusableMethod.sendKeysToElement(loginPage.email, reusableMethod.generateRandomGmail());
    }

    @And("Click on the Telephone text field and Insert the Telephone Number")
    public void clickOnTheTelephoneTextFieldAndInsertTheTelephoneNumber() {
        reusableMethod.sendKeysToElement(loginPage.telephone, reusableMethod.generateRandomPhoneNumber());
    }

    @And("Click on the Password text field and Insert the Password")
    public void clickOnThePasswordTextFieldAndInsertThePassword() {
        reusableMethod.sendKeysToElement(loginPage.password, "Abc123#");
    }

    @And("Click on the Confirm Password text field and Insert the Confirm Password")
    public void clickOnTheConfirmPasswordTextFieldAndInsertTheConfirmPassword() {
        reusableMethod.sendKeysToElement(loginPage.confirmPassword, "Abc123#");
    }

    @And("Click on the Privacy Checkbox")
    public void clickOnThePrivacyCheckbox() {
        reusableMethod.clickElement(loginPage.privacyCheckbox);

    }

    @And("Click on the Continue Button")
    public void clickOnTheContinueButton() {
        reusableMethod.clickElement(loginPage.continueButton);
    }

    @Then("Verify that the New Account Successfully Created")
    public void verifyThatTheNewAccountSuccessfullyCreated() throws InterruptedException {
        reusableMethod.isElementDisplayed(loginPage.accountCreated);
        reusableMethod.getTextOfElement(loginPage.accountCreated);
    }
}
