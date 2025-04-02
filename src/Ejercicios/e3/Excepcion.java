package Ejercicios.e3;

/** Clase que demuestra el manejo de excepciones en Java*/
class Excepcion {
    public static void main(String[] args) {
        try {
            methodD(); /** Iniciamos la llamada a methodD, que lanza la excepción*/
        } catch (XxxException e) { /** Capturamos la excepción en el metodo principal*/
            System.out.println("Excepción atrapada en main: " + e.getMessage());
        }
    }

    /** Metodo D que lanza una excepción*/
    static void methodD() throws XxxException {
        System.out.println("Ejecutando methodD...");
        throw new XxxException("Error en methodD"); // Lanza la excepción
    }

    /**Metodo C que declara que puede lanzar XxxException*/
    static void methodC() throws XxxException {
        System.out.println("Ejecutando methodC...");
        methodD(); // Llama a methodD, que lanza la excepción
    }

    /** Metodo B que también declara que puede lanzar XxxException*/
    static void methodB() throws XxxException {
        System.out.println("Ejecutando methodB...");
        methodC(); // Llama a methodC, que a su vez llama a methodD
    }

    /** Metodo A que maneja la excepción con un bloque try-catch*/
    static void methodA() {
        try {
            System.out.println("Ejecutando methodA...");
            methodB(); // Llama a methodB, que propaga la excepción
        } catch (XxxException e) { // Captura la excepción propagada
            System.out.println("Excepción atrapada en methodA: " + e.getMessage());
        }
    }
}
