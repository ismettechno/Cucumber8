package Utilities;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;
import java.util.ArrayList;

public class ExcelUtility {

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
