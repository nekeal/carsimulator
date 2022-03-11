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

    public Boolean rowna(Pozycja cel){
        if(x == cel.x && y == cel.y)
            return true;
        return false;
    }

    public double odleglosc(Pozycja cel){
        // obliczanie odległości euklidesowej pomiędzy dwoma punktami (poprawić typ)
        double odlAktCel= Math.sqrt((Math.pow((cel.getX()-this.getX()),2))+ Math.pow((cel.getY()- this.getY()),2));
        return odlAktCel;

    }
    public void print(){
        System.out.println("x: "+ String.valueOf(x) + " y: " + String.valueOf(y));
    }
}
