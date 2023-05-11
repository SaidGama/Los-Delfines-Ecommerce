package com.losdelfines.backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.losdelfines.backend.models.Detalle_carrito;

@Service
public class Detalle_CarritoServices {
	public final ArrayList<Detalle_carrito> lista = new ArrayList<>();

	@Autowired
	public Detalle_CarritoServices() { // (long productos_id, long carrito_id, long cantidad)
		lista.add(new Detalle_carrito(1, 1, 3));
		lista.add(new Detalle_carrito(2, 2, 5));
	}// constructor

	public ArrayList<Detalle_carrito> getAllDCarritos() {
		return lista;
	}// getAllDCarritos

	public Detalle_carrito getDCarrito(Long id) {
		Detalle_carrito tmpDCart = null;
		for (Detalle_carrito detalle_carrito : lista) {
			if (detalle_carrito.getId() == id) {
				tmpDCart = detalle_carrito;
			} // if
		} // foreach
		return tmpDCart;
	}// getDCarrito

	public Detalle_carrito deleteDCarrito(Long id) {
		Detalle_carrito tmpDCart = null;
		for (Detalle_carrito detalle_carrito : lista) {
			if (detalle_carrito.getId() == id) {
				tmpDCart = lista.remove(lista.indexOf(detalle_carrito));
			} // if
		} // foreach
		return tmpDCart;
	}// deleteDCarrito

	public Detalle_carrito addDCarrito(Detalle_carrito detalle_carrito) {
		lista.add(detalle_carrito);
		return detalle_carrito;
	}// addDCarrito
	

	public Detalle_carrito updateDCarrito(Long id, Long productos_id, Long carrito_id, Long cantidad) {	
		Detalle_carrito tmpDCart = null;
		for (Detalle_carrito detalle_carrito : lista) {
			if (detalle_carrito.getId() == id) {
				if (productos_id != null)
					detalle_carrito.setProductos_id(productos_id);
				if (carrito_id != null)
					detalle_carrito.setCarrito_id(carrito_id);
				if (cantidad != null)
					detalle_carrito.setCantidad(cantidad);
				tmpDCart = detalle_carrito;
				break;
			} // if
		} // foreach
		return tmpDCart;
	}//updateDCarrito
	
}// Detalle_CarritoServices
