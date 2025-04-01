package Ejercicios.e7;

/**
 * Clase que demuestra el manejo de IllegalArgumentException en Java.
 * Intenta calcular el área de un círculo con un radio dado y maneja valores inválidos.
 */
public class IllegalArgumentExample {
    public static void main(String[] args) {
        try {
            System.out.println("Área: " + calcularAreaCirculo(-5));  // Lanza IllegalArgumentException
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Metodo que calcula el área de un círculo.
     *
     * @param radio El radio del círculo.
     * @return El área del círculo si el radio es válido.
     * @throws IllegalArgumentException si el radio es negativo.
     */
    public static double calcularAreaCirculo(double radio) {
        if (radio < 0) {
            throw new IllegalArgumentException("El radio no puede ser negativo.");
        }
        return Math.PI * Math.pow(radio, 2);
    }
}