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

    public Samochod(String nrRejest, String model, float maxPredkosc, SkrzyniaBiegow skrzynia, Pozycja aktualnaPozycja,
            Silnik silnik) {
        this.nrRejest = nrRejest;
        this.model = model;
        this.maxPredkosc = maxPredkosc;
        this.skrzynia = skrzynia;
        this.aktualnaPozycja = aktualnaPozycja;
        this.silnik = silnik;
        this.stanWlaczenia = false;
        // this.startowaPozycja = aktualnaPozycja;
        // this.cel = aktualnaPozycja;
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

    public double getAktObroty() {
        return silnik.getObroty();
    }

    public int nastepnyBieg() {
        return skrzynia.zwiekszBieg();
    }

    public int poprzedniBieg() {
        return skrzynia.zmniejszBieg();
    }

    public void wcisnijSprzeglo() {
        skrzynia.getSprzeglo().wcisnij();
    }

    public void zwolnijSprzeglo() {
        skrzynia.getSprzeglo().zwolnij();
    }

    public int getAktBieg() {
        return skrzynia.getAktBieg();
    }

    public float getAktPrzelozenie() {
        return skrzynia.getAktPrzelozenie();
    }

    public int dodajGazu() {
        return silnik.zwiekszObroty();
    }

    public boolean getStanSprzegla() {
        return skrzynia.getStanSprzegla();
    }

    public void wylacz() {
        stanWlaczenia = false;
        silnik.zatrzymaj();
    }

    public void setCel(Pozycja cel_0) {
        this.startowaPozycja = new Pozycja(this.aktualnaPozycja.getX(), this.aktualnaPozycja.getY());
        this.cel = new Pozycja(cel_0.getX(), cel_0.getY());
        // ustawienie startowaPozycja na aktualną pozycje-done
        // ustawienie celu-done
    }

    public Pozycja getCel() {
        return cel;
    }

    public void jedzDo(Pozycja cel) {
        long dt = 200;
        double direction = Math.atan2((cel.getY() - getAktPozycja().getY()), (cel.getX() - getAktPozycja().getX()));
        double poprzedniaOdl;
        double S;
        S = getAktPredkosc() * dt / 1000;
        poprzedniaOdl = aktualnaPozycja.odleglosc(cel);

        aktualnaPozycja.setX(aktualnaPozycja.getX() + S * Math.cos(direction));
        aktualnaPozycja.setY(aktualnaPozycja.getY() + S * Math.sin(direction));
        // jeżeli obecna odległość od celu jest większa od poprzedniej - ustawić -done
        // aktualną pozycję na pozycję celu. -done
        if (this.aktualnaPozycja.odleglosc(cel) > poprzedniaOdl) {
            this.aktualnaPozycja.setX(cel.getX());
            this.aktualnaPozycja.setY(cel.getY());
        }

        aktualnaPozycja.print();
        System.out.println(aktualnaPozycja.odleglosc(cel) + " " + getName());
    }

    public float getWaga() {
        return 100;
    }

    public Pozycja getAktPozycja() {
        return aktualnaPozycja;
    }

    public Pozycja getStartowaPozycja() {
        return startowaPozycja;
    }

    public double getAktPredkosc() {
        if (this.getStanSprzegla() || !this.getStanWlaczenia() || this.getAktBieg() == 0) {
            return 0d;
        } else {
            return this.getAktObroty() * this.getAktPrzelozenie() * 0.008;
        }
        // zwrocić 0, jeżeli jest wciśnięte sprzęgło, silnik jest wyłączony lub jest
        // -done
        // wrzucony luz (aktualny bieg jest 0)-done
        // obliczać prędkość jako obroty * przełożenie * 0.008-done
    }

    public void run() {
        System.out.println("wystartowal");
        long dt = 200;
        double poprzednia = 9999999999.9;
        Pozycja poprzedniCel = null;
        double S;
        while (true) {
            try {
                Thread.sleep(dt);
            } catch (InterruptedException e) {
            }
            if (cel == null)
                continue;
            jedzDo(cel);
        }
    }

    @Override
    public String toString() {
        return model;
    }
}
