public class Pozycja {
    private double x;
    private double y;

    public Pozycja(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public Boolean rowna(Pozycja cel) {
        if (x == cel.x && y == cel.y)
            return true;
        return false;
    }

    public double odleglosc(Pozycja cel) {
        // obliczanie odległości euklidesowej pomiędzy dwoma punktami (poprawić typ)
        double odl_akt_cel;
        odl_akt_cel = Math.sqrt(Math.pow((this.getX() - cel.getX()), 2d) + Math.pow((this.getY() - cel.getY()), 2));
        return odl_akt_cel;
    }

    public void print() {
        System.out.println("x: " + String.valueOf(x) + " y: " + String.valueOf(y));
    }
}
