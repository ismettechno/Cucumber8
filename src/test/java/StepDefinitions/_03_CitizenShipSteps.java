package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.ExcelUtility;
import Utilities.GWD;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

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

    @When("User create citizenship with ApchePOI")
    public void userCreateCitizenshipWithApchePOI() {
        // excelden oku ve kaydet
        ArrayList< ArrayList<String>> tablo=
        ExcelUtility.getData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx",
                "testCitizen",2);

        for (ArrayList<String> satir : tablo)
        {
            dc.myClick(dc.addButton);
            dc.mySendKeys(dc.nameInput, satir.get(0));
            dc.mySendKeys(dc.shortName, satir.get(1));
            dc.myClick(dc.saveButton);
            dc.verifyMessageContainsText(dc.successMessage, "successfully");
        }
    }

    @Then("User delete citizenship with ApchePOI")
    public void userDeleteCitizenshipWithApchePOI() {
        // excelden oku ve sil
        ArrayList< ArrayList<String>> tablo=
                ExcelUtility.getData("src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx",
                        "testCitizen",1);

        for (ArrayList<String> satir : tablo)
        {
            dc.deleteItem(satir.get(0));
            dc.verifyMessageContainsText(dc.successMessage, "successfully");
        }

    }

}
