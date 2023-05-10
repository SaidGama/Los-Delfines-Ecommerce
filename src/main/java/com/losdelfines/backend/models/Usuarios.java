package com.losdelfines.backend.models;
//POJO - Plain Old Java Object
public class Usuarios {
	private String nombre;
	private String correo;
	private String domicilio;
	private String contraseña;
	private String telefono;
	private long id;
	private static long total=0;
	public Usuarios(String nombre, String correo, String domicilio, String contraseña, String telefono) {
		super();
		this.nombre = nombre;
		this.correo = correo;
		this.domicilio = domicilio;
		this.contraseña = contraseña;
		this.telefono = telefono;
		total++;
		this.id=Usuarios.total;
	}//constructor
	
	public Usuarios() {	}//constructor default

	public String getNombre() {
		return nombre;
	}//getNombre

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}//setNombre

	public String getCorreo() {
		return correo;
	}//getCorreo

	public void setCorreo(String correo) {
		this.correo = correo;
	}//setCorreo

	public String getDomicilio() {
		return domicilio;
	}//getDomicilio

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}//setDomicilio

	public String getContraseña() {
		return contraseña;
	}//getContraseña

	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}//setContraseña

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//set

	public long getId() {
		return id;
	}//getId

	public void setId(long id) {
		this.id = id;
	}//setId

	public static long getTotal() {
		return total;
	}//getTotal

	public static void setTotal(long total) {
		Usuarios.total = total;
	}//setTotal

	@Override
	public String toString() {
		return "Usuarios [nombre=" + nombre + ", correo=" + correo + ", domicilio=" + domicilio + ", contraseña="
				+ contraseña + ", telefono=" + telefono + ", id=" + id + "]";
	}//toString
	
}//class Usuarios
