package com.losdelfines.backend.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.losdelfines.backend.models.Productos;

@Service
public class ProductosServices {
    private final ArrayList<Productos> lista = new ArrayList<>();
    @Autowired
    public ProductosServices() {
    	lista.add(new Productos("Garrafón de agua", "Rellenado de garrafón de 20lts de agua purificada", 25.0, 999));
    	lista.add(new Productos("Dispensador de agua", "Dispensador para garrafon de agua", 110.0, 150));
    	lista.add(new Productos("Dispensador de agua clásico", "Dispensador de agua clásico de ceramica", 169.0, 200));
    	lista.add(new Productos("Agua - 5lts", "Botellón de 5lts con agua purificada", 27.5, 200));
    	lista.add(new Productos("Agua - Pack 6pzs 1lt", "Paquete con 6 botellas de 1lt", 39.99, 200));
    	lista.add(new Productos("Filtro de agua", "Filtro de agua portátil", 109.95, 200));
    }//constructor
    
    public ArrayList<Productos> getAllProductos(){
    	return lista;
    }//getAll
    
    public Productos getProducto(Long id) {
		Productos tmpProd = null;
		for(Productos producto : lista) {
			if (producto.getId()==id) {
				tmpProd = producto;
			}//if
		}//foreach
		return tmpProd;
	}//getProducto
    
    public Productos deleteProducto(Long id) {
    	Productos tmpProd = null;
		for(Productos producto : lista) {
			if (producto.getId()==id) {
				tmpProd = lista.remove(lista.indexOf(producto));
				break;
			}//if
		}//foreach
		return tmpProd;
	}//deleteProducto
    
    public Productos addproducto(Productos producto) {
		lista.add(producto);
		return producto;
	}//addProducto
    
    public Productos updateProducto(Long id, String nombre, String descripcion, Double precio, Long stock) {
    	Productos tmpProd = null;
		for(Productos producto : lista) {
			if (producto.getId()==id) {
				if (nombre!=null)producto.setNombre(nombre);
				if (descripcion!=null)producto.setDescripcion(descripcion);
				if (stock!=null)producto.setStock(stock);
				if (precio!=null)producto.setPrecio(precio.doubleValue());
				tmpProd = lista.remove(lista.indexOf(producto));
				break;
			}//if
		}//foreach
		return tmpProd;
	}//updateProducto
}
