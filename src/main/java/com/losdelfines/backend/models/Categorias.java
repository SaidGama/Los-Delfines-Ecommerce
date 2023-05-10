package com.losdelfines.backend.models;

public class Categorias {
    
    private long id;
    private String nombre;
    private String descripcion;
    private static long total = 0;

    public Categorias(long id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        total++;
        id = Categorias.total;
    }
    
    public Categorias(){
        this.id = Categorias.total;
    }

    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    @Override
    public String toString() {
        return "Categorias [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
    }
    
}
