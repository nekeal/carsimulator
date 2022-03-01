public class Silnik extends Komponent {
    private int max_obroty;
    private int obroty;

    public Silnik(String nazwa, float waga, float cena, int max_obroty) {
        super(nazwa, waga, cena);
        this.max_obroty = max_obroty;
    }

    public void uruchom(){
        obroty = max_obroty/4;
    }

    public void zatrzymaj(){
        obroty = 0;
    }

    public int zwiekszObroty(){
        obroty+=100;
        return obroty;
    }

    public int zmniejszObroty(){
        obroty-=100;
        return obroty;
    }

    public int getObroty() {
        return obroty;
    }
}
