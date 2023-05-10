package com.losdelfines.backend.services;

import java.util.ArrayList;


import org.springframework.stereotype.Service;

import com.losdelfines.backend.models.Carrito;

@Service
public class CarritoServices {

	public final ArrayList<Carrito> lista = new ArrayList<>();

	public CarritoServices() {
		lista.add(new Carrito(1));
		lista.add(new Carrito(2));
		lista.add(new Carrito(3));
	}// constructor

	public ArrayList<Carrito> getAllCarritos() {
		return lista;
	}// getAllCarritos

	public Carrito getCarrito(Long id) {
		Carrito tmpCart = null;
		for (Carrito carrito : lista) {
			if (carrito.getId() == id) {
				tmpCart = carrito;
			} // if
		} // foreach
		return tmpCart;
	}// getCarrito

	public Carrito deleteCarrito(Long id) {
		
		Carrito tmpCart = null;
		for (Carrito carrito : lista) {
			if (carrito.getId() == id) {
				tmpCart = lista.remove(lista.indexOf(carrito));
			} // if
		} // foreach
		return tmpCart;
		
	}//deleteCarrito

	public Carrito addCarrito(Carrito carrito) {
	lista.add(carrito);
	return carrito;
		
	}//addCarrito

	public Carrito updateCarrito(Long id, Long usuario_id) {
		
		Carrito tmpCart = null;
		for (Carrito carrito : lista) {
			if (carrito.getId() == id) {
				if (usuario_id != null)
					carrito.setUsuario_id(usuario_id);
				tmpCart = carrito;
				break;
			} // if
		} // foreach
		return tmpCart;
	}//updateCarrito
	
	
	
	
}// class CarritoServices



