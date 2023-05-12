package com.losdelfines.backend.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losdelfines.backend.models.Carrito;
import com.losdelfines.backend.repositories.CarritoRepository;

@Service
public class CarritoServices {

//	public final ArrayList<Carrito> lista = new ArrayList<>();
	private final CarritoRepository carritoRepository;

	@Autowired
	public CarritoServices(CarritoRepository carritoRepository) {
		this.carritoRepository = carritoRepository;
	}// constructor

	public List<Carrito> getAllCarritos() {
		return carritoRepository.findAll();
	}// getAllCarritos

	public Carrito getCarrito(Long id) {
		return carritoRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Usuario con id " + id + " no existe"));
	}// getCarrito

	public Carrito deleteCarrito(Long id) {
		Carrito tmpCart = null;
		if (carritoRepository.existsById(id)) {
			tmpCart = carritoRepository.findById(id).get();
			carritoRepository.deleteById(id);
		} // if
		return tmpCart;
	}// deleteCarrito

	public Carrito addCarrito(Carrito carrito) {
		return carritoRepository.save(carrito);
	}// addCarrito

	public Carrito updateCarrito(Long id, Long usuario_id) {
		Carrito tmpCart = null;
		
		if(carritoRepository.existsById(id)) {
			tmpCart = carritoRepository.findById(id).get();
			if (usuario_id != null) tmpCart.setUsuario_id(usuario_id);
			carritoRepository.save(tmpCart);
		} else {
			System.out.println("Update - El producto con id " + id + " no existe");
		}//else
		return tmpCart;
	}// updateCarrito

}// class CarritoServices
