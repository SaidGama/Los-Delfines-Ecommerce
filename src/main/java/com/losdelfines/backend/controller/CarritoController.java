package com.losdelfines.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.losdelfines.backend.models.Carrito;
import com.losdelfines.backend.services.CarritoServices;

@RestController
@RequestMapping(path = "/api/carrito/")
public class CarritoController {

	// CRUD Create - Read - Update - Delate
	// HTTP POST - GET - PUT - DELETE

	private final CarritoServices carritoService;

	@Autowired
	public CarritoController(CarritoServices carritoService) {
		this.carritoService = carritoService;
	}// constructor

	@GetMapping
	public List<Carrito> getAllCarts() {
		return carritoService.getAllCarritos();
	}// getAllCarts

	@GetMapping(path = "{cartId}") // http://127.0.0.1:8080/api/carrito/1
	public Carrito getCart(@PathVariable("cartId") Long id) {
		return carritoService.getCarrito(id);
	}// getCart

	@DeleteMapping(path = "{cartId}") // http://127.0.0.1:8080/api/carrito/1
	public Carrito deleteCart(@PathVariable("cartId") Long id) {
		return carritoService.deleteCarrito(id);
	}// deleteCart

	@PostMapping // http://127.0.0.1:8080/api/carrito/
	public Carrito addCart(@RequestBody Carrito carrito) {
		return carritoService.addCarrito(carrito);
	}// addCart

	@PutMapping(path = "{cartId}")
	public Carrito updateCart(@PathVariable("cartId") Long id, @RequestParam(required = false) Long usuario_id) {
		return carritoService.updateCarrito(id, usuario_id);
	}// updateCart

}// class CarritoController
