package Ejercicios.e3;

import static org.junit.jupiter.api.Assertions.*;

class ExcepcionTest {

    /** Prueba para verificar que el metodo main no lanza excepciones inesperadas*/
    @org.junit.jupiter.api.Test
    void main() {
        try{
            Excepcion.main(new String[]{});
        } catch (Exception e){
            fail("El metodo main no deberia lanzar excepcion");
        }
    }

    /**Prueba para asegurarse de que methodD lanza la excepcion XxxException*/
    @org.junit.jupiter.api.Test
    void methodD() {
        assertThrows(XxxException.class, Excepcion::methodD, "methodD debería lanzar excepcion");
    }

    /**Prueba que verifica que methodC propaga correctamente la excepcionXxxException*/
    @org.junit.jupiter.api.Test
    void methodC() {
        assertThrows(XxxException.class, Excepcion::methodC,
                "methodC debería propagar XxxException");
    }

    /**Prueba para comprobar que methodB también propaga la excepción XxxException*/
    @org.junit.jupiter.api.Test
    void methodB() {
        assertThrows(XxxException.class, Excepcion::methodB,
                "methodB debería propagar XxxException");
    }

    /**Prueba para confirmar que methodA maneja correctamente la excepción sin propagarla*/
    @org.junit.jupiter.api.Test
    void methodA() {
        try{
            Excepcion.methodA();
        } catch (Exception e){
            fail("methodA no debería propagar excepciones");
        }
    }

}