import java.lang.Thread;

public class Samochod extends Thread {
    private Boolean stanWlaczenia;
    private String nrRejest;
    private String model;
    private float maxPredkosc;
    private SkrzyniaBiegow skrzynia;
    private Pozycja aktualnaPozycja;
    private Silnik silnik;
    private Pozycja cel;
    private Pozycja startowaPozycja;

    public Samochod(String nrRejest, String model, float maxPredkosc, SkrzyniaBiegow skrzynia, Pozycja aktualnaPozycja, Silnik silnik) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.maxPredkosc = maxPredkosc;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = aktualnaPozycja;
        this.silnik = silnik;
        this.stanWlaczenia = false;
        this.cel = new Pozycja(aktualnaPozycja.getX(), aktualnaPozycja.getY());
        this.startowaPozycja = new Pozycja(aktualnaPozycja.getX(), aktualnaPozycja.getY());
    }

    public void wlacz() {
        stanWlaczenia = true;
        silnik.uruchom();
    }

    public Boolean getStanWlaczenia() {
        return stanWlaczenia;
    }

    public String getNrRejest() {
        return nrRejest;
    }

    public String getModel() {
        return model;
    }

    public float getMaxPredkosc() {
        return maxPredkosc;
    }

    public double getAktObroty(){
        return silnik.getObroty();
    }

    public int getMaxObroty() {
        return silnik.getMax_obroty();
    }

    public void nastepnyBieg(){
        skrzynia.zwiekszBieg();
    }

    public void poprzedniBieg(){
        skrzynia.zmniejszBieg();
    }

    public void wcisnijSprzeglo(){
        skrzynia.getSprzeglo().wcisnij();
    }

    public void zwolnijSprzeglo(){
        skrzynia.getSprzeglo().zwolnij();
    }

    public int getAktBieg(){
        return skrzynia.getAktBieg();
    }

    public float getAktPrzelozenie(){
        return skrzynia.getAktPrzelozenie();
    }

    public void dodajGazu(){
        if (stanWlaczenia) {
            silnik.zwiekszObroty();
        }
    }

    public void hamuj(){
        if (stanWlaczenia) {
            silnik.zmniejszObroty();
        }
        if (getAktObroty() ==0) {
            wylacz();
        }
    }

    public boolean getStanSprzegla(){
        return skrzynia.getStanSprzegla();
    }

    public void wylacz() {
        stanWlaczenia = false;
        silnik.zatrzymaj();
    }

    public void setCel(Pozycja cel) {
        startowaPozycja.setX(aktualnaPozycja.getX());
        startowaPozycja.setY(aktualnaPozycja.getY());

        this.cel.setX(cel.getX());
        this.cel.setY(cel.getY());
    }
    public Pozycja getCel(){
        return cel;
    }

    public void jedzDo(Pozycja cel) {
        long dt = 200;
        double direction = Math.atan2((cel.getY() - getAktPozycja().getY()), ( cel.getX() - getAktPozycja().getX()));
        double poprzedniaOdl = aktualnaPozycja.odleglosc(cel);
        double S;
        S = getAktPredkosc() * dt / 1000;
        aktualnaPozycja.setX(aktualnaPozycja.getX() + S * Math.cos(direction));
        aktualnaPozycja.setY(aktualnaPozycja.getY() + S * Math.sin(direction));

        if (aktualnaPozycja.odleglosc(cel) > poprzedniaOdl){
            aktualnaPozycja.setX(cel.getX());
            aktualnaPozycja.setY(cel.getY());
        }

        if (aktualnaPozycja.rowna(cel)) {
            wcisnijSprzeglo();
        }

        aktualnaPozycja.print();
        System.out.println(aktualnaPozycja.odleglosc(cel) + " " + getName());
    }

    public float getWaga() {
        return silnik.getWaga() + skrzynia.getWaga() + skrzynia.getSprzeglo().getWaga();
    }

    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }

    public Pozycja getStartowaPozycja(){return startowaPozycja;}

    public double getAktPredkosc() {
        double predkosc = 0;
        if (stanWlaczenia){
            if (!getStanSprzegla()){
                if (getAktBieg() != 0){
                    predkosc = getAktObroty() * getAktPrzelozenie() * 0.008;
                }
            }
        }
        else {
            predkosc = 0;
        }
        return predkosc;
    }

    public void run() {
        System.out.println("wystartowal");
        long dt = 200;
        while (true) {
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {}
            if(cel==null)
                continue;
            jedzDo(cel);
        }
    }

    @Override
    public String toString() {
        return model;
    }
}
