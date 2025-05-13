package _JDBC;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;

public class _09_DBUtilitySoru {
    public static Connection baglanti;
    public static Statement sorguEkrani;


    public static void main(String[] args) {
        // Gönderilen sorgu sonucundaki tüm datayı bir List olarak döndüren metodu yazınız.

        String sorguSql="select * from language";

        ArrayList< ArrayList<String> > donenData= getListData(sorguSql);

    }

    public static ArrayList< ArrayList<String> > getListData(String sorgu){
        ArrayList< ArrayList<String> > donecekTablo=new ArrayList<>();
        DBConnectionOpen();

        // gelen sorguyu alıp , DB den çalıştırıp, donecek tabloya atınız.


        DBConnectionClose();
        return  donecekTablo;
    }



    public static void DBConnectionOpen() {
        String serverUrl = "jdbc:mysql://demo.mersys.io:33906/sakila";  //port,dbname,mySql
        String username = "student";
        String password = "DEkzTd3#pzPm";

        try {
            baglanti = DriverManager.getConnection(serverUrl, username, password);
            sorguEkrani = baglanti.createStatement();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

    public static void DBConnectionClose() {
        try {
            baglanti.close();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }


}
