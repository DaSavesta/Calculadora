package methods;

import models.Polinomio;

public class Biseccion {
    public double calcular(
            Polinomio polinomio,
            double a,
            double b,
            double tolerancia,
            int maxIteraciones
    ) {
        double fa = polinomio.evaluar(a);
        double fb = polinomio.evaluar(b);

        // El metodo de biseccion necesita que la funcion cambie de signo en el intervalo.
        if (fa * fb >= 0) {
            System.out.println("No existe cambio de signo en el intervalo indicado.");
            return Double.NaN;
        }

        double c = a;
        double fc;
        int iteraciones = 0;

        System.out.println("Iter | a | b | c | f(c)");

        // Se repite hasta alcanzar la tolerancia o el maximo de iteraciones.
        while (Math.abs(b - a) >= tolerancia && iteraciones < maxIteraciones) {
            c = (a + b) / 2;
            fc = polinomio.evaluar(c);
            iteraciones++;

            System.out.printf("%d | %.6f | %.6f | %.6f | %.6f%n", iteraciones, a, b, c, fc);

            if (fc == 0) {
                System.out.println("Raiz exacta encontrada.");
                break;
            }

            // Si f(a) y f(c) tienen signos opuestos, la raiz esta entre a y c.
            if (fa * fc < 0) {
                b = c;
                fb = fc;
            } else {
                a = c;
                fa = fc;
            }
        }

        double raizAproximada = (a + b) / 2;

        System.out.println("Raiz aproximada: " + raizAproximada);
        System.out.println("Iteraciones realizadas: " + iteraciones);

        return raizAproximada;
    }
}
