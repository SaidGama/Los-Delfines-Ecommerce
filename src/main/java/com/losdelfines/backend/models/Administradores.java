package com.losdelfines.backend.models;

public class Administradores {
    private String nombre;
    private String correo;
    private String contrasena;
    private long id;
    private static long total=0;

    public Administradores(String nombre, String correo, String contrasena) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this. contrasena = contrasena;
        total++;
        id=Administradores.total;
    }//constructor
public Administradores() {
    Administradores.total++;
    id=Administradores.total;
}//constructordefault
public String getNombre() {
		return nombre;
	}//getnombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setnombre

	public String getCorreo() {
		return correo;
	}//getcorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getContrasena() {
		return contrasena;
	}//getContrasena
	
	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setCorreo
	//geters and seters
	public long getId() {
		return id;
	}//getId
	public void setId(long id) {
		this.id = id;
	}//setId
	@Override
	public String toString() {
		return "Administradores [nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena + ", id=" + id + "]";
	}//to string
}//class administradores