public class SkrzyniaBiegow extends Komponent {
    private int aktualnyBieg;
    private int iloscBiegow;
    private float aktualnePrzelozenie;
    private Sprzeglo sprzeglo;
    private final float przelozenie = 0.5f;

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

    public int zwiekszBieg() {
        if (this.sprzeglo.getStanSprzegla()) {
            if (this.aktualnyBieg < this.iloscBiegow) {
                this.aktualnePrzelozenie = this.aktualnePrzelozenie + przelozenie;
                this.aktualnyBieg = this.aktualnyBieg + 1;
            }
        }
        // zwiekszanie biegow powinno zwiększać przełożenie o 0.5 -done
        return aktualnyBieg;
    }

    public int zmniejszBieg() {
        if (this.sprzeglo.getStanSprzegla()) {
            if (this.aktualnyBieg > 0) {
                this.aktualnePrzelozenie = this.aktualnePrzelozenie - przelozenie;
                this.aktualnyBieg = this.aktualnyBieg - 1;
            }
        }
        // zmniejszenie biegu powinno także zmniejszać przełożenie o 0.3 -done
        return aktualnyBieg;
    }

    public boolean getStanSprzegla() {
        return sprzeglo.getStanSprzegla();
    }

    protected Sprzeglo getSprzeglo() {
        return sprzeglo;
    }

}
