package Pages;

import Utilities.GWD;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class ParentPage {
    WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(20));

    public void mySendKeys(WebElement e, String  text)
    {
        wait.until(ExpectedConditions.visibilityOf(e));
        // elemente kadar scroll yap
        e.clear();
        e.sendKeys(text);
    }

    public void myClick(WebElement e)
    {
        wait.until(ExpectedConditions.elementToBeClickable(e));
        // elemente kadar scroll yap
        e.click();
    }



}
