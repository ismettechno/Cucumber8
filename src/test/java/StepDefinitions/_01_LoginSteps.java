package StepDefinitions;

import Pages.DialogContent;
import Utilities.GWD;
import io.cucumber.java.en.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class _01_LoginSteps {
    DialogContent dc = new DialogContent();

    @Given("Navigate to Campus")
    public void navigate_to_campus() {
        GWD.getDriver().get("https://test.mersys.io/");
    }

    @When("Enter username and password and click login button")
    public void enter_username_and_password_and_click_login_button() {
//        WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));
//        wait.until(ExpectedConditions.visibilityOf(dc.username));
//
//        dc.username.sendKeys("turkeyts");
//        dc.password.sendKeys("TS.%=2025TR");
//        dc.loginButton.click();

        dc.mySendKeys(dc.username, "Campus25");
        dc.mySendKeys(dc.password, "Campus.2524");
        dc.myClick(dc.loginButton);

    }

    @Then("User should login successfully")
    public void user_should_login_successfully() {
        dc.wait.until(ExpectedConditions.textToBePresentInElement(dc.headText, "Internship"));
        Assert.assertTrue(dc.headText.getText().equals("Internship"));
    }


}
