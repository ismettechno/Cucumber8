package ApachePOI;

// TODO :
// YeniExcel2.xlsx adında bir yeni excele merhaba Dünya 1 şeklinde yazı yazınız.
// Daha sonra program her yeniden çalıştırıldığında altına Merhaba Dünya 2...3
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
        String path="src/test/java/ApachePOI/resource/YeniExcel2.xlsx";

        File dosya=new File(path);
        if (!dosya.exists())  // dosya yok ise
        {
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet= workbook.createSheet("sayfa1");

            Row newRow= sheet.createRow(0);
            Cell newCell= newRow.createCell(0);
            newCell.setCellValue("Merhaba Dünya 0");

            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Dosya oluşturuldu");
        }
        else // dosya var ise
        {
            FileInputStream inputStream=new FileInputStream(path);
            Workbook workbook=WorkbookFactory.create(inputStream);
            Sheet sheet= workbook.getSheetAt(0);

            int satirMiktari=sheet.getPhysicalNumberOfRows(); // satır miktarı
            Row newRow= sheet.createRow(satirMiktari);
            Cell newCell= newRow.createCell(0);
            newCell.setCellValue("Merhaba Dünya "+satirMiktari);

            FileOutputStream outputStream=new FileOutputStream(path);
            workbook.write(outputStream);
            workbook.close();
            outputStream.close();
            System.out.println("Dosyaya Eklendi");
        }

        //if dosya yok ise yeni exceli oluştur ve ilk satırı yaz
        //else dosya var ise excel in sonuna satır ekle



    }
}
