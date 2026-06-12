package methods;

import models.Polinomio;

public class Secante {
    public double calcular(
            Polinomio polinomio,
            double x0,
            double x1,
            double tolerancia,
            int maxIteraciones
    ) {
        double xnAnterior = x0;
        double xn = x1;
        double raizAproximada = x1;
        int iteraciones = 0;

        System.out.println("Iter | x(n-1) | xn | x(n+1)");

        // Se repite hasta alcanzar la tolerancia o el maximo de iteraciones.
        while (iteraciones < maxIteraciones) {
            double fxnAnterior = polinomio.evaluar(xnAnterior);
            double fxn = polinomio.evaluar(xn);
            double denominador = fxn - fxnAnterior;

            // Evita dividir entre cero o entre un valor demasiado pequeno.
            if (Math.abs(denominador) < 1e-10) {
                System.out.println("Error: el denominador es 0 o demasiado cercano a 0. No se puede continuar.");
                return Double.NaN;
            }

            double xnSiguiente = xn - ((fxn * (xn - xnAnterior)) / denominador);
            iteraciones++;

            System.out.printf(
                    "%d | %.6f | %.6f | %.6f%n",
                    iteraciones,
                    xnAnterior,
                    xn,
                    xnSiguiente
            );

            raizAproximada = xnSiguiente;

            if (Math.abs(xnSiguiente - xn) < tolerancia) {
                break;
            }

            xnAnterior = xn;
            xn = xnSiguiente;
        }

        System.out.println("Raiz aproximada: " + raizAproximada);
        System.out.println("Iteraciones realizadas: " + iteraciones);

        return raizAproximada;
    }
}
