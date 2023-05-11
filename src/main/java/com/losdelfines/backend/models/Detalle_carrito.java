package com.losdelfines.backend.models;

public class Detalle_carrito {
    
	private long id;
	private long productos_id;
	private long carrito_id;
	private long cantidad;
	private static long total = 0;
	public Detalle_carrito(long productos_id, long carrito_id, long cantidad) {	
		this.productos_id = productos_id;
		this.carrito_id = carrito_id;
		this.cantidad = cantidad;
		total++;
		id = Detalle_carrito.total;
	}// constructor 
	
	public Detalle_carrito() {
		total++;
		id = Detalle_carrito.total;
	}// constructor default

	public long getId() {
		return id;
	}//getId

	public void setId(long id) {
		this.id = id;
	}//setId

	public long getProductos_id() {
		return productos_id;
	}//getProductos_id

	public void setProductos_id(long productos_id) {
		this.productos_id = productos_id;
	}//setProductos_id

	public long getCarrito_id() {
		return carrito_id;
	}//getCarrito_id

	public void setCarrito_id(long carrito_id) {
		this.carrito_id = carrito_id;
	}//setCarrito_id

	public long getCantidad() {
		return cantidad;
	}//getCantidad

	public void setCantidad(long cantidad) {
		this.cantidad = cantidad;
	}//setCantidad

	public static long getTotal() {
		return total;
	}//getTotal

	public static void setTotal(long total) {
		Detalle_carrito.total = total;
	}//setTotal

	@Override
	public String toString() {
		return "Detalle_carrito [id=" + id + ", productos_id=" + productos_id + ", carrito_id=" + carrito_id
				+ ", cantidad=" + cantidad + "]";
	}//toString

	
}// Detalle_carrito
