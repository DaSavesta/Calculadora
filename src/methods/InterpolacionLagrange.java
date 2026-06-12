package methods;

import java.util.List;
import models.Punto;

public class InterpolacionLagrange {
    public double calcular(List<Punto> puntos, double valorX) {
        double resultado = 0;

        System.out.println("Puntos ingresados:");
        for (Punto punto : puntos) {
            System.out.printf("(%.6f, %.6f)%n", punto.getX(), punto.getY());
        }

        System.out.println("Polinomios base de Lagrange:");
        for (int i = 0; i < puntos.size(); i++) {
            mostrarPolinomioBase(puntos, i);
        }

        System.out.println("Polinomio de Lagrange:");
        mostrarPolinomio(puntos);

        // Evalua P(x) = y0*L0(x) + y1*L1(x) + ... + yn*Ln(x).
        for (int i = 0; i < puntos.size(); i++) {
            double yi = puntos.get(i).getY();
            double li = calcularPolinomioBase(puntos, i, valorX);
            resultado += yi * li;
        }

        System.out.println("Valor de x utilizado: " + valorX);
        System.out.println("Resultado de la interpolacion: " + resultado);

        return resultado;
    }

    private double calcularPolinomioBase(List<Punto> puntos, int indice, double valorX) {
        double resultado = 1;
        double xi = puntos.get(indice).getX();

        // Calcula Li(x) multiplicando todos los factores donde j es distinto de i.
        for (int j = 0; j < puntos.size(); j++) {
            if (j != indice) {
                double xj = puntos.get(j).getX();
                resultado *= (valorX - xj) / (xi - xj);
            }
        }

        return resultado;
    }

    private void mostrarPolinomioBase(List<Punto> puntos, int indice) {
        double xi = puntos.get(indice).getX();

        System.out.printf("L%d(x) =%n", indice);

        boolean primerFactor = true;

        for (int j = 0; j < puntos.size(); j++) {
            if (j != indice) {
                double xj = puntos.get(j).getX();

                if (!primerFactor) {
                    System.out.println("*");
                }

                System.out.printf(
                        "((x - %.6f) / (%.6f - %.6f))%n",
                        xj,
                        xi,
                        xj
                );

                primerFactor = false;
            }
        }

        System.out.println();
    }

    private void mostrarPolinomio(List<Punto> puntos) {
        System.out.print("P(x) = ");

        for (int i = 0; i < puntos.size(); i++) {
            double yi = puntos.get(i).getY();

            if (i > 0) {
                System.out.print(" + ");
            }

            System.out.printf("%.6f*L%d(x)", yi, i);
        }

        System.out.println();
    }
}
