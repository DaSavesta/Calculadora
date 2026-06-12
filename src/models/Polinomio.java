package models;

public class Polinomio {
    // Coeficientes del polinomio: f(x) = Ax^3 + Bx^2 + Cx + D.
    // Para una ecuacion cuadratica, A debe ser 0.
    private double a;
    private double b;
    private double c;
    private double d;

    // Constructor para crear polinomios cuadraticos o cubicos.
    public Polinomio(double a, double b, double c, double d) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }

    public double getC() {
        return c;
    }

    public void setC(double c) {
        this.c = c;
    }

    public double getD() {
        return d;
    }

    public void setD(double d) {
        this.d = d;
    }

    // Evalua f(x) = Ax^3 + Bx^2 + Cx + D en el valor indicado.
    public double evaluar(double x) {
        return a*x*x*x + b*x*x + c*x + d;
    }

    // Evalua la derivada f'(x) = 3Ax^2 + 2Bx + C en el valor indicado.
    public double evaluarDerivada(double x) {
        return 3*a*x*x + 2*b*x + c;
    }
}
