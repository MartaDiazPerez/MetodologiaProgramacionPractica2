package Ejercicios.e7;

public class IllegalStateExample {
    private boolean encendida = false;  // Estado de la lámpara (encendida o apagada)

    // Metodo para encender la lámpara
    public void encender() {
        if (encendida) {
            throw new IllegalStateException("La lámpara ya está encendida.");
        }
        encendida = true;
        System.out.println("La lámpara está encendida.");
    }

    // Metodo para apagar la lámpara
    public void apagar() {
        if (!encendida) {
            throw new IllegalStateException("La lámpara ya está apagada.");
        }
        encendida = false;
        System.out.println("La lámpara está apagada.");
    }

    public static void main(String[] args) {
        try {
            IllegalStateExample lámpara = new IllegalStateExample();
            lámpara.encender();  // La lámpara se enciende correctamente
            lámpara.encender();  // Intentamos encenderla de nuevo, lo cual lanza IllegalStateException
        } catch (IllegalStateException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}