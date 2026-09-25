package main.java.com.example.ej3;

import java.io.*;
import java.util.Scanner;

public class e3 {
    public static void main(String[] args) {
        
        // 1.

        String imagen = "./imagen.png";
        copiarImagen(imagen);

        // 2.

        creacionFichero();

        // 3.

        lecturaCalculo("./fichero.dat");

    }

    // METODO 1: Implementacion del metodo para copiar la imagen
    public static void copiarImagen(String imagen) {
        
        try {

            FileInputStream entrada = new FileInputStream(imagen);
            FileOutputStream salida = new FileOutputStream("copia_"+imagen);

            int byteLeido;
            
            while((byteLeido = entrada.read()) != -1){
                salida.write(byteLeido);
            }

            entrada.close();
            salida.close();

            System.out.println("Copia completa");
            
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }

    // METODO 2: Implementacion del metodo para crear un fichero
    public static void creacionFichero(){
        Scanner sc =new Scanner(System.in);
        
        try {

            DataOutputStream cr= new DataOutputStream(new FileOutputStream("archivo.dat"));

            String entrada;
            while(true){
                cr.writeInt(sc.nextInt());
                cr.writeChar(" ");
                cr.writeInt(sc.nextInt());
                cr.writeChar("\n");
                
                entrada=sc.nextLine();
                if(entrada.isEmpty()){
                    break;
                }
            }

            cr.flush();
            cr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // METODO 3: Lectura y calcculo de contenidos de un fichero
    public static void lecturaCalculo(String archivo){


        try {

            DataInputStream ca= new DataInputStream(new DataInputStream(archivo));

            int a;
            int b;
            int contador;
            while(true){
                a=ca.readInt();
                
                if(){}
            }
                
            

            cr.flush();
            cr.close();
            
        } catch (IOException e) {
            // TODO: handle exception
        }

    }
}
