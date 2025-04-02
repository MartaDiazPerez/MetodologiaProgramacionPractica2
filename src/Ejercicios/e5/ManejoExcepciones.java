package Ejercicios.e5;

public class ManejoExcepciones {
    // Metodo que declara que puede lanzar excepciones
    public void methodD() throws XxxException, YyyException {
        // Simulación de una condicion que lanza XxxException
        if (Math.random() > 0.5) {
            throw new XxxException("Se ha producido XxxException");
        }
        // Simulación de una condicion que lanza YyyException
        else {
            throw new YyyException("Se ha producido YyyException");
        }
    }


    // Metodo que maneja las excepciones con try-catch-finally
    public void methodC() {
        try {
            methodD();
        } catch (XxxException ex) {
            System.out.println("Manejando XxxException: " + ex.getMessage());
        } catch (YyyException ex) {
            System.out.println("Manejando YyyException: " + ex.getMessage());
        } finally {
            System.out.println("Bloque finally: Ejecutando limpieza de recursos.");
        }
    }
}
