package ApachePOI;

// TODO :
// YeniExcel2.xlsx adında bir yeni excele merhaba Dünya 0 şeklinde yazı yazınız.
// Daha sonra program her yeniden çalıştırıldığında altına Merhaba Dünya 1.2.3
// şeklinde eklesin. Yani dosya yok ise oluşturup yazsın, daha sonra hep altına eklesin.

// File dosya=new File(path)
// if ( dosya.exists() )    dosya var ise

// Merhaba Dünya 1
// Merhaba Dünya 2
// Merhaba Dünya 3
// ...

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _09_Soru {
    public static void main(String[] args) throws IOException {
        String path = "src/test/java/ApachePOI/resource/YeniExcel3.xlsx";

        File dosya = new File(path);
        //if dosya yok ise yeni exceli oluştur ve ilk satırı yaz
        if (!dosya.exists()) // dosya yok ise
        {
            //hafızada worbook oluştur
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("Sayfa1");

            //değeri set et
            Row row = sheet.createRow(0); // ilk satır
            Cell cell = row.createCell(0); // ilk sutun
            cell.setCellValue("Merhaba Dünya 0");

            //kaydet
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Dosya oluşturuldu ilk satır eklendi.");
        }
        //else dosya var ise excel in sonuna satır ekle
        else {  //dosya var ise
            // var olan dosyanın workbook unu al ve hafızada oluştur
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet= workbook.getSheetAt(0);

            // en son satır indexini al ve bilgiyi ekle
            int satirSayisi=sheet.getPhysicalNumberOfRows();
            Row row=sheet.createRow(satirSayisi); // en son boş satır açıldı
            Cell cell=row.createCell(0);
            cell.setCellValue("Merhaba Dünya "+satirSayisi);

            inputStream.close();

            //kaydet
            FileOutputStream outputStream = new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Dosyaya sıradaki satır eklendi.");
        }

    }
}











