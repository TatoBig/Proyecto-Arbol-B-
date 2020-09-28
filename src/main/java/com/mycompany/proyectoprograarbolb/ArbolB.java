/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.proyectoprograarbolb;

/**
 *
 * @author Tato
 */
public class ArbolB {
    Integer grado;
    Nodo raiz;
    public ArbolB() {
       raiz = new Nodo();
    }
    public void insertar(String nombre,Integer valor)
    {
        Nodo NodoActual = raiz;
        Persona persona = new Persona();
        persona.setClave(valor);
        persona.setNombre(nombre);
        insertar(persona, NodoActual);
        
    }
    public void insertar(Persona persona,Nodo NodoActual){
        

            if(NodoActual.padre==null)
            {
                Nodo principal = new Nodo();
                principal.DefinirGrado(grado);
                principal.setPadre(null);
                principal.esHoja = true;
                principal.setPersona(persona,0);
                raiz = principal;            
            }
            else if(NodoActual.esHoja==true){
                if(NodoActual.setPersona(persona,0)==false)
                {
                    //Division(NodoActual);
                }
                raiz = NodoActual;
            }/*
            else{
                    for (int i = 0; i < NodoActual.tamañoNodo; i++) {
                    if(persona.clave<NodoActual.personas[i].clave)
                    {   insertar(persona,NodoActual.hijos[i]);
                        break;
                    }
                    else if(persona.clave>=NodoActual.personas[NodoActual.tamañoNodo].clave){
                        insertar(persona,NodoActual.hijos[i]);
                        break;
                    }
                }
            }*/
     

    }
    public void Division(Nodo NodoActual){
        if(NodoActual.getPadre()==null)
        {
            Nodo nuevaRaiz = new Nodo();
            nuevaRaiz.DefinirGrado(grado);
            nuevaRaiz.setPadre(null);            
            NodoActual.setPadre(nuevaRaiz);
            nuevaRaiz.setPersona(NodoActual.elevado,0);
            raiz = nuevaRaiz;
            nuevaRaiz.hijos[0] = NodoActual;

            Nodo nuevoHijo = new Nodo();
            nuevoHijo.DefinirGrado(grado);
            nuevoHijo.setPadre(NodoActual.padre);
            nuevaRaiz.hijos[1] = nuevoHijo;
            for(int i = (grado-1)/2;i<grado;i++)
            {
                nuevoHijo.setPersona(NodoActual.personas[i], 0);
            }
            NodoActual.eliminarSobrantes();
            nuevaRaiz.tamañoHijos = 1;
        }
        else if (NodoActual.getPadre()!=null)
        {
            Nodo nuevoHijo = new Nodo();
            nuevoHijo.DefinirGrado(grado);
            nuevoHijo.setPadre(NodoActual.padre);
            NodoActual.padre.hijos[NodoActual.padre.tamañoHijos+1] = nuevoHijo;
            NodoActual.padre.tamañoHijos++;
            for(int i = (grado-1)/2;i<grado;i++)
            {
                nuevoHijo.setPersona(NodoActual.personas[i], 0);
            }
            NodoActual.padre.setPersona(NodoActual.elevado, 0);
            NodoActual.eliminarSobrantes();
        }
        
    }            
    public void setGrado(Integer grado){
        this.grado = grado;
    }
    public void imprimir(Nodo nodo,int j)
    {
       if(nodo!=null)       
       {
           
           nodo.imprimirValores();
           System.out.println("HIJO: " + (j+1));
           for(int i=0;i<grado;i++)
           {               
               imprimir(nodo.hijos[i],i+1);
           }
           
       }
    }
    public Nodo getRaiz(){
        return raiz;
    }
    
}
