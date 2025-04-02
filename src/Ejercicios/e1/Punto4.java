package Ejercicios.e1;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
public class Punto4 {
    public static void main(String[] args) {
        File file = new File("test.in");

        if (!file.exists()) {
            System.out.println("El archivo 'test.in' no existe. Se creará un archivo de prueba con contenido.");
            createTestFile(file);
        }

        processFile(file);
    }

    public static void processFile(File file) {
        Scanner in = null;
        try {
            // Lógica principal: abrir y procesar el archivo
            in = new Scanner(file);
            System.out.println("Contenido del archivo:");
            while (in.hasNextLine()) {
                System.out.println(in.nextLine());
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Error: No se pudo abrir el archivo.");
        } finally {
            if (in != null) {
                in.close(); // Cerrar el archivo si fue abierto
            }
        }
    }

    public static void createTestFile(File file) {
        try {
            FileWriter writer = new FileWriter(file);
            writer.write("Este es un archivo de prueba.\nSegunda línea de prueba.\nTercera línea de prueba.");
            writer.close();
            System.out.println("Archivo de prueba creado y llenado con contenido: " + file.getName());
        } catch (IOException e) {
            System.out.println("No se pudo crear o escribir en el archivo de prueba.");
        }
    }
}
