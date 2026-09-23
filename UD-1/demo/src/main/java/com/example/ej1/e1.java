package com.example.ej1;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class e1 {

    public static void main(String[] args) {
    
        Scanner sc = new Scanner(System.in);

        // 1. Crear estructura de ficheros y directorios
        System.out.println("Ejercicio 1");
        crearEstructura();

        // 2. Listar directorio raiz "d"
        System.out.println("Ejercicio 2");
        File d = new File("./d");
        listarRaiz(d);

        // 3. Listar cualquier estructura 
        System.out.println("Ejercicio 3");
        System.out.println("Estructura completa de ./d:");
        listarEstructura(d);

        // 4. Mostrar archivos por extension
        System.out.println("Ejercicio 4");
        System.out.print("Nombre del directorio (ej. ./d/d1): ");
        String nombreDir = sc.nextLine();
        System.out.print("Nombre de la extensión (ej. .txt): ");
        String extension = sc.nextLine();
        mostrarPorExtension(new File(nombreDir), extension);

        // 5. Borrar ficheros con extensión .txt
        System.out.println("Ejercicio 5");
        System.out.println("Borrando ficheros .txt del directorio ./d/d1...");
        borrarTxt(new File("./d/d1"));

        sc.close();
    }
}
