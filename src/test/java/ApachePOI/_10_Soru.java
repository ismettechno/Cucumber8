package ApachePOI;



import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO :
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 * a) alt alta   TODO : b) yan yana
 */

public class _10_Soru {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/CarpimTablosu.xlsx";

        XSSFWorkbook workbook=new XSSFWorkbook();  // excelin olmayan hafızada workbook oluştur
        XSSFSheet sheet= workbook.createSheet("Sayfa1");

        int satirNo=0;
        for (int i = 1; i <= 10; i++) {

            for (int j = 1; j <= 10; j++) {
               // System.out.println(i+"x"+j+"="+(i*j));

               //yeni bir satır aç
               //bu yeni satırda 5 tane yanyana hücre aç i,x,j,=,sonuc
                Row yeniSatir= sheet.createRow(satirNo++);

                Cell hucre1= yeniSatir.createCell(0); hucre1.setCellValue(i);
                Cell hucre2= yeniSatir.createCell(1); hucre2.setCellValue("x");
                Cell hucre3= yeniSatir.createCell(2); hucre3.setCellValue(j);
                Cell hucre4= yeniSatir.createCell(3); hucre4.setCellValue("=");
                Cell hucre5= yeniSatir.createCell(4); hucre5.setCellValue(i*j);
            }

            sheet.createRow(satirNo++); // boş bir satır ekle
        }

        // kaydetme işlemi
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem tamamlandı");
    }
}
