package pojodepo;

public class PojoUrun {
    /*
    Depo Projesi
    Bu projede, bir fabrikada kullanılan bir depo sistemi olan Depo Uygulaması Java programlama dili kullanılarak gerçekleştirilecektir. Proje, aşağıdaki 3 sınıftan oluşacaktır:

            1. PojoUrun Sınıfı
    PojoUrun sınıfı aşağıdaki özelliklere sahip olacaktır:

    id
    urunIsmi
    uretici
    miktar
    birim
    raf

    Bu sınıfın getter ve setter metotları bulunacaktır.

     3. Runner Sınıfı
    Bu sınıf, projenin çalıştırılmasını sağlayacak bir Runner sınıfıdır. Bu sınıf içinde DepoSistemi sınıfının nesnesi oluşturulacak ve ilgili metotlar çağrılacaktır.

    Proje Senaryosu
    Aşağıda, projenin senaryosu ve örnek bir kullanımı verilmiştir:

    DepoSistemi depo = new DepoSistemi();

depo.urunTanimlama("1000", "Un", "Hekimoğlu", "Cuval");
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   0          Cuval     -

depo.urunGirisi("1000", 5);
depo.urunListele();

// Çıktı:
// id     ismi    ureticisi   miktari    birimi    raf
// --------------------------------------------------
// 1000   Un      Hekimoğlu   5          Cuval     -

    depo */
    /*
    id
    urunIsmi
    uretici
    miktar
    birim
    raf
     */
    private String id;
    private String urunIsmi;
    private String uretici;
    private int miktar;
    private PojoUrunBirimTipi birim;
    private String raf;

    public PojoUrun(String id, String urunIsmi, String uretici, PojoUrunBirimTipi birim) {
        this.id = id;
        this.urunIsmi = urunIsmi;
        this.uretici = uretici;
        this.miktar = 0;
        this.birim = birim;
        this.raf = "-";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrunIsmi() {
        return urunIsmi;
    }

    public void setUrunIsmi(String urunIsmi) {
        this.urunIsmi = urunIsmi;
    }

    public String getUretici() {
        return uretici;
    }

    public void setUretici(String uretici) {
        this.uretici = uretici;
    }

    public int getMiktar() {
        return miktar;
    }

    public void setMiktar(int miktar) {
        this.miktar = miktar;
    }

    public PojoUrunBirimTipi getBirim() {
        return birim;
    }

    public void setBirim(PojoUrunBirimTipi birim) {
        this.birim = birim;
    }

    public String getRaf() {
        return raf;
    }

    public void setRaf(String raf) {
        this.raf = raf;
    }

}
