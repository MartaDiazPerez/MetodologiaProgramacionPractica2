package Ejercicios.e1;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class Punto1 {
    public static void main(String[] args) {
        /**Se crea el objeto File para guardar el archivo*/
        File file = new File("test.in");

        /**Comprueba si el archivo no existe*/
        if (!file.exists()) {
            System.out.println("El archivo 'test.in' no se encontró, pero el programa continuará sin errores.");
            return; /**En caso de no existir, el metodo main sale*/
        }

        try {
            /**Se crea el objeto Scanner para leer el archivo*/
            Scanner in = new Scanner(file);
            /**Se encarga de imprimir e imprimir las líneas siempre y cuando haya contenido en el archivo*/
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
            /**Cierra el archivo cuando no hay más líneas para leer del archivo*/
            in.close();

            /**En caso de no encontrar el archivo, se captura el error y sale por pantalla que no se puede abrir*/
        } catch (FileNotFoundException e) {
            System.out.println("Error no esperado al abrir el archivo.");
        }
    }
}

