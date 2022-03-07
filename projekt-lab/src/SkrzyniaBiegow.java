public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private float zmiana_przelozenia;
    private Sprzeglo sprzeglo;
    public int getAktBieg() {
        return aktualnyBieg;
    }

    public SkrzyniaBiegow(String nazwa, float waga, float cena, int iloscBiegow, Sprzeglo sprzeglo) {
        super(nazwa, waga, cena);
        this.iloscBiegow = iloscBiegow;
        this.aktualnePrzelozenie = 0F;
        this.zmiana_przelozenia = 0.5F;
        this.sprzeglo = sprzeglo;
        this.aktualnyBieg = 0;
    }

    public float getAktPrzelozenie() {
        return aktualnePrzelozenie;
    }

    public void zwiekszBieg(){
        if (getStanSprzegla()){
            if (aktualnyBieg < iloscBiegow){
                aktualnePrzelozenie += this.zmiana_przelozenia;
                aktualnyBieg += 1;
            }
        }
    }
    public void zmniejszBieg(){
        if (getStanSprzegla()){
            if (aktualnyBieg > 0){
                aktualnePrzelozenie -= this.zmiana_przelozenia;
                aktualnyBieg -= 1;
            }
        }
    }
    public boolean getStanSprzegla(){
        return sprzeglo.getStanSprzegla();
    }

    protected Sprzeglo getSprzeglo(){
        return sprzeglo;
    }
}
