package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class _06_WriteInTheExcel {

    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/resource/WriteInTheExcelFile.xlsx";
        FileInputStream inputStream=new FileInputStream(path);//okuma modunda açıldı
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet=workbook.getSheetAt(0);

        int satirMiktari= sheet.getPhysicalNumberOfRows(); // şu an kaç satır var
        Row yeniSatir= sheet.createRow(satirMiktari); // en son boş yere yazar
        Cell yeniHucre= yeniSatir.createCell(0); // satırın ilk hucresini oluştur.
        yeniHucre.setCellValue("Merhaba Dünya");

        //okuma modunu kapat
        inputStream.close();// aynı anda okuma ve kaydetme yapılamıyor, okuma modu kapatıldı

        // dosyayı kaydet (Save tuşuna bas)
        FileOutputStream outputStream=new FileOutputStream(path); // yazma modunda aç
        workbook.write(outputStream); // hazıfazadki workbook u path i verilen dosyaya yaz
        workbook.close(); // hafıza boşaltıldı
        outputStream.close(); // yazma modu kapatıldı.

        System.out.println("İşlem tamamlandı");
    }

}
