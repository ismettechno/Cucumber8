package StepDefinitions;

import Pages.DialogContent;
import Pages.LeftNav;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;

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
}
