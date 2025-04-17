package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class _03_CitizenShipSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Navigate to CitizenShip")
    public void navigateToCitizenShip() {
        ln.myClick(ln.setup);
        ln.myClick(ln.parameters);
        ln.myClick(ln.citizenship);
    }

    @When("Create a CitizenShip")
    public void createACitizenShip() {
        String citizenshipName= RandomStringUtils.randomAlphanumeric(8);//8 harf
        String citizenshipShortName = RandomStringUtils.randomNumeric(4);//4 rakam

        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,citizenshipName);
        dc.mySendKeys(dc.shortName, citizenshipShortName);
        dc.myClick(dc.saveButton);
    }

    @When("Create a CitizenShip name as {string} shortkod as {string}")
    public void createACitizenShipNameAsShortkodAs(String name, String shortkod) {
        dc.myClick(dc.addButton);
        dc.mySendKeys(dc.nameInput,name);
        dc.mySendKeys(dc.shortName, shortkod);
        dc.myClick(dc.saveButton);
    }

    @Then("Already exist message should be displayed")
    public void alreadyExistMessageShouldBeDisplayed() {
        dc.verifyMessageContainsText(dc.alreadyMessage,"");
    }

    @When("user delete name as {string}")
    public void userDeleteNameAs(String name) {

       dc.deleteItem(name);
    }
}
