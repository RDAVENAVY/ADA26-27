package com.example.ej2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class e2 {
    public static void main(String[] args) {
        File archivo = new File("mensaje.txt");
        File archivo2 = new File("mensaje2.txt");

        // 1.
        escribirArchivo(archivo);

        // 2.
        String mensaje = "Hello world";
        modificarArchivo(archivo, mensaje);

        // 3.
        leerArchivo(archivo);

        // 4.
        leerArchivoLineas(archivo2);

        // 5.
        contadorPalabras(archivo);

        // 6.
        buscarPalabraPorLinea(archivo2);

        // 7.
        convertidor(archivo);
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

            fr.close();
        } catch (IOException e){
             e.printStackTrace();
        }
    }

    // Metodo 4.
    public static void leerArchivoLineas(File archivo2){
        try{
           BufferedReader br = new BufferedReader(new FileReader(archivo2));
            String linea = br.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = br.readLine();
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
            
        }

    }

    // Metodo 5
    public static void contadorPalabras(File archivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String linea;
            int totalPalabras = 0;

            while ((linea = br.readLine()) != null) {
                String[] palabras = linea.split(" ");
                
                for (String palabra : palabras) {
                    if (!palabra.isEmpty()) {
                        totalPalabras++;
                    }
                }
            }

            br.close();

            System.out.println("El numero total de palabras es: " + totalPalabras);
        
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo 6
    public static void buscarPalabraPorLinea(File archivo) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduce la palabra clave a buscar: ");
        String palabraClave = sc.nextLine();

        File resultado = new File("resultado.txt");
        int totalLineas = 0;
        int coincidencias = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            PrintWriter pw = new PrintWriter(new FileWriter(resultado));

            String linea;
            while ((linea = br.readLine()) != null) {
                totalLineas++;
                if (linea.contains(palabraClave)) {
                    pw.println("Línea " + totalLineas + ": " + linea);
                    coincidencias++;
                }
            }

            br.close();
            pw.flush();
            pw.close();

            System.out.println("Total de lineas procesadas: " + totalLineas);
            System.out.println("Coincidencias encontradas: " + coincidencias);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Metodo 7
    public static void convertidor(File archivo) {
        File destino = new File("convertido.txt");
        try {
            FileReader fr = new FileReader(archivo);
            FileWriter fw = new FileWriter(destino);

            int c = fr.read();
            while (c != -1) {
                char caracter = (char) c;
                // Si no es un espacio en blanco, lo pasa a mayuscula y lo escribe
                if (caracter != ' ') {
                    fw.write(Character.toUpperCase(caracter));
                }
                c = fr.read();
            }

            fr.close();
            fw.close();
            System.out.println("Fichero generado correctamente en 'convertido.txt'.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }    
}
