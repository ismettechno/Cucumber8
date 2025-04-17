package StepDefinitions;

import Utilities.GWD;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;


public class Hooks {

    @After// Cucumber ın Annotation ı
           // her senaryodan sonra otomatik çalışır
    public void after(Scenario senaryo)
    {



        GWD.quitDriver();
    }


}
