package com.ex

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class e2 {
    public static void main(String[] args) {
    File archivo = new File("mensaje.txt");
        File archivo2 = new File("mensaje2.txt");

        // 1.
        escribirArchivo(archivo);

        /*// 2.
        String mensaje = "Hello world";
        modificarArchivo(archivo, mensaje);

        // 3.
        leerArchivo(archivo);

        // 4.
        leerArchivoLineas(archivo2);

        // 5.
        contadorLetras(archivo);

        // 6.
        buscarPalabraPorLinea(archivo2);

        // 7.
        convertidor(archivo);*/
    }

    // Metodo 1.
    public static void escribirArchivo(File archivo){
        try{
            FileWriter fw= new FileWriter(archivo);

            fw.write("Hola Mundo");
            
            fw.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
            
        }

    // Metodo 2.
    public static void modificarArchivo(File archivo, String mensaje){
        try{
            FileWriter fw= new FileWriter(archivo);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(mensaje);
            pw.flush();
            pw.close();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    // Metodo 3.
    public static void leerArchivo(File archivo){
        try{
            FileReader fr = new FileReader(archivo);
            int c=fr.read();
            while(c != -1){
                System.out.print((char)c);
                c=fr.read();
            }
        } catch (IOException e){
             e.printStackTrace();
        }
    }

    // Metodo 4.
    public static void leerArchivoLineas(File archivo2){
        try{
            BufferedReader br = new BufferedReader(new FileReader(archivo2));
            
        }
    }
}
