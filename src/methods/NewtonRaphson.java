package methods;

import models.Polinomio;

public class NewtonRaphson {
    public double calcular(
            Polinomio polinomio,
            double x0,
            double tolerancia,
            int maxIteraciones
    ) {
        double xn = x0;
        double raizAproximada = x0;
        int iteraciones = 0;

        System.out.println("Iter | xn | f(xn) | f'(xn) | xn+1");

        // Se repite hasta alcanzar la tolerancia o el maximo de iteraciones.
        while (iteraciones < maxIteraciones) {
            double fxn = polinomio.evaluar(xn);
            double derivada = polinomio.evaluarDerivada(xn);

            // No se puede aplicar Newton-Raphson si la derivada es cero.
            if (Math.abs(derivada) < 1e-10)
            {
                System.out.println("Error: la derivada es 0. No se puede continuar.");
                return Double.NaN;
            }

            double xnSiguiente = xn - (fxn / derivada);
            iteraciones++;

            System.out.printf(
                    "%d | %.6f | %.6f | %.6f | %.6f%n",
                    iteraciones,
                    xn,
                    fxn,
                    derivada,
                    xnSiguiente
            );

            raizAproximada = xnSiguiente;

            if (Math.abs(xnSiguiente - xn) < tolerancia) {
                break;
            }

            xn = xnSiguiente;
        }

        System.out.println("Raiz aproximada: " + raizAproximada);
        System.out.println("Iteraciones realizadas: " + iteraciones);

        return raizAproximada;
    }
}
