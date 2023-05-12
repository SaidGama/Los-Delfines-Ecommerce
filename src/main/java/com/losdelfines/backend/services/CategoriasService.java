package com.losdelfines.backend.services;

import com.losdelfines.backend.models.Categorias;
import com.losdelfines.backend.repositories.CategoriasRepository;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {

	private final CategoriasRepository categoriasRepository;

    @Autowired
    public CategoriasService(CategoriasRepository categoriasRepository) {
		this.categoriasRepository = categoriasRepository;
	}

	public List<Categorias> getAllCategorias(){
        return categoriasRepository.findAll();
    }//get todos

    public Categorias getCategoria(Long id) {
		return categoriasRepository.findById(id).orElseThrow(  
			()-> new IllegalArgumentException("La categoria con el id: " + id + " no existe.")   );
	}//get uno especifico

    public Categorias deleteCategoria(Long id) {
        Categorias tmpCategoria = null;
		if (categoriasRepository.existsById(id)) {
			tmpCategoria = categoriasRepository.findById(id).get();
			categoriasRepository.deleteById(id);
		}
		return tmpCategoria;
    }//borrar categoria

    public Categorias addCategoria(Categorias categoria) {
		return categoriasRepository.save(categoria);
    }//agregar categoria

    public Categorias updateCategoria(long id, String nombre, String descripcion) {
		Categorias tmpCategoria = null;
		if (categoriasRepository.existsById(id)) {
			tmpCategoria = categoriasRepository.findById(id).get();
			if (nombre!=null)tmpCategoria.setNombre(nombre);
			if (descripcion!=null)tmpCategoria.setDescripcion(descripcion);
			categoriasRepository.save(tmpCategoria);
		} else {
			System.out.println("Update - El producto con el id: " + id + " no existe");
		}
		return tmpCategoria;
	}//actualizar categoria

}