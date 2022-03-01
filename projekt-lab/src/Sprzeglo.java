public class Sprzeglo extends Komponent {
    private Boolean stanSprzegla;

    public Sprzeglo(String nazwa, float waga, float cena) {
        super(nazwa, waga, cena);
        this.stanSprzegla = false;
    }

    public void wcisnij(){
        stanSprzegla = true;
    }

    public void zwolnij(){
        stanSprzegla = false;
    }

    public Boolean getStanSprzegla() {
        return stanSprzegla;
    }
}
