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
import com.losdelfines.backend.models.Detalle_carrito;
import com.losdelfines.backend.services.Detalle_CarritoServices;

@RestController
@RequestMapping(path = "/api/detallecarrito/")
public class Detalle_carritoController {
    
	// CRUD Create - Read - Update - Delate
	// HTTP POST - GET - PUT - DELETE
	
	private final Detalle_CarritoServices detalle_carritoservices;
	
	@Autowired
	public Detalle_carritoController(Detalle_CarritoServices detalle_carritoservices) {
		this.detalle_carritoservices = detalle_carritoservices;
	}// constructor
	
	@GetMapping
	public List<Detalle_carrito> getAllDCarts() {
		return detalle_carritoservices.getAllDCarritos();
	}// getAllDCarts
	
	@GetMapping(path = "{dcartId}") // http://127.0.0.1:8080/api/detallecarrito/1
	public Detalle_carrito getDCart(@PathVariable("dcartId") Long id) {
		return detalle_carritoservices.getDCarrito(id);
	}// getDCart
	
	@DeleteMapping(path = "{dcartId}") // http://127.0.0.1:8080/api/detallecarrito/1
	public Detalle_carrito deleteDCart(@PathVariable("dcartId") Long id) {
		return detalle_carritoservices.deleteDCarrito(id);
	}// deleteDCart
	
	@PostMapping // http://127.0.0.1:8080/api/detallecarrito/
	public Detalle_carrito addDCart(@RequestBody Detalle_carrito detalle_carrito) {
		return detalle_carritoservices.addDCarrito(detalle_carrito);
	}// addDCart
	
	@PutMapping (path="{dcartId}")
	public Detalle_carrito updateDCart(@PathVariable("dcartId") Long id,
		@RequestParam(required = false)	Long productos_id,
		@RequestParam(required = false)	Long carrito_id,
		@RequestParam(required = false)	Long cantidad) {
		return detalle_carritoservices.updateDCarrito(id, productos_id, carrito_id, cantidad);
	}//updateDCart
		
}//Detalle_carritoController
