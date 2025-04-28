package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 */

public class _10_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/carpimTablosu.xlsx";

        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet= workbook.createSheet("Sayfa1");

        int yeniSatirIndex=0;
        for (int i = 1; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                Row yeniSatir=sheet.createRow(yeniSatirIndex++);
                  //System.out.println(j+"x"+i+"="+(j*i)); // 5 hücre

                Cell cell1=yeniSatir.createCell(0); cell1.setCellValue(i);
                Cell cell2=yeniSatir.createCell(1); cell2.setCellValue("x");
                Cell cell3=yeniSatir.createCell(2); cell3.setCellValue(j);
                Cell cell4=yeniSatir.createCell(3); cell4.setCellValue("=");
                Cell cell5=yeniSatir.createCell(4); cell5.setCellValue(i*j);
            }

            //System.out.println();
            sheet.createRow(yeniSatirIndex++);
        }

        //kaydet
        FileOutputStream outputStream = new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();
        System.out.println("İşlem tamamlandı");
    }
}
