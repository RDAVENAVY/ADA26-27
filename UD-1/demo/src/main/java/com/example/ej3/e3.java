package com.example.ej3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class e3 {
    public static void main(String[] args) {
        
        // 1.

        String imagen = "imagen.png";
        copiarImagen(imagen);

        // 2.

        creacionFichero("fichero.dat");

        // 3.

        lecturaCalculo("fichero.dat");

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
    public static void creacionFichero(String nombreArchivo){
        Scanner sc =new Scanner(System.in);
        
        try {

            DataOutputStream cr= new DataOutputStream(new FileOutputStream("archivo.dat"))

            while(true){
                String linea = sc.nextLine();
                
                if(linea.isEmpty()){
                    break;
                }

                int num1 = sc.nextInt();
                int num2 = sc.nextInt();

                // Guardar los enteros como tipo primitivo Java
                cr.writeInt(num1);
                cr.writeInt(num2);
                }

            sc.close();
            cr.flush();
            cr.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    // METODO 3: Lectura y calcculo de contenidos de un fichero
    public static void lecturaCalculo(String archivo){

        int sumaColumna1 = 0;
        int cantidadNumeros = 0;
        long sumaPonderadaNum = 0;
        long sumaPonderadaDen = 0; 

        try (DataInputStream ca = new DataInputStream(new FileInputStream(archivo))) {
            
            while (true) {
                int a = ca.readInt();
                int b = ca.readInt();
                
                // Calculos
                sumaColumna1 += a;
                cantidadNumeros++;
                
                sumaPonderadaNum += (long) a * b;
                sumaPonderadaDen += b;
            }
            
        } catch (EOFException e) {
            // Se alcanza el final del fichero.
            if (cantidadNumeros > 0) {
                double mediaAritmetica = (double) sumaColumna1 / cantidadNumeros;
                System.out.println("La media aritmetica de la primera columna es: " + mediaAritmetica);
                
                if (sumaPonderadaDen != 0) {
                    double mediaPonderada = (double) sumaPonderadaNum / sumaPonderadaDen;
                    System.out.println("La media ponderada de la primera columna es: " + mediaPonderada);
                } else {
                    System.out.println("No se puede calcular la media ponderada (la suma de los pesos es 0).");
                }
            } else {
                System.out.println("El fichero esta vacio o no contiene pares validos.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

