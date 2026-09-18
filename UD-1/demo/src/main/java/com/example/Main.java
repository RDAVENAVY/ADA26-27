package com.example;

import java.io.File;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
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

        // 1.

        File d=new File("./d");
        File d1=new File("./d/d1");
        File d2=new File("./d/d2");
        File d3=new File("./d/d3");
        File f11=new File("./d/d1/f11.txt");
        File f12=new File("./d/d1/f12.txt");
        File d21=new File("./d/d2/d21");
        File f21=new File("./d/d2/d21/f21.txt");
        File d22=new File("./d/d2/d22");
        File f222=new File("./d/d2/d22/f222");
        File d31=new File("./d/d3/d31");

        // 2.

        String[] cont_d=d.list();
        System.out.println("Contenido de d: ");
        for(String s:cont_d){
            System.out.println(s);
        }

        // 3. 



        // 4.

        System.out.println("Nombre de archivo: ");
        String nombre=sc.nextLine();
        System.out.println("Nombre de la extension: ");
        String extension=sc.nextLine();

        System.out.println("Nombre de d: " + d.getName());

        // 5.

        

        
    }
}