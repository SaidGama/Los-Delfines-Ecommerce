package com.losdelfines.backend.models;


public class Carrito {

	private long id;
	private long usuario_id;
	private static long total = 0;

	public Carrito(long usuario_id) {
		this.usuario_id = usuario_id;
		total++;
		id = Carrito.total;
	}// constructor

	public Carrito() {
		total++;
		id = Carrito.total;
	}// constructor default

	public long getId() {
		return id;
	}// getId

	public void setId(long id) {
		this.id = id;
	}// setId

	public long getUsuario_id() {
		return usuario_id;
	}// getUsuario_id

	public void setUsuario_id(long usuario_id) {
		this.usuario_id = usuario_id;
	}// setUsuario_id

	public static long getTotal() {
		return total;
	}// getTotal

	public static void setTotal(long total) {
		Carrito.total = total;
	}// setTotal

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario_id=" + usuario_id + "]";
	}// toString

}// Carrito
