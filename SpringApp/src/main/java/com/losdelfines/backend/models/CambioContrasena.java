package com.losdelfines.backend.models;

public class CambioContrasena {
	private String contrasena;
	private String newContrasena;
	public CambioContrasena(String contrasena, String newContrasena) {
		super();
		this.contrasena = contrasena;
		this.newContrasena = newContrasena;
	}//constructor
	
	public CambioContrasena() {}//constructor por default

	public String getContrasena() {
		return contrasena;
	}//getContrasena

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}//setContrasena

	public String getNewContrasena() {
		return newContrasena;
	}//getNewContrasena

	public void setNewContrasena(String newContrasena) {
		this.newContrasena = newContrasena;
	}//setNewContrasena

	@Override
	public String toString() {
		return "CambioContrasena [contrasena=" + contrasena + ", newContrasena=" + newContrasena + "]";
	}//toString

}//class CambioContrasena
