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
        if(x == cel.getX() && x == cel.getY())
            return 0;
        return Math.sqrt(Math.pow(x - cel.x, 2)) + Math.sqrt(Math.pow(y - cel.y, 2));
    }
    public void print(){
        System.out.println("x: "+ String.valueOf(x) + " y: " + String.valueOf(y));
    }
}
