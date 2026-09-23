package com.example;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        /*File f1=new File("C:\\"); 
        File f2=new File("f.txt");

        File f3=new File("/home/u/Documentos/ADA/datos","numeros.txt");
        File f4=new File("/home/u/Documentos/ADA/datos/numeros.txt");
        File f5=new File(".datos/numeros.txt");  ***** 


        System.out.println(f1.getAbsolutePath());
        System.out.println(f3.exists());
        System.out.println(f4.exists());

        File[] files = d.listFiles();

        System.out.println(File.separator);

        for(:){}
        */

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

    // Metodo 1
    public static void crearEstructura() {
        try {
            // Se crean los directorios con mkdir()
            new File("./d").mkdir();
            new File("./d/d1").mkdir();
            new File("./d/d2").mkdir();
            new File("./d/d3").mkdir();
            new File("./d/d2/d21").mkdir();
            new File("./d/d2/d22").mkdir();
            new File("./d/d3/d31").mkdir();

            // Se crean los ficheros con createNewFile()
            new File("./d/d1/f11.txt").createNewFile();
            new File("./d/d1/f12.txt").createNewFile();
            new File("./d/d2/d21/f21.txt").createNewFile();
            new File("./d/d2/d22/f222.txt").createNewFile(); 
            
            System.out.println("Estructura de archivos creada con exito.");
        } catch (IOException e) {
            System.out.println("Error de E/S al intentar crear los ficheros.");
        }
    }

    //Metodo 2
    public static void listarRaiz(File dir) {
        String[] cont_d = dir.list();
        if (cont_d != null) {
            System.out.println("Contenido de " + dir.getName() + ":");
            for (String s : cont_d) {
                System.out.println(s);
            }
        }
    }

    //Metodo 3
    public static void listarEstructura(File dir){
        if (dir.exists()){
            System.out.println(dir.getName());
            if (dir.isDirectory()){
                String[] contenido = dir.list();
                if(contenido != null){
                    for (String s : contenido){
                        listarEstructura((new File(dir, s)));
                    }
                }
            }
        }
    }

    // Metodo 4
    public static void mostrarPorExtension(File dir, String extension){
        if (dir.isDirectory()){
            String[] contenido = dir.list();
            if (contenido != null){
                System.out.println("Archivos encontrados: ");
                for (String s :contenido){
                    File f = new File(dir, s);
                    if(f.isFile() && s.endWith(extension)){
                        System.out.println(s);
                    }
                }
            }
        } else {
            System.out.println("El directorio proporcionado no existe o no es valido.");
        }
    }

    public static void borrarTxt(File dir){
        if (dir.isDirectory()){
            String[] contenido =dir.list();
            if(contenido !=null){
                for(String s : contenido){
                    File f = new File(dir, s);
                    if (f.isFile() && s.endsWith(".txt")){
                        boolean exito =f.delete();
                        if(exito){
                            System.out.println("Se ha borrado el fichero: " + f.getName());
                        }
                    }
                }
            }
        }
    }
    
}