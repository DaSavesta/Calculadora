package methods;

import java.util.List;
import models.Punto;

public class InterpolacionNewton {
    public double calcular(List<Punto> puntos, double valorX) {
        int n = puntos.size();
        double[][] diferencias = new double[n][n];

        System.out.println("Puntos ingresados:");
        for (Punto punto : puntos) {
            System.out.printf("(%.6f, %.6f)%n", punto.getX(), punto.getY());
        }

        // La primera columna de la tabla contiene los valores de y.
        for (int i = 0; i < n; i++) {
            diferencias[i][0] = puntos.get(i).getY();
        }

        // Calcula las diferencias divididas de Newton.
        for (int j = 1; j < n; j++) {
            for (int i = 0; i < n - j; i++) {
                double numerador = diferencias[i + 1][j - 1] - diferencias[i][j - 1];
                double denominador = puntos.get(i + j).getX() - puntos.get(i).getX();
                diferencias[i][j] = numerador / denominador;
            }
        }

        System.out.println("Tabla de diferencias divididas:");
        System.out.println();

        System.out.printf(
                "%-10s %-10s %-10s %-10s %-10s%n",
                "x",
                "f[x]",
                "1ra Dif",
                "2da Dif",
                "3ra Dif"
        );

        System.out.println("------------------------------------------------------------");

        for (int i = 0; i < n; i++) {

            System.out.printf("%-10.4f ", puntos.get(i).getX());

            for (int j = 0; j < n - i; j++) {
                System.out.printf("%-10.4f ", diferencias[i][j]);
            }

            System.out.println();
        }

        System.out.println("Polinomio de Newton:");
        mostrarPolinomio(puntos, diferencias);

        double resultado = diferencias[0][0];
        double producto = 1;

        // Evalua P(x) usando los coeficientes de la primera fila.
        for (int i = 1; i < n; i++) {
            producto *= valorX - puntos.get(i - 1).getX();
            resultado += diferencias[0][i] * producto;
        }

        System.out.println("Valor de x utilizado: " + valorX);
        System.out.println("Resultado de la interpolacion: " + resultado);

        return resultado;
    }

    private void mostrarPolinomio(List<Punto> puntos, double[][] diferencias) {
        System.out.println("P(x) =");
        System.out.printf("%.6f%n", diferencias[0][0]);

        for (int i = 1; i < puntos.size(); i++) {
            if (Math.abs(diferencias[0][i]) < 1e-10) {
                continue;
            }
            System.out.printf("+ %.6f", diferencias[0][i]);

            for (int j = 0; j < i; j++) {
                System.out.printf("(x - %.6f)", puntos.get(j).getX());
            }

            System.out.println();
        }
    }
}
