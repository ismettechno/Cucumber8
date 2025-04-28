package ApachePOI.Resource;

/*
   Main den bir metod çağırmak suretiyle, path i ve sheetName i verilen excelden
   istenilen sütun kadar veriyi okuyup bir List e atınız.
   Bu soruda kaynak Excel için : ApacheExcel2.xlsx  in 2.sheet ini kullanabilirsiniz.
 */


import java.util.ArrayList;

public class _12_Soru {
    public static void main(String[] args) {
        String path = "src/test/java/ApachePOI/resource/YeniExcel3.xlsx";
        String sheetName="testCitizen";
        int sutunSayisi=4;

        ArrayList< ArrayList<String> > sonuc=getData(path,sheetName, sutunSayisi);
    }

    public static ArrayList< ArrayList<String> > getData(String path, String sheetName, int sutunSayisi)
    {

    }


}
