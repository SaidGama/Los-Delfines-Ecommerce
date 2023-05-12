package com.losdelfines.backend.models;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
//POJO - Plain Old Java Project
@Entity
@Table(name="administradores") // http://127.0.0.1:8080/api/administradores/
public class Administradores {
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	@Column(nullable=false)
    private String nombre;
	@Column(nullable=false)
    private String correo;
	@Column(nullable=false)
    private String contrasena;

    public Administradores(String nombre, String correo, String contrasena) {
        super();
        this.nombre = nombre;
        this.correo = correo;
        this.contrasena = contrasena;
    }//constructor
	public Administradores() {
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
		return "Administradores [id=" + id + ", nombre=" + nombre + ", correo=" + correo + ", contrasena=" + contrasena
				+ "]";
	}//toString
	
}//class administradores