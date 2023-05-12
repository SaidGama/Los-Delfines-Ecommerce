package com.losdelfines.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "detalle_carrito")
public class Detalle_carrito {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	@Column(nullable = false)
	private long productos_id;
	@Column(nullable = false)
	private long carrito_id;
	@Column(nullable = false)
	private long cantidad;
	
	public Detalle_carrito(long id, long productos_id, long carrito_id, long cantidad) {
		super();
		this.id = id;
		this.productos_id = productos_id;
		this.carrito_id = carrito_id;
		this.cantidad = cantidad;
	}//constructor

	public Detalle_carrito() {
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

	@Override
	public String toString() {
		return "Detalle_carrito [id=" + id + ", productos_id=" + productos_id + ", carrito_id=" + carrito_id
				+ ", cantidad=" + cantidad + "]";
	}//toString

}// Detalle_carrito
