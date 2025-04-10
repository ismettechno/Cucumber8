package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;

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
        dc.mySendKeys(dc.searchInput,  name);
        dc.myClick(dc.searchButton);

        //TODO : buraya bir bekletme koymak
        dc.myClick(dc.deleteImageBtn);
        dc.myClick(dc.deleteDialogBtn);
    }
}
