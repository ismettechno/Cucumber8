package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
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

        if (threadBrowserName.get() == null) // XML den çalışmayacak diğer testlerde tarayıcı boş geldiğinde
            threadBrowserName.set("chrome");  // tarayıcı adı CHROME olarak default olsun

        System.out.println(threadBrowserName.get());

        if (threadDriver.get() == null) { //1 kez oluştur

            switch (threadBrowserName.get()) {
                case "edge":
                    threadDriver.set(new EdgeDriver());
                    break;
                case "firefox":
                    threadDriver.set(new FirefoxDriver());
                    break;
                default:
                    if (isRunningOnJenkins()) {
                        // madem jenkins de çalışıyorsun max boyutta ve başlıksız çalış
                        //Jenkins için Chrome memory maximize edildi ve hafızada çalışır hale getirildi
                        ChromeOptions ChromeOptions = new ChromeOptions();
                        ChromeOptions.addArguments("--headless", "--no-sandbox", "--disable-dev-shm-usage", "--disable-gpu", "--window-size=1400,2400");

                        threadDriver.set(new ChromeDriver(ChromeOptions));
                    }
                    else
                    {
                        threadDriver.set(new ChromeDriver());// bu thread e bir chrome oluştur ve set et
                    }



            }
        }

        threadDriver.get().manage().window().maximize();  // bu hattaki driverı max et
        threadDriver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));


        return threadDriver.get();
    }

    public static boolean isRunningOnJenkins() {
        String jenkinsHome = System.getenv("JENKINS_HOME");
        return jenkinsHome != null && !jenkinsHome.isEmpty();
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
            threadDriver.get().quit();           // tarayıcı kapat, hafızada(thread) değişken duruyor
            WebDriver driver=threadDriver.get(); // thread de ki değişkeni al
            driver=null;                         // değişkene NULL değerini ata
            threadDriver.set(driver);            // thread e bu değişkeni set et
        }
    }


}
