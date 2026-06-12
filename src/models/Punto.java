package models;

public class Punto {
    // Coordenada en el eje X.
    private double x;

    // Coordenada en el eje Y.
    private double y;

    // Constructor para almacenar un punto cartesiano.
    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
