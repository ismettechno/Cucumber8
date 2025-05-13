package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class _07_GetMetaData extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        ResultSet rs=sorguEkrani.executeQuery("select city_id, city, country_id from city");

        rs.next();  // ilk satırdayım şu anda
        System.out.println("rs.getString(1) = " + rs.getString(1)); // her tipi getString ile alabilirsin
        System.out.println("rs.getString(city_id) = " + rs.getString("city_id"));

        int intID= rs.getInt("city_id");  // Kolonun tipine uygun get ile de alabilirsin
        System.out.println("intID = " + intID);
    }

    @Test
    public void Test2() throws SQLException {
        ResultSet rs=sorguEkrani.executeQuery("select * from city");
        // MetaFizik -> Fizik dışındaki diğer varlıklar
        // MetaData  -> Data dışındaki diğer bilgiler

        ResultSetMetaData rsmd= rs.getMetaData(); // kolon sayısı, isimleri, tipler

        int kolonSayisi= rsmd.getColumnCount();
        System.out.println("kolonSayisi = " + kolonSayisi);

        for (int i = 1; i <= kolonSayisi; i++)
            System.out.println(rsmd.getColumnName(i)+" "+rsmd.getColumnTypeName(i));

        rs.next();  // Data nın ilk satırındayım
        System.out.println("1.satır 1.kolon = " + rs.getString(1));
        System.out.println("1.satır 2.kolon = " + rs.getString(2));
        System.out.println("1.satır 3.kolon = " + rs.getString(3));

        System.out.println();
        // en pratik yöntem
        for (int i = 1; i <= rsmd.getColumnCount() ; i++)
            System.out.println("1.Satır "+i+".Kolon =" + rs.getString(i));


    }





}











