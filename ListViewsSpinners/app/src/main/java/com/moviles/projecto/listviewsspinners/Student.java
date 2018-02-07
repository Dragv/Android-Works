package com.moviles.projecto.listviewsspinners;

/**
 * Created by drag on 2/02/18.
 */

public class Student {
    private String nombre;
    private float calificaion;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getCalificaion() {
        return calificaion;
    }

    public void setCalificaion(float calificaion) {
        this.calificaion = calificaion;
    }

    public Student(String nombre, float calificaion){
        this.nombre = nombre;
        this.calificaion = calificaion;
    }
}
