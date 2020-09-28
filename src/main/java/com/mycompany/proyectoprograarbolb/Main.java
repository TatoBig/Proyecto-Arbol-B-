/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprograarbolb;

import java.util.Scanner;

/**
 *
 * @author Tato
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner S = new Scanner(System.in);
        ArbolB arbol = new ArbolB();
        System.out.println("Ingrese el grado del arbol");
        int grado = S.nextInt();
        arbol.setGrado(grado);
        
        arbol.insertar("Santiago",9);
        arbol.insertar("Kevin",12);
        arbol.insertar("Luis",3);
        arbol.insertar("Bryan",6);       
        arbol.imprimir(arbol.raiz,0);
        for (int i = 0; i < 10; i++) {
            System.out.println("nombre");
            String nombre = S.next();
            System.out.println("clave");
            int clave = S.nextInt();
            arbol.insertar(nombre, clave);
            arbol.imprimir(arbol.raiz,0);
            
        }
        
    }
    
}
