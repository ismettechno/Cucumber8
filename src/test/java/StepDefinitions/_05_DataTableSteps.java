package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import Utilities.GWD;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class _05_DataTableSteps {
    LeftNav ln=new LeftNav();
    DialogContent dc=new DialogContent();

    @And("Click on the Element LeftNav")
    public void clickOnTheElementLeftNav(DataTable linkler) {
        List<String> listLinkler= linkler.asList(); //setup, parameters, countries

        for (int i = 0; i < listLinkler.size(); i++) {
            ln.myClick(  ln.getWebElement(listLinkler.get(i))  );
        }
    }

    @And("Click on the Element Dialog")
    public void clickOnTheElementDialog(DataTable butonlar) {
        List<String> listbutonlar= butonlar.asList(); //setup, parameters, countries

        for (int i = 0; i < listbutonlar.size(); i++) {
            dc.myClick(  dc.getWebElement(listbutonlar.get(i))  );
        }
    }

    @And("User sending the keys in Dialog")
    public void userSendingTheKeysInDialog(DataTable kutuVeYazi) {
        List<List<String>> listkutuVeYazi= kutuVeYazi.asLists();

        for (int i = 0; i < listkutuVeYazi.size(); i++) {
            dc.mySendKeys( dc.getWebElement(listkutuVeYazi.get(i).get(0) ),
                           listkutuVeYazi.get(i).get(1) );
        }
    }


    @And("User delete the element from dialog")
    public void userDeleteTheElementFromDialog(DataTable silinecekler) {
        List<String> listSilinecekler= silinecekler.asList();

        for (int i = 0; i < listSilinecekler.size(); i++) {
            dc.deleteItem( listSilinecekler.get(i) );
        }

    }

    @And("User sending the Enter keys in Dialog")
    public void userSendingTheEnterKeysInDialog() {
        new Actions(GWD.getDriver()).sendKeys(Keys.ENTER).build().perform();
    }
}
