package ApachePOI;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class _08_NewExcelWrite {
    public static void main(String[] args) throws IOException {
        // hafızada bir workbook oluşturucam
        // onun içide yine hafızada bir sheet oluşturucam
        // yazma işlemlerini yapıp
        // kaydedicem

        XSSFWorkbook workbook=new XSSFWorkbook(); // hafızada worbook oluşturuldu
        XSSFSheet sheet= workbook.createSheet("Sayfa1"); // hafızada sheet oluşturuldu

        //kalan kısım aynı
        Row yeniSatir= sheet.createRow(0);
        Cell yeniHucre= yeniSatir.createCell(0);
        yeniHucre.setCellValue("Merhaba yeni Excel");

        // ctrl+s  KAYDET
        String path="src/test/java/ApachePOI/resource/YeniExcel.xlsx";
        FileOutputStream outputStream=new FileOutputStream(path);
        workbook.write(outputStream);
        workbook.close();
        outputStream.close();

        System.out.println("İşlem tamamlandı");
    }
}
