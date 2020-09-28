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
public class Persona {
    String nombre;
    int clave;
    public Persona()
    {
        clave = 0;
        nombre = "";
    }
    public int getClave()
    {
        return clave;
    }
    public void setClave(int clave)
    {
        this.clave = clave;
    }
    public String getNombre()
    {
        return nombre;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}

