import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Kontroler {
    public static void main(String[] args) throws InterruptedException {

        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 5, 459.90F);
        Sprzeglo sprzeglo2 = new Sprzeglo("sprzeglo2", 6, 619);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 80, 5900, 5, sprzeglo1);
        SkrzyniaBiegow skrzynia2 = new SkrzyniaBiegow("skrzynia2", 80, 6800, 5, sprzeglo2);
        Silnik silnik1 = new Silnik("silnik1", 210, 9500, 8000);
        Silnik silnik2 = new Silnik("silnik2", 315, 15000, 10000);
        Pozycja pozycja1 = new Pozycja(0, 0);
        Pozycja pozycja2 = new Pozycja(0, 0);
        Samochod samochod1 = new Samochod("abc 12345", "A4",210, skrzynia1, pozycja1, silnik1);
        Samochod samochod2 = new Samochod("xyz 12345", "X5",250, skrzynia2, pozycja2, silnik2);
        samochod1.wlacz();
        samochod2.wlacz();
        skrzynia1.zwiekszBieg();
        skrzynia2.zwiekszBieg();
        samochod1.setCel(new Pozycja(100, 100));
        samochod2.setCel(new Pozycja(100, 100));
        if(args.length == 0) {
            samochod1.start();
            samochod2.start();
        }
        else{
            System.out.println("Program finished successfully");
            System.exit(5);
        }
    }

    public static Samochod getPredefinedSamochod(int model){
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo1", 5, 459.90F);
        Sprzeglo sprzeglo2 = new Sprzeglo("sprzeglo2", 6, 619);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 80, 5900, 5, sprzeglo1);
        SkrzyniaBiegow skrzynia2 = new SkrzyniaBiegow("skrzynia2", 80, 6800, 5, sprzeglo2);
        Silnik silnik1 = new Silnik("silnik1", 210, 9500, 8000);
        Silnik silnik2 = new Silnik("silnik2", 315, 15000, 10000);
        Pozycja pozycja1 = new Pozycja(1.5, 1.5);
        Pozycja pozycja2 = new Pozycja(0, 0);
        Samochod samochod1 = new Samochod("abc 12345", "A4",210, skrzynia1, pozycja1, silnik1);
        Samochod samochod2 = new Samochod("xyz 12345", "X5",250, skrzynia2, pozycja2, silnik2);
        if(model==1)
            return samochod1;
        else
            return samochod2;
    }
    public static Samochod getSamochod(String nrRejest, String model, float vmax){
        Sprzeglo sprzeglo1 = new Sprzeglo("sprzeglo", 5, 459.90F);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("skrzynia1", 80, 5900, 5, sprzeglo1);
        Silnik silnik1 = new Silnik("silnik1", 210, 9500, 8000);
        Pozycja pozycja1 = new Pozycja(0, 0);
        Samochod samochod1 = new Samochod(nrRejest, model,vmax, skrzynia1, pozycja1, silnik1);
        samochod1.start();
        return samochod1;
    }
}
