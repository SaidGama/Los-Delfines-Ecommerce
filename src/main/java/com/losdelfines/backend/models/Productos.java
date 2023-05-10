package com.losdelfines.backend.models;


public class Productos {
    private String nombre;
    private String descripcion;
    private double precio;
    private long stock;
    private long id;
	private static long total=0;
    
	public Productos (String nombre, String descripcion, double precio, long stock) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		total ++;
		this.id = Productos.total;
	}
	
	public Productos() {}
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
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public long getStock() {
		return stock;
	}
	public void setStock(long stock) {
		this.stock = stock;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public static long getTotal() {
		return total;
	}
	public static void setTotal(long total) {
		Productos.total = total;
	}
	@Override
	public String toString() {
		return "Productos [nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio + ", stock="
				+ stock + ", id=" + id + "]";
	}//toString
	
	
}//class productos
