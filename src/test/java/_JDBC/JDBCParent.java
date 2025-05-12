package _JDBC;

import org.testng.annotations.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCParent {
    public static Connection baglanti;
    public static Statement sorguEkrani;

    @BeforeClass
    public void DBConnectionOpen() {
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

    @AfterClass
    public void DBConnectionClose() {
        try {
            baglanti.close();
        } catch (Exception ex) {
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }
    }

}
