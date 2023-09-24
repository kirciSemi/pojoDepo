package pojodepo;

import java.util.HashMap;
import java.util.Scanner;

public class DepoSistemi {
    /*
    2. DepoSistemi Sınıfı
    Bu sınıf, depo işlemlerinin gerçekleştirileceği metodları içerecektir. DepoSistemi sınıfında aşağıdaki metodlar yer alacaktır:

    urunTanimlama(): Bu metot, kullanıcıdan ürün adı, üretici ve birim bilgilerini alarak yeni bir ürün tanımlayacaktır. Her ürün için bir id oluşturulacak ve bu id ile birlikte ürün bilgileri bir Map veri yapısında saklanacaktır. Ürünün miktarı başlangıçta 0 olacak ve raf bilgisi "-" olarak atanacaktır.

    urunListele(): Bu metot, tanımlanan ürünleri listelemek için kullanılacaktır. Ürünlerin id, isim, üretici, miktar, birim ve raf bilgileri görüntülenecektir. Eğer ürünün miktarı veya raf bilgisi tanımlanmamışsa, varsayılan değerler kullanılacaktır.

     urunGirisi(): Bu metot, depoya ürün girişi yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve giriş miktarı alınacaktır. Bu bilgilere göre, ilgili ürünün miktarı güncellenecektir.

    urunuRafaKoy(): Bu metot, bir ürünü rafa yerleştirmek için kullanılacaktır. Kullanıcıdan ürünün id numarası ve raf bilgisi alınacaktır. İlgili ürün, verilen raf numarasına göre güncellenecektir.

    urunCikisi(): Bu metot, depodan ürün çıkışı yapmak için kullanılacaktır. Kullanıcıdan ürünün id numarası ve çıkış miktarı alınacaktır. Ürün miktarı güncellenecek ve eğer miktar 0'dan küçük olursa, sadece miktarın 0 olduğu görüntülenecektir. Ürün tanımı silinmeyecektir.
     */

    public HashMap<String,PojoUrun> urunTanimlama(){
        Scanner scan = new Scanner(System.in);
        HashMap<String,PojoUrun> urunler = new HashMap<>();
        String temp = null;
        System.out.println("Ürün tanımlama sayfasına hoşgeldiniz.");
        do {
            System.out.println("Ürün tanımlamak için (E) çıkmak için (H) giriniz");
            temp = scan.next().toUpperCase();
            if(temp.equals("H"))
            {break;}else if(!temp.equals("E"))
            {
                System.out.println("Hatalı giriş yaptınız");
                continue;}
            System.out.println("Tanımlamak istediğiniz ürünün ID bilgisini giriniz");
            String id = scan.next();
            System.out.println("Lütfen urun ismini giriniz");
            String urunIsmi = scan.next();
            System.out.println("Lütfen ürünün üreticisini giriniz");
            String uretici = scan.next();
            System.out.println("Lütfen ürünün birim tipinin numarasını giriniz");
            PojoUrunBirimTipi[] tipler = PojoUrunBirimTipi.values();
            for (int i = 0; i < tipler.length; i++) {
                System.out.println(i+1 + ". "+ tipler[i] );
            }
            int birim = scan.nextInt() -1;
            PojoUrun urun = new PojoUrun(id,urunIsmi,uretici,PojoUrunBirimTipi.values()[birim]);
            urunler.put(id,urun);
        } while (true);
        return urunler;
    }
    public void urunListele(HashMap<String,PojoUrun> urunler){
        System.out.println("-".repeat(90));
        System.out.println(" ".repeat(39)+"DEPO BİLGİSİ"+" ".repeat(40));
        System.out.println("-".repeat(90));
        System.out.printf("%-15s%-15s%-15s%-15s%-15s%-15s\n","|id","|isim","|uretici","|miktari","|birim","|raf");
        System.out.println("-".repeat(90));
        //Set<Map.Entry<String,PojoUrun>>entries = urunler.entrySet();
        for (PojoUrun w:urunler.values())
        {
            System.out.printf("%-15s%-15s%-15s%-15d%-15s%-15s\n",w.getId(),w.getUrunIsmi(),w.getUretici(),w.getMiktar(),w.getBirim(),w.getRaf());
        }
    }

    public void urunGirisi(HashMap<String,PojoUrun> urunler){
        urunListele(urunler);
        Scanner scan = new Scanner(System.in);
        System.out.println("Giriş yapmak istediğiniz ürünün id bilgisini giriniz");
        String id = scan.next();
        System.out.println("Lütfen ürünün mikatrını giriniz");
        int miktar = scan.nextInt();
        int oldMiktar = urunler.get(id).getMiktar();
        int sonMiktar = miktar + oldMiktar;
        urunler.get(id).setMiktar(sonMiktar);
        urunListele(urunler);

    }

    public void urunuRafaKoy(HashMap<String,PojoUrun> urunler){
        urunListele(urunler);
        Scanner scan = new Scanner(System.in);
        System.out.println("Raf düzenlemesi yapmak istediğiniz ürünün id bilgisini giriniz");
        String id = scan.next();
        System.out.println("Ürünün yerleştirileceği raf bilgisini giriniz");
        String raf = scan.next();
        urunler.get(id).setRaf(raf);
        urunListele(urunler);
    }
    public void urunCikisi(HashMap<String,PojoUrun> urunler){
        urunListele(urunler);
        Scanner scan = new Scanner(System.in);
        System.out.println("Çıkış yapmak istediğiniz ürünün id bilgisini giriniz");
        String id = scan.next();
        System.out.println("Çıkış yapmak istediğiniz miktarı giriniz");
        int miktar = scan.nextInt();
        int oldMiktar = urunler.get(id).getMiktar();
        if(miktar>oldMiktar)
        {
            System.out.println("Stoktaki ürün miktarından fazla ürün çıkışı yapamazsınız");
            urunListele(urunler);
        }else if(miktar == oldMiktar)
        {
            urunler.remove(id);
            System.out.println("Stoktaki ürün miktarının tamammı çıkıldı ve ürün stoktan silindi");
            urunListele(urunler);
        }else {
            int sonMiktar = oldMiktar - miktar;
            urunler.get(id).setMiktar(sonMiktar);
            urunListele(urunler);
        }
    }


//    Set<Map.Entry<String,Integer>> entries = countryPopulation.entrySet();
//        System.out.println(entries);
//
//    int toplam = 0;
//        for (Map.Entry<String,Integer> w :
//    entries) {
//        toplam = toplam + w.getKey().length() + w.getValue();
//    }
}
