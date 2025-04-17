package Utilities;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Locale;

import java.time.Duration;

public class GWD {
   private static WebDriver driver;

   public static WebDriver getDriver()
   {
       Locale.setDefault(new Locale("EN"));
       System.setProperty("user.language", "EN");

       if (driver == null) { //henüz ilk başta çalışsın
           driver = new ChromeDriver();
           driver.manage().window().maximize();
           driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       }

       return driver;
   }


   public static void quitDriver()
   {
       //test sonucu ekranı bir miktar beklesin diye
       try {
           Thread.sleep(5000);
       } catch (InterruptedException e) {
           throw new RuntimeException(e);
       }

       if (driver != null) // var ise
       {
           driver.quit();
           driver=null;
       }
   }





}
