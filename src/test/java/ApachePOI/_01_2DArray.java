package ApachePOI;

public class _01_2DArray {

    public static void main(String[] args) {
        String[][] zoo={
                {"Aslan","1"},
                {"Kaplan","2"},
                {"Zebra","3","1"},
                {"Fil","4"}
        };

        System.out.println("------------------------");
        System.out.println(zoo[1][0]);  // satır x sütun 1.satırın 0.elemanı
        System.out.println(zoo[1][1]);  // 1.satırın 1.elemanı
        System.out.println("------------------------");

        for (int i = 0; i < zoo.length ; i++) {  // satırların miktarı kadar sayacak

            for (int j = 0; j < zoo[i].length ; j++) {  // her satırdaki hücre sayısı kadar sayacak
                System.out.print(zoo[i][j]+" "); // i.satırın , j.hücresi veya sütunu
            }

            System.out.println();
        }
    }

}
