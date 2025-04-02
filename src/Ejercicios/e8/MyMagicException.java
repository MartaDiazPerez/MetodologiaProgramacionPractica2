package Ejercicios.e8;


public class MyMagicException extends MyExcepcion {
    /** Clase de excepción que extiende MiExcepcion */
    /**ATRIBUTOS*/
    private String severidad;

    /**METODOS*/
    /**Metodo que designa el mensaje, codigo y rigor del error */
    public MyMagicException(String mensaje, int codigoError, String severidad) {
        super(mensaje, codigoError); /**Llama al contructor de la clase padre (MyException)*/
        this.severidad = severidad;
    }

    /**Metodo que asigna valores por defecto y posteriormente llama con valores definidos*/
    public MyMagicException() {
        this("Error mágico", 0, "medio");
    }
    /**Devuelve el rigor del error*/
    public String getSeveridad() {
        return severidad;
    }
    /**Metodo que escribe el error con su codigo, el nivel de rigor y el mensaje en forma de cadena
     * de texto*/
    @Override
    public String toString() {
        return "Error " + getCodigoError() + " (" + severidad + "): " + getMensaje();
    }
}
