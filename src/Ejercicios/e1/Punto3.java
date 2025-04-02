package Ejercicios.e1;

import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
public class Punto3 {
    public static void main(String[] args) {
        /**Se crea el objeto File para guardar el archivo*/
        File file = new File("test.in");

        /**Comprueba si el archivo no existe*/
        if (!file.exists()) {
            System.out.println("El archivo 'test.in' no existe. Se creará un archivo de prueba con contenido.");
            createTestFile(file); /**Llama al metodo para crear un archivo de prueba*/
        }

        /**Se declara el objeto Scanner para leer el archivo*/
        Scanner in = null;

        try {
            /**Se abre el archivo a leer por el scanner*/
            in = new Scanner(file);
            /**Llama al metodo para procesar el archivo*/
            processFile(in); /**Al no encontrarse el archivo se captura la excepción*/
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se pudo abrir el archivo.");
        } finally {
            /**Se comprueba el buen uso del scanner*/
            if (in != null) {
                in.close(); /** Se cierra el scanner para liberar los recursos*/
            }
        }
    }
    /**Metodo que se encarga de procesar el archivo e imprimir su contenido línea por línea*/
    public static void processFile(Scanner in) {
        System.out.println("Contenido del archivo:");
        while (in.hasNextLine()) {
            System.out.println(in.nextLine()); /**Siempre que hay líneas sigue imprimiendo
             dichas líneas*/
        }
    }

    /**Metodo que se encarga de crear un archivo de prueba de con contenido en caso de no existir*/
    public static void createTestFile(File file) {
        try {
            /**Se crea el objeto File para escribir en el archivo*/
            FileWriter writer = new FileWriter(file);
            /**Se escribe el contenido en el archivo de prueba*/
            writer.write("Este es un archivo de prueba.\nSegunda línea de prueba.\nTercera línea de prueba.");
            writer.close(); /**Se cierra el archivo para guardar los cambios*/
            System.out.println("Archivo de prueba creado y llenado con contenido: " + file.getName()); /**Se imprime el contenido*/
        } catch (IOException e) { /** Captura la excepción si hay un error de entrada/salida*/
            System.out.println("No se pudo crear o escribir en el archivo de prueba.");
        }
    }
}

