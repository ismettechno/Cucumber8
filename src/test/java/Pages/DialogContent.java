package Pages;

import Utilities.GWD;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

public class DialogContent extends ParentPage{

    public DialogContent() {
        PageFactory.initElements(GWD.getDriver(), this);
    }

    @FindBy(css="[formcontrolname='username']")
    public WebElement username;

    @FindBy(css="[formcontrolname='password']")
    public WebElement password;

    @FindBy(css="[aria-label='LOGIN']")
    public WebElement loginButton;

    @FindBy(css="span[class='mat-mdc-tooltip-trigger logo-text']")
    public WebElement headText;

    @FindBy(xpath="//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    public WebElement addButton;

    @FindBy(xpath="//*[@formcontrolname='name']//input")
    public WebElement nameInput;

    @FindBy(xpath="//*[@formcontrolname='code']//input")
    public WebElement codeInput;

    @FindBy(xpath="//ms-save-button[@class='ng-star-inserted']//button")
    public WebElement saveButton;

    @FindBy(xpath="//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath="//*[@formcontrolname='shortName']//input")
    public WebElement shortName;

    @FindBy(xpath="//div[contains(text(),'already')]")
    public WebElement alreadyMessage;



    public void verifyMessageContainsText(WebElement element, String serchText){
        wait.until(ExpectedConditions.visibilityOf(element));
        Assert.assertTrue(element.getText().toLowerCase().contains(serchText.toLowerCase()));

        // mesaj html kodları gelene kadar bekle
        //wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.xpath("//hot-toast-container/div/div/div//*"),0));
        //Assert.assertTrue(successMessage.getAttribute("innerHTML").toLowerCase().contains(serchText.toLowerCase()));
        // gettext e ulaşılamdığından HTML (innerHTML)  kodlarında succesfully yazısı kontrol edildi
    }

}
