/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprograarbolb;

import java.util.Arrays;

/**
 *
 * @author Tato
 */
public class Nodo {
    Nodo padre;
    Nodo hijos[];
    Persona personas[];    
    int tamañoNodo;
    int tamañoHijos;
    int grado;
    Persona elevado;
    boolean esHoja;
    //grado-1
    //(grado-1)/2
    public Nodo()
    {
        padre = null;
    }
    public void DefinirGrado(Integer grado){
        personas = new Persona[grado];
        hijos = new Nodo[grado]; 
        this.grado = grado;        
        for (int i = 0; i < this.grado; i++) {
            personas[i] = new Persona();
        }
    }
    public void setPadre(Nodo padre){
        
    }
    public Nodo getPadre(){
        return padre;
    }
    public void imprimirValores(){
        for (int i = 0; i < tamañoNodo; i++) {
            if(personas[i].getClave()!=0){
            System.out.println("Clave: "+personas[i].getClave() + " - Nombre: "+personas[i].getNombre());
            }
        }
    }
    public boolean setPersona(Persona personaNueva, Integer i){
        boolean resultado = false;
        if(i==grado-1){
            resultado = false;
            this.personas[grado-1] = personaNueva;
            ordenar();
            elevado = this.personas[(grado-1)/2];
        }
        else{
            if(this.personas[i].getClave()==0){
                this.personas[i] = personaNueva;
                tamañoNodo++;
                ordenar();
                resultado = true;
            }
            else{
                resultado = setPersona(personaNueva,i+1);                
            }            
        }
        return resultado;
    }
    public boolean estaLleno()
    {
        return tamañoNodo!=grado-1;
    }

    public void ordenarValores() {
        
    }
    public void ordenar()
    {
      Persona aux;
      if(tamañoNodo>1)
      for(int i = 2; i < tamañoNodo; i++)
      {
        for(int j = 0;j < tamañoNodo-1;j++)
        {
          if(this.personas[j].getClave() > this.personas[j+1].getClave())
          {
            aux = this.personas[j];
            this.personas[j] = this.personas[j+1];
            this.personas[j+1] = aux;
          }   
        }
        
      }
    }
    public void tamañoHijos()
    {
        
    }

    void eliminarSobrantes() {
        for (int i = (grado-1)/2; i < grado; i++) {
            this.personas[i] = new Persona();
        }
        elevado = null;
        tamañoNodo = tamañoNodo-((grado-1)/2);
    }
}
