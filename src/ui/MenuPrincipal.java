package ui;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import methods.Biseccion;
import methods.InterpolacionLagrange;
import methods.InterpolacionNewton;
import methods.NewtonRaphson;
import methods.Secante;
import models.Polinomio;
import models.Punto;

public class MenuPrincipal {
    // Punto de entrada que muestra el menu principal y coordina la ejecucion de los metodos numericos.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            System.out.println("========================================");
            System.out.println(" CALCULADORA DE METODOS NUMERICOS");
            System.out.println("========================================");
            System.out.println();

            System.out.println("MENU PRINCIPAL");
            System.out.println("----------------------------------------");
            System.out.println("1. Metodos de Raices");
            System.out.println("2. Interpolacion");
            System.out.println("3. Salir");
            System.out.print("Seleccione una opcion: ");

            int opcion = scanner.nextInt();

            if (opcion == 1) {
                while (true) {
                    System.out.println("========================================");
                    System.out.println("M\u00e9todos de Ra\u00edces");
                    System.out.println("========================================");
                    System.out.println("0. Volver");
                    System.out.println("1. Bisecci\u00f3n");
                    System.out.println("2. Newton-Raphson");
                    System.out.println("3. Secante");
                    System.out.print("Seleccione un metodo: ");
                    int metodo = scanner.nextInt();

                    if (metodo == 0) {
                        break;
                    }

                    if (metodo < 1 || metodo > 3) {
                        System.out.println("Opcion no valida.");
                        continue;
                    }

                    System.out.println("========================================");
                    System.out.println("Tipo de Ecuaci\u00f3n");
                    System.out.println("========================================");
                    System.out.println("0. Volver");
                    System.out.println("1. Cuadr\u00e1tica");
                    System.out.println("2. C\u00fabica");
                    System.out.print("Seleccione una opcion: ");
                    int tipoEcuacion = scanner.nextInt();

                    Polinomio polinomio;

                    if (tipoEcuacion == 0) {
                        continue;
                    } else if (tipoEcuacion == 1) {
                        // En una ecuacion cuadratica el coeficiente A de x^3 es 0.
                        System.out.print("Ingrese el coeficiente B: ");
                        double b = scanner.nextDouble();

                        System.out.print("Ingrese el coeficiente C: ");
                        double c = scanner.nextDouble();

                        System.out.print("Ingrese el coeficiente D: ");
                        double d = scanner.nextDouble();

                        polinomio = new Polinomio(0, b, c, d);
                    } else if (tipoEcuacion == 2) {
                        System.out.print("Ingrese el coeficiente A: ");
                        double a = scanner.nextDouble();

                        System.out.print("Ingrese el coeficiente B: ");
                        double b = scanner.nextDouble();

                        System.out.print("Ingrese el coeficiente C: ");
                        double c = scanner.nextDouble();

                        System.out.print("Ingrese el coeficiente D: ");
                        double d = scanner.nextDouble();

                        polinomio = new Polinomio(a, b, c, d);
                    } else {
                        System.out.println("Opcion no valida.");
                        continue;
                    }

                    System.out.println("Polinomio creado correctamente.");
                    System.out.println("f(2) = " + polinomio.evaluar(2));

                    System.out.println("========================================");
                    System.out.println("Ejecuci\u00f3n del M\u00e9todo");
                    System.out.println("========================================");

                    if (metodo == 1) {
                        System.out.print("Ingrese el limite inferior: ");
                        double limiteInferior = scanner.nextDouble();

                        System.out.print("Ingrese el limite superior: ");
                        double limiteSuperior = scanner.nextDouble();

                        System.out.print("Ingrese la tolerancia: ");
                        double tolerancia = scanner.nextDouble();

                        System.out.print("Ingrese el maximo de iteraciones: ");
                        int maxIteraciones = scanner.nextInt();

                        Biseccion biseccion = new Biseccion();
                        double resultado = biseccion.calcular(
                                polinomio,
                                limiteInferior,
                                limiteSuperior,
                                tolerancia,
                                maxIteraciones
                        );

                        System.out.println("Resultado devuelto: " + resultado);
                    } else if (metodo == 2) {
                        System.out.print("Ingrese el valor inicial x0: ");
                        double x0 = scanner.nextDouble();

                        System.out.print("Ingrese la tolerancia: ");
                        double tolerancia = scanner.nextDouble();

                        System.out.print("Ingrese el maximo de iteraciones: ");
                        int maxIteraciones = scanner.nextInt();

                        NewtonRaphson newtonRaphson = new NewtonRaphson();
                        double resultado = newtonRaphson.calcular(
                                polinomio,
                                x0,
                                tolerancia,
                                maxIteraciones
                        );

                        System.out.println("Resultado devuelto: " + resultado);
                    } else if (metodo == 3) {
                        System.out.print("Ingrese el valor inicial x0: ");
                        double x0 = scanner.nextDouble();

                        System.out.print("Ingrese el valor inicial x1: ");
                        double x1 = scanner.nextDouble();

                        System.out.print("Ingrese la tolerancia: ");
                        double tolerancia = scanner.nextDouble();

                        System.out.print("Ingrese el maximo de iteraciones: ");
                        int maxIteraciones = scanner.nextInt();

                        Secante secante = new Secante();
                        double resultado = secante.calcular(
                                polinomio,
                                x0,
                                x1,
                                tolerancia,
                                maxIteraciones
                        );

                        System.out.println("Resultado devuelto: " + resultado);
                    } else {
                        System.out.println("Opcion no valida.");
                    }

                    break;
                }
            } else if (opcion == 2) {
                System.out.println("========================================");
                System.out.println("Interpolaci\u00f3n");
                System.out.println("========================================");
                System.out.println("0. Volver");
                System.out.println("1. Interpolaci\u00f3n de Newton");
                System.out.println("2. Interpolaci\u00f3n de Lagrange");
                System.out.print("Seleccione un metodo: ");
                int metodoInterpolacion = scanner.nextInt();

                if (metodoInterpolacion == 0) {
                    continue;
                }

                if (metodoInterpolacion == 1) {
                    System.out.println("========================================");
                    System.out.println("Interpolaci\u00f3n de Newton");
                    System.out.println("========================================");

                    System.out.print("Ingrese la cantidad de puntos: ");
                    int cantidadPuntos = scanner.nextInt();

                    List<Punto> puntos = new ArrayList<>();

                    for (int i = 0; i < cantidadPuntos; i++) {
                        System.out.print("Ingrese el valor de x del punto " + (i + 1) + ": ");
                        double x = scanner.nextDouble();

                        System.out.print("Ingrese el valor de y del punto " + (i + 1) + ": ");
                        double y = scanner.nextDouble();

                        puntos.add(new Punto(x, y));
                    }

                    System.out.print("Ingrese el valor de x a interpolar: ");
                    double valorX = scanner.nextDouble();

                    InterpolacionNewton interpolacionNewton = new InterpolacionNewton();
                    double resultado = interpolacionNewton.calcular(puntos, valorX);

                    System.out.println("Resultado devuelto: " + resultado);
                } else if (metodoInterpolacion == 2) {
                    System.out.println("========================================");
                    System.out.println("Interpolaci\u00f3n de Lagrange");
                    System.out.println("========================================");

                    System.out.print("Ingrese la cantidad de puntos: ");
                    int cantidadPuntos = scanner.nextInt();

                    List<Punto> puntos = new ArrayList<>();

                    for (int i = 0; i < cantidadPuntos; i++) {
                        System.out.print("Ingrese el valor de x del punto " + (i + 1) + ": ");
                        double x = scanner.nextDouble();

                        System.out.print("Ingrese el valor de y del punto " + (i + 1) + ": ");
                        double y = scanner.nextDouble();

                        puntos.add(new Punto(x, y));
                    }

                    System.out.print("Ingrese el valor de x a interpolar: ");
                    double valorX = scanner.nextDouble();

                    InterpolacionLagrange interpolacionLagrange = new InterpolacionLagrange();
                    double resultado = interpolacionLagrange.calcular(puntos, valorX);

                    System.out.println("Resultado devuelto: " + resultado);
                } else {
                    System.out.println("Opcion no valida.");
                }
            } else if (opcion == 3) {
                System.out.println("Saliendo del programa.");
                continuar = false;
            } else {
                System.out.println("Opcion no valida.");
            }
        }

        scanner.close();
    }
}
