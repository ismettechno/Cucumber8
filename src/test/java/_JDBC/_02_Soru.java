package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

// city tablosundaki tüm satırlardaki şehir isimlerini next ile yazdırınız
public class _02_Soru {

    @Test
    public void Test1() throws SQLException {
        String serverUrl="jdbc:mysql://demo.mersys.io:33906/sakila";  //port,dbname,mySql
        String username="student";
        String password="DEkzTd3#pzPm";

        Connection baglanti= DriverManager.getConnection(serverUrl,username,password);
        Statement sorguEkrani= baglanti.createStatement();
        ResultSet sonucTablosuGostergesi= sorguEkrani.executeQuery("select * from city");

         while(sonucTablosuGostergesi.next())  // sonuc tablosunun sonuna git
             System.out.println(sonucTablosuGostergesi.getString("city"));

         baglanti.close();
    }

}
