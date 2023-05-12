package com.losdelfines.backend.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.losdelfines.backend.models.Detalle_carrito;
import com.losdelfines.backend.repositories.Detalle_carritoRepository;

@Service
public class Detalle_CarritoServices {

	private final Detalle_carritoRepository detalle_carritoRepository;

	@Autowired
	public Detalle_CarritoServices(Detalle_carritoRepository detalle_carritoRepository) {
		this.detalle_carritoRepository = detalle_carritoRepository;
	}

	public List<Detalle_carrito> getAllDCarritos() {
		return detalle_carritoRepository.findAll();
	}// getAllDCarritos

	public Detalle_carrito getDCarrito(Long id) {
		return detalle_carritoRepository.findById(id).orElseThrow(
				()-> new IllegalArgumentException("El detalle_Carrito con el id: " + id + " no existe."));
	}// getDCarrito

	public Detalle_carrito deleteDCarrito(Long id) {
		Detalle_carrito tmpDCart = null;
		if (detalle_carritoRepository.existsById(id)) {
			tmpDCart = detalle_carritoRepository.findById(id).get();
			detalle_carritoRepository.deleteById(id);
		}
		return tmpDCart;
	}// deleteDCarrito

	public Detalle_carrito addDCarrito(Detalle_carrito detalle_carrito) {
		return detalle_carritoRepository.save(detalle_carrito);
	}// addDCarrito
	

	public Detalle_carrito updateDCarrito(Long id, Long productos_id, Long carrito_id, Long cantidad) {	
		Detalle_carrito tmpDCart = null;
		if (detalle_carritoRepository.existsById(id)) {
			tmpDCart = detalle_carritoRepository.findById(id).get();
			if (productos_id!=null)tmpDCart.setProductos_id(productos_id);;
			if (carrito_id!=null)tmpDCart.setCarrito_id(carrito_id);
			if (cantidad!=null)tmpDCart.setCantidad(cantidad);;
			detalle_carritoRepository.save(tmpDCart);
		} else {
			System.out.println("Update - El detalle carrito con el id: " + id + " no existe");
		}
		return tmpDCart;
	}//updateDCarrito
	
}// Detalle_CarritoServices