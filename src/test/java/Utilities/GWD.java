package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Locale;

import java.time.Duration;

public class GWD {
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<>();// thread e özel driver
    public static ThreadLocal<String> threadBrowserName = new ThreadLocal<>();
    //driver -> threadDriver.get() -> bulunduğum thread deki driver ı al
    //threadDriver.set(driver) -> bulunduğum threade driver set et

    public static WebDriver getDriver() {
        Locale.setDefault(new Locale("EN"));
        System.setProperty("user.language", "EN");

        switch (threadBrowserName.get()) {
            case "edge" : threadDriver.set(new EdgeDriver()); break;
            case "firefox" : threadDriver.set(new FirefoxDriver()); break;
            default : threadDriver.set(new ChromeDriver());// bu thread e bir chrome oluştur ve set et
        }

        threadDriver.get().manage().window().maximize();  // bu hattaki driverı max et
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


        return threadDriver.get();
    }


    public static void quitDriver() {
        //test sonucu ekranı bir miktar beklesin diye
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (threadDriver.get() != null) // var ise
        {
            threadDriver.get().quit();
            WebDriver driver=threadDriver.get();
            driver=null;
            threadDriver.set(driver);
        }
    }


}
