package com.losdelfines.backend.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "carrito")
public class Carrito {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique = true, nullable = false)
	private long id;
	@Column(nullable = false)
	private long usuario_id;


	public Carrito(long id, long usuario_id) {
		super();
		this.id = id;
		this.usuario_id = usuario_id;
	}//constructor

	public Carrito() {
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

	@Override
	public String toString() {
		return "Carrito [id=" + id + ", usuario_id=" + usuario_id + "]";
	}


}// Carrito
