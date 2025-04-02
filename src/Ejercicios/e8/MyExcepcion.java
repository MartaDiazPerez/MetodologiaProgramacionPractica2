package Ejercicios.e8;

public class MyExcepcion extends Exception {
    /** Clase de excepción personalizada para la gestión de errores específicos en el programa.*/

    /**ATRIBUTOS*/
    private String mensaje; /**Mensaje del error*/
    private int codigoError; /**Codigo asociado al tipo error correspondiente*/


    /**METODOS*/
    /**Metodo que permite una excepción personalizada con un mensaje y un codigo error*/
    public MyExcepcion(String mensaje, int codigoError) {
        super(mensaje); /**Llama al constructor de la clase Exception*/
        this.mensaje = mensaje;
        this.codigoError = codigoError;
    }
    /**Metodo que asigna valores por defecto sin asignar valores*/
    public MyExcepcion() {
        this("Se ha producido un error", 0);
    }
    /**Metodo que devuelve el mensaje asociado a la excepcion*/
    public String getMensaje() {
        return mensaje;
    }
    /**Metodo que devuelve el codigo asociado a la excepcion*/
    public int getCodigoError() {
        return codigoError;
    }
    /**Metodo que devuelve el error al completo con el mensaje y el codigo*/
    @Override
    public String toString() {
        return "Error " + codigoError + ": " + mensaje;
    }
    /**Metodo que compara la excepcion con otro objeto para determinar si son iguales*/
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true; /**Comprueba sin son iguales*/
        if (obj == null || getClass() != obj.getClass())
            return false; /**Comprueba si es nulo o el objeto es de otra clase distinta*/
        MyExcepcion that = (MyExcepcion) obj;
        return codigoError == that.codigoError && mensaje.equals(that.mensaje); /**Los compara para determinar la igualdad*/
    }
}