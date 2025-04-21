package ApachePOI;

import org.apache.poi.ss.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;
// olmayan satır yazdırılmaya çalışılırsa null pointer exception
// olmayan hücre yazdırılmaya çalışılırsa null yazar
public class _04_ApachePOIGetAllData {
    public static void main(String[] args) throws IOException {
        String path="src/test/java/ApachePOI/Resource/ApacheExcel2.xlsx";
        FileInputStream inputStream=new FileInputStream(path);
        Workbook workbook= WorkbookFactory.create(inputStream);
        Sheet sheet= workbook.getSheetAt(0); // 0.sheet i ver

        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {   // satir miktarı  zoo.length

            for (int j = 0; j < sheet.getRow(i).getPhysicalNumberOfCells(); j++) {  // ilgili satirdaki hucre sayısı
                System.out.print(sheet.getRow(i).getCell(j)+" "); // zoo[i][j]
            }

            System.out.println();
        }
    }
}
