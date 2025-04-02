package Ejercicios.e5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
class ManejoExcepcionesTest {

    @Test
    void methodD() {
        ManejoExcepciones ejemplo = new ManejoExcepciones();
        /// LANZA LA EXCEPCIOON XXXEXCEPTION
        assertThrows(XxxException.class, () -> {
            while (true) {
                try {
                    ejemplo.methodD();
                } catch (YyyException e) {
                    continue; // Ignorar YyyException y volver a intentar
                }
                break; // Si no se lanza YyyException, salir del bucle
            }
        }, "methodD debería lanzar XxxException en algún momento");
        /// LANZA EL METODO YYYEXCEPTION
        assertThrows(YyyException.class, () -> {
            while (true) {
                try {
                    ejemplo.methodD();
                } catch (XxxException e) {
                    continue; // Ignorar XxxException y volver a intentar
                }
                break;
            }
        }, "methodD debería lanzar YyyException en algún momento");

        ///NO LANZA NINGUNA EXCEPCION
        assertDoesNotThrow(() -> ejemplo.methodC(),
                "methodC debería manejar todas las excepciones sin lanzarlas fuera");

    }

    /// prueba el metodo C
    @Test
    void methodC() {
        ManejoExcepciones ejemplo = new ManejoExcepciones();

        assertDoesNotThrow(() -> ejemplo.methodC(),
                "methodC debería manejar todas las excepciones sin lanzarlas fuera");
    }

}