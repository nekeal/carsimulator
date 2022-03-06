public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private Sprzeglo sprzeglo;
    public int getAktBieg() {
        return aktualnyBieg;
    }

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = 0F;
        this.sprzeglo = sprzeglo;
        this.aktualnyBieg = 0;
    }

    public float getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }

    public int zwiekszBieg(){
        if (getStanSprzegla()){
            if (aktualnyBieg < iloscBiegow){
                aktualnePrzelozenie += 0.5;
                aktualnyBieg += 1;
            }
        }
        return aktualnyBieg;
    }
    public int zmniejszBieg(){
        if (getStanSprzegla()){
            if (aktualnyBieg > 0){
                aktualnePrzelozenie -= 0.5;
                aktualnyBieg -= 1;
            }
        }
        return aktualnyBieg;
    }
    public boolean getStanSprzegla(){
        return sprzeglo.getStanSprzegla();
    }
    protected Sprzeglo getSprzeglo(){
        return sprzeglo;
    }
}
