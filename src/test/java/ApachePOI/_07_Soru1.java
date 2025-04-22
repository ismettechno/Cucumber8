package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *  Ekrandaki gibi bir Excel Çarpım tablosunu
 *  varolan boş bir excel dosyasına
 *  1 den 10 kadar çarpımlar için yapınız.
 *  (ipucu önce sadece 1 leri yapınız sonra
 *  diğerlerini)
 */
//        1 x 1 = 1
//        1 x 2 = 2
//        1 x 3 = 3
//        1 x 4 = 4
//        1 x 5 = 5
//        1 x 6 = 6
//        1 x 7 = 7
//        1 x 8 = 8
//        1 x 9 = 9
//        1 x 10 = 10

public class _07_Soru1 {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path);//okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        int yeniSatirNo=0;
        for (int i = 1; i <= 10; i++) {
            //System.out.println( "1x"+i+"="+(1*i) );

            Row yeniSatir=sheet.createRow(yeniSatirNo++);

            Cell hucre1=yeniSatir.createCell(0); hucre1.setCellValue(1);     // 1
            Cell hucre2=yeniSatir.createCell(1); hucre2.setCellValue("x");   // 1 x
            Cell hucre3=yeniSatir.createCell(2); hucre3.setCellValue(i);     // 1 x 3
            Cell hucre4=yeniSatir.createCell(3); hucre4.setCellValue("=");   // 1 x 3 =
            Cell hucre5=yeniSatir.createCell(4); hucre5.setCellValue((1*i)); // 1 x 3 = 3
        }

        inputStream.close();
        // hafızada oluşan Workbook u kaydedelim
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem tamamlandı");
    }
}










