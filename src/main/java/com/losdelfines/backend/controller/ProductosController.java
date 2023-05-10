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

import com.losdelfines.backend.models.Productos;
import com.losdelfines.backend.services.ProductosServices;

@RestController
@RequestMapping(path="/productos/")
public class ProductosController {
    private final ProductosServices productosService;
    
    @Autowired
    public ProductosController(ProductosServices productosService) {
		this.productosService = productosService;
    }//constructor
    
    @GetMapping
    public List<Productos> getAllProductos(){
    	return productosService.getAllProductos();
    }//getAll

	@GetMapping (path="{prodId}")
	public Productos getProducto(@PathVariable("prodId") Long id) {
		return productosService.getProducto(id);
	}//getProduct
	@DeleteMapping (path="{prodId}")
	public Productos deleteProducto(@PathVariable("prodId") Long id) {
		return productosService.deleteProducto(id);
	}//deleteProduct
	@PostMapping
	public Productos addProducto (@RequestBody Productos producto) {
		return productosService.addproducto(producto);
	}//PostMapping
	@PutMapping (path="{prodId}")
	public Productos updateProducto (@PathVariable("prodId") Long id, 
			@RequestParam(required = false)String nombre,
			@RequestParam(required = false)String descripcion,
			@RequestParam(required = false)Long stock,
			@RequestParam(required = false)Double precio) {
			return productosService.updateProducto(id, nombre, descripcion, precio, stock);
	}//Update
	
}//class ProductosController
