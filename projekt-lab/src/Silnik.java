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

    public void zwiekszObroty(){
        if (obroty < max_obroty){
            obroty += 100;
        }
    }

    public void zmniejszObroty(){

        if (obroty > 0){
            obroty -= 100;
        }
    }

    public int getObroty() {
        return obroty;
    }

    public int getMax_obroty() {
        return max_obroty;
    }
}
