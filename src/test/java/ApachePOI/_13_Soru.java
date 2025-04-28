package ApachePOI;


/*
   Main den bir metod çağırmak suretiyle, henüz oluşturulmamış
   path i verilen excel için, program her çalıştıkça içine "test passed"
   yazısını ekleyen metodu yazınız.
   Yani dosya yoksa oluştur ilk satıra yaz, sonra dosya oluşacağı için
   dosya varsa en son satırın altına yaz.

   File dosya= new File(path); //dosya kontrolü

if (!file.exists()) //dosya yok ise
{
  oluşturup
  merhaba düznya yazsın
}
else
{
   var olan dosyaya eklesin
  }

 */

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class _13_Soru {
    public static void main(String[] args) {
        String path="src/test/java/ApachePOI/resource/TestSonuclari.xlsx";
        String senaryoAdi="Create Country";
        String testSonuc="Test Passed";

        writeToExcel(path, senaryoAdi, testSonuc); //excel create
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
        writeToExcel(path, senaryoAdi, testSonuc); //dosya artık var ekleyecek
    }

    public static void writeToExcel(String path, String senaryoAdi, String testSonuc){
        File dosya=new File(path);

        try {
            if (!dosya.exists()) {
                XSSFWorkbook workbook = new XSSFWorkbook();
                XSSFSheet sheet = workbook.createSheet("TestSonuc");

                Row row = sheet.createRow(0);
                Cell cell1 = row.createCell(0);cell1.setCellValue(senaryoAdi);
                Cell cell2 = row.createCell(1);cell2.setCellValue(testSonuc);

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                System.out.println("Dosya oluşturuldu.");
            }
            else
            {
                FileInputStream inputStream=new FileInputStream(path);
                Workbook workbook= WorkbookFactory.create(inputStream);
                Sheet sheet= workbook.getSheetAt(0);

                Row row = sheet.createRow(sheet.getPhysicalNumberOfRows());
                Cell cell1 = row.createCell(0);cell1.setCellValue(senaryoAdi);
                Cell cell2 = row.createCell(1);cell2.setCellValue(testSonuc);

                FileOutputStream outputStream = new FileOutputStream(path);
                workbook.write(outputStream);
                workbook.close();
                outputStream.close();
                System.out.println("Ekleme yapıldı");
            }

        }
        catch (Exception ex){
            System.out.println("ex.getMessage() = " + ex.getMessage());
        }



    }




}
