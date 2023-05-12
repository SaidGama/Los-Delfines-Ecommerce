package com.losdelfines.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//POJO - Plain Old Java Object

@Entity
@Table(name="usuarios")
public class Usuarios {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private long id;
	@Column(nullable=false)
	private String nombre;
	@Column(nullable=false)
	private String correo;
	@Column(nullable=false)
	private String domicilio;
	@Column(nullable=false)
	private String contrasena;
	@Column(nullable=false)
	private String telefono;
	
	public Usuarios(long id, String nombre, String correo, String domicilio, String contrasena, String telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.correo = correo;
		this.domicilio = domicilio;
		this.contrasena = contrasena;
		this.telefono = telefono;
	}//constructor
	
	public Usuarios() {}//constructor por default

	public long getId() {
		return id;
	}//getId

	public void setId(long id) {
		this.id = id;
	}//setId

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
	}//getDimicilio

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}//setDomicilio

	public String getContrasena() {
		return contrasena;
	}//getContraseña

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContraseña

	public String getTelefono() {
		return telefono;
	}//getTelefono

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}//setTelefono

	@Override
	public String toString() {
		return "Usuarios [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", domicilio=" + domicilio
				+ ", contraseña=" + contrasena + ", telefono=" + telefono + "]";
	}//toString
	
}//class Usuarios
