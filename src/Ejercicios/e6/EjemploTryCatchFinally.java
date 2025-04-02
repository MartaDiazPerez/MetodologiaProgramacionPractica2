package Ejercicios.e6;

import java.util.Scanner;

public class EjemploTryCatchFinally {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Ingresa un número entero: ");
            int numero1 = scanner.nextInt();

            System.out.print("Ingresa otro número entero para dividir: ");
            int numero2 = scanner.nextInt();

            // Operación que puede generar una excepción
            int resultado = numero1 / numero2;
            System.out.println("El resultado de la división es: " + resultado);

        } catch (ArithmeticException e) { // Excepción por división entre cero
            System.out.println("Error: División por cero no permitida.");
        } catch (Exception e) { // Otras excepciones genéricas
            System.out.println("Ocurrió un error inesperado: " + e.getMessage());
        } finally {
            System.out.println("Bloque finally: limpiando recursos...");
            scanner.close(); // Cierre del Scanner
        }

        System.out.println("El programa continúa después del bloque try-catch-finally.");
    }
}
