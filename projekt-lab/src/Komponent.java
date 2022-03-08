public class Komponent {
    private String nazwa;
    private float waga;
    private float cena;

    public Komponent(String nazwa, float waga, float cena) {
        this.nazwa = nazwa;
        this.waga = waga;
        this.cena = cena;
    }

    public String getNazwa() {
        return this.nazwa;
    }

    public float getCena() {
        return this.cena;
    }

    public float getWaga() {
        return this.waga;
    }
}
