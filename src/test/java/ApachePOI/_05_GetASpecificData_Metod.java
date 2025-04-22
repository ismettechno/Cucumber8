package ApachePOI;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

/**
 * Kullanıcı aşağıdaki excelde, 1.sutundaki bilgilerden istediğini girecek
 * karşılığında bu bilginin satırındaki karşılık gelen bilgilerin tamamı yazdırılacak.
 * yani metoda "Password" kelimesi gönderilecek, dönen değer Password un değeri olacak.
 * bulup ve sonucun döndürülmesi için metod kullanınız.
 * src/test/java/ApachePOI/resources/LoginData.xlsx
 */

public class _05_GetASpecificData_Metod {
    public static void main(String[] args) throws IOException {

        Scanner oku=new Scanner(System.in);
        System.out.print("Aranacak kelimeyi giriniz=");
        String arananKelme=oku.nextLine();

        String sonuc=ExceldenGetir(arananKelme);
        System.out.println("sonuc = " + sonuc);
    }

    public  static  String ExceldenGetir(String arananKelme) throws IOException {
        String donecek="";

        String path="src/test/java/ApachePOI/Resource/LoginData.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet= workbook.getSheetAt(0); // 0.sheet i ver

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {

            if (sheet.getRow(i).getCell(0).toString().equalsIgnoreCase(arananKelme)) // aranan kelime bulunmuş sa
            {
                for (int j = 1; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {
                    donecek += sheet.getRow(i).getCell(j)+" ";
                }
            }
        }

        return donecek;
    }


}
