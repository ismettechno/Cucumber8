package _JDBC;

import org.testng.annotations.Test;

import java.sql.*;

public class _01_Giris {

    @Test
    public void Test1() throws SQLException {
        String serverUrl="jdbc:mysql://demo.mersys.io:33906/sakila";  //port,dbname,mySql
        String username="student";
        String password="DEkzTd3#pzPm";

        //1- bağlantı bilgilerini girdik DB server bağlandık
        Connection baglanti= DriverManager.getConnection(serverUrl,username,password);

        //2- Sorgu ekranını açtık
        Statement sorguEkrani= baglanti.createStatement();

        //3- Sorgu ekranına sorguyu yazdım ve çalıştırdım
        ResultSet sonucTablosuGostergesi= sorguEkrani.executeQuery("select * from customer");

        //4- Sonuçlar elimizde satır satır ilerleyerek bakalım
        sonucTablosuGostergesi.next(); // ilk satıra geldim.
        String ad= sonucTablosuGostergesi.getString("first_name");
        String soyad= sonucTablosuGostergesi.getString("last_name");
        System.out.println("1.Satırın ad ve soyadı = " + ad+" "+soyad);

        sonucTablosuGostergesi.next(); // 2. satıra geldim.
        ad= sonucTablosuGostergesi.getString("first_name");
        soyad= sonucTablosuGostergesi.getString("last_name");
        System.out.println("2.Satırın ad ve soyadı = " + ad+" "+soyad);

        baglanti.close();
    }

}
