package models;

public class Matriz {
    private final int dimensiones;
    private final double[][] datos;

    // Constructor para inicializar una matriz cuadrada de nxn
    public Matriz(int dimensiones) {
        this.dimensiones = dimensiones;
        this.datos = new double[dimensiones][dimensiones];
    }

    // Constructor alternativo si ya tenés los datos listos
    public Matriz(double[][] datos) {
        this.dimensiones = datos.length;
        this.datos = datos;
    }

    public int getDimensiones() {
        return this.dimensiones;
    }

    public double getCelda(int fila, int columna) {
        return this.datos[fila][columna];
    }

    public void setCelda(int fila, int columna, double valor) {
        this.datos[fila][columna] = valor;
    }

    public double[][] getDatos() {
        return this.datos;
    }

    /**
     * Obtiene la submatriz eliminando una fila y columna específica.
     * Es crucial para calcular los menores y cofactores.
     */
    public Matriz obtenerSubMatriz(int filaAEliminar, int columnaAEliminar) {
        Matriz subMatriz = new Matriz(this.dimensiones - 1);
        int r = 0;
        for (int i = 0; i < this.dimensiones; i++) {
            if (i == filaAEliminar) continue;
            int c = 0;
            for (int j = 0; j < this.dimensiones; j++) {
                if (j == columnaAEliminar) continue;
                subMatriz.setCelda(r, c, this.datos[i][j]);
                c++;
            }
            r++;
        }
        return subMatriz;
    }

    // Método auxiliar para imprimir la matriz de forma elegante en la terminal
    public void mostrar() {
        for (int i = 0; i < dimensiones; i++) {
            System.out.print("[ ");
            for (int j = 0; j < dimensiones; j++) {
                System.out.printf("%8.4f ", this.datos[i][j]);
            }
            System.out.println("]");
        }
    }
}