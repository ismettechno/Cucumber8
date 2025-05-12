package _JDBC;

import org.testng.annotations.Test;

import java.sql.ResultSet;
import java.sql.SQLException;

public class _03_NextPrevAbsRel extends JDBCParent{

    @Test
    public void Test1() throws SQLException {
        ResultSet rs= sorguEkrani.executeQuery("select * from language"); //lang id, name, date

        rs.next(); // 1 adım ileri
        System.out.println("1.Satır = " + rs.getString("name")); // English

        rs.next(); // 1 adım daha ileri
        System.out.println("2.Satır = " + rs.getString("name")); // Italian

        rs.previous(); // 1 adım geri gel
        System.out.println("1.Satır = " + rs.getString("name")); // English
    }

    @Test
    public void Test2() throws SQLException {
        ResultSet rs=sorguEkrani.executeQuery("select * from film");

        rs.absolute(10); // direk baştan sayarak 10.satıra gider
        System.out.println("10.Satır = " + rs.getString("title")); // ALADDIN CALENDAR

        rs.absolute(5); // direk baştan sayarak 5.satıra gider
        System.out.println("5.Satır = " + rs.getString("title"));  // AFRICAN EGG

        rs.relative(5);  // kaldığı yerden 5.satıra ileri gider ,
        System.out.println("10.Satır = " + rs.getString("title")); // ALADDIN CALENDAR

        rs.next(); // kaçıncı satıra gider ?
        System.out.println("11.Satır = " + rs.getString("title")); //ALAMO VIDEOTAPE
    }

// rs.next() : sonraki satır
// rs.previous : önceki satır
// rs.absolute(10) : baştan itibaren 10.satıra ileri gider.
// rs.relative(10) : bulunduğu yerden 10.satıra ileri gider.
// rs.absolute(-10) : - (eksi) sondan demektir, sondan 10.satır
// rs.relative(-5) :  - (eksi) bulunduğu yerden 5 satır geri
// ilk satırdan relative ile 5 geri gitmek istersek sınırı taştığı için hata verecektir


}
