package ApachePOI;

/**
 * Excel Çarpım tablosunu
 * YENİ bir excel dosyasına
 * 1 den 10 kadar çarpımlar için yapınız.
 */

public class _10_Soru {
    public static void main(String[] args) {

        for (int i = 1; i < 10; i++) {

            for (int j = 1; j < 10; j++) {
                System.out.println(j+"x"+i+"="+(j*i));
            }

            System.out.println();
        }


    }
}
