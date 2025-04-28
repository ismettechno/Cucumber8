package ApachePOI;

/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */


import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;

public class _12_Soru {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/resource/ApacheExcel2.xlsx";
        String sheetName = "testCitizen";
        int sutunSayisi = 2;

        ArrayList<ArrayList<String>> sonuc = getData(path, sheetName, sutunSayisi);

        System.out.println("sonuc = " + sonuc);
    }

    public static ArrayList<ArrayList<String>> getData(String path, String sheetName, int sutunSayisi) {
        ArrayList<ArrayList<String>> tablo = new ArrayList<>();
        Sheet sheet=null;

        try {
            FileInputStream inputStream = new FileInputStream(path);
            Workbook workbook = WorkbookFactory.create(inputStream);
            sheet = workbook.getSheet(sheetName);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {  // tüm satırlardaki

            ArrayList<String> satir = new ArrayList<>();
            for (int j = 0; j < sutunSayisi; j++) {  // istenen sütun sayısı kadar
                satir.add(sheet.getRow(i).getCell(j).toString());  // bu döngü ile tüm satır okundu
            }

            tablo.add(satir);
        }

        return tablo;
    }


}
