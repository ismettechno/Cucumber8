package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _06_Soru extends JDBCParent{
    // city tablosundaki tüm satırlardaki şehir isimlerini absolute ile yazdırınız

    @Test
    public void Test1() throws SQLException {
        ResultSet rs= sorguEkrani.executeQuery("select city from city");

        //1.Yol
        int rowNo=1;
        while (rs.absolute(rowNo++))
            System.out.println(rs.getString("city"));

        System.out.println("------------------");

        //2.Yol
        rs.last();
        int sonSatirNo=rs.getRow();
        for (int i = 1; i <  sonSatirNo; i++) {
            rs.absolute(i);
            System.out.println(rs.getString("city"));
        }
    }





    //city tablosundaki tüm satırlardaki şehir isimlerini relative ile yazdırınız
    @Test
    public void Test2()
    {

    }

}














