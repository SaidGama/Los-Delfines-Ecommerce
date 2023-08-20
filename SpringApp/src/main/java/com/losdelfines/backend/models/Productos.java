package com.losdelfines.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productos")
public class Productos {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique =true, nullable =false)
	private long id;
	@Column(nullable = false)
    private String nombre;
	@Column(nullable = false)
    private String descripcion;
	@Column(nullable = false)
    private double precio;
	@Column(nullable = false)
    private long stock;
	@Column(nullable = false)
    private long categorias_id;
    @Column(name = "imagen", nullable = false, columnDefinition = "MEDIUMTEXT")
	private String imagen;
	//private static long total=0;
    
	public Productos(String nombre, String descripcion, double precio, long stock, long categorias_id,String imagen) {
		super();
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.precio = precio;
		this.stock = stock;
		this.categorias_id = categorias_id;
		this.imagen = imagen;
	}
	public Productos() {
//		total ++;
//		this.id =(Productos.total);
	}// constructor default
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
	public long getCategorias_id() {
		return categorias_id;
	}
	public void setCategorias_id(long categorias_id) {
		this.categorias_id = categorias_id;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	@Override
	public String toString() {
		return "Productos [id=" + id + ", nombre=" + nombre + ", descripcion=" + descripcion + ", precio=" + precio
				+ ", stock=" + stock + ", categorias_id=" + categorias_id + "]";
	}

	
	
}//class productos
