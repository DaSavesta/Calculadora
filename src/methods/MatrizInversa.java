package methods;

import models.Matriz;

public class MatrizInversa {

    /**
     * Calcula la inversa de una matriz nxn usando el método de la adjunta.
     * Devuelve null si la matriz no es invertible (determinante cero).
     */
    public Matriz calcular(Matriz matriz) {
        int n = matriz.getDimensiones();
        
        // 1. Calcular el determinante de la matriz original
        double det = calcularDeterminante(matriz);
        System.out.printf("\nDeterminante de la matriz: %.4f\n", det);
        
        if (Math.abs(det) < 1e-9) {
            System.out.println("Error: El determinante es cero o extremadamente cercano a cero. La matriz no tiene inversa.");
            return null;
        }

        // 2. Construir la matriz de cofactores
        Matriz cofactores = new Matriz(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                Matriz subMatriz = matriz.obtenerSubMatriz(i, j);
                // El signo depende de (i + j)
                double signo = ((i + j) % 2 == 0) ? 1.0 : -1.0;
                double cofactor = signo * calcularDeterminante(subMatriz);
                cofactores.setCelda(i, j, cofactor);
            }
        }

        // 3. Transponer la matriz de cofactores para obtener la Adjunta y multiplicar por 1/det
        Matriz inversa = new Matriz(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // Notá el intercambio de indices (j, i) para transponer directamente
                double valorAdjunta = cofactores.getCelda(j, i);
                inversa.setCelda(i, j, valorAdjunta / det);
            }
        }

        return inversa;
    }

    /**
     * Calcula el determinante de forma recursiva (Expansión por cofactores).
     */
    public double calcularDeterminante(Matriz matriz) {
        int n = matriz.getDimensiones();

        // Casos base
        if (n == 1) {
            return matriz.getCelda(0, 0);
        }
        if (n == 2) {
            return (matriz.getCelda(0, 0) * matriz.getCelda(1, 1)) - 
                   (matriz.getCelda(0, 1) * matriz.getCelda(1, 0));
        }

        double determinante = 0.0;
        // Expandimos siempre por la primera fila (fila 0)
        for (int j = 0; j < n; j++) {
            Matriz subMatriz = matriz.obtenerSubMatriz(0, j);
            double signo = (j % 2 == 0) ? 1.0 : -1.0;
            determinante += signo * matriz.getCelda(0, j) * calcularDeterminante(subMatriz);
        }

        return determinante;
    }
}