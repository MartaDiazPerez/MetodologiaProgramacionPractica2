package Ejercicios.e7;

/**
 * Ejemplo que demuestra cómo manejar un NoClassDefFoundError al intentar instanciar una clase
 * que no está disponible en el classpath o en el entorno de ejecución.
 */
public class NoClassDefFoundErrorExample {

    /**
     * Metodo principal que intenta crear una instancia de MyClass, lo que lanzará un NoClassDefFoundError
     * si la clase MyClass no se encuentra disponible.
     */
    public static void main(String[] args) {
        try {
            // Intentamos crear una instancia de MyClass, lo que lanzará NoClassDefFoundError si no se encuentra
            MyClass myClass = new MyClass();
            myClass.saludar();
        } catch (Error e) {  // Usamos Error para capturar NoClassDefFoundError
            // Capturamos y mostramos el mensaje de error
            System.out.println("Error: No se pudo encontrar la clase: " + e.getMessage());
        }
    }
}
