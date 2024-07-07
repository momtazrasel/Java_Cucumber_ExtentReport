package stepDefinitions.CreateAccount;

import base.PageObjectManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import locators.CreateAccountObjects;
import org.openqa.selenium.WebDriver;
import utils.DriverSetup;

public class CreateAccountSteps {

    private final PageObjectManager pom;
    private final CreateAccountObjects accountPage = new CreateAccountObjects();

    public CreateAccountSteps(DriverSetup driverSetup) {
        WebDriver driver = driverSetup.driver;
        this.pom = new PageObjectManager(driver);
    }
//    @When("Click on the My Account Button")
//    public void clickOnTheMyAccountButton() {
//        pom.waitUntilElementIsVisible(accountPage.myAccountButton);
//        pom.clickElement(accountPage.myAccountButton);
//    }

    @When("Click on the My Account Icon")
    public void clickOnTheMyAccountIcon() {
        pom.waitUntilElementIsVisible(accountPage.myAccountButton);
        pom.clickElement(accountPage.myAccountButton);
    }

}
