package pojodepo;

import java.util.HashMap;
import java.util.Scanner;

public class PojoDepoRunner {

    public static void main(String[] args) {
        DepoSistemi dp = new DepoSistemi();
        HashMap<String , PojoUrun> urunler = new HashMap<>();

        System.out.println("PojoDepo Programına Hoşgeldiniz");
        Scanner scan = new Scanner(System.in);
        do {
            System.out.println("Yapmak istediğiniz işlemin numarasını giriniz\nÇıkmak için 0 giriniz.");
            System.out.println("1. Ürün Tanımlama\n2. Ürün Listeleme\n3. Ürün Girişi yapma\n4. Ürünü Rafa koyma\n5. Ürün çıkışı yapma");
            int control = scan.nextInt();
            if(control==0)
            {
                break;
            }
            switch (control){
                case 1:
                    urunler.putAll(dp.urunTanimlama());
                    break;
                case 2:
                    dp.urunListele(urunler);
                    break;
                case 3:
                    dp.urunGirisi(urunler);
                    break;
                case 4:
                    dp.urunuRafaKoy(urunler);
                    break;
                case 5:
                    dp.urunCikisi(urunler);
                    break;
            }
        } while (true);

        System.out.println("PojoDepo Programından çıkış yaptınız");

    }
}
