package com.losdelfines.backend.services;
import com.losdelfines.backend.models.Categorias;
import java.util.ArrayList;
import org.springframework.stereotype.Service;

@Service
public class CategoriasService {
    public final ArrayList<Categorias> listaCategorias = new ArrayList<>();

    public CategoriasService(){
        listaCategorias.add(new Categorias(1,"purificador","purificadores de agua"));
        listaCategorias.add(new Categorias(2,"filtros","filtro para garrafon"));
    }

    public ArrayList<Categorias> getAllCategorias(){
        return listaCategorias;
    }

    public Categorias getCategoria(Long id) {
		Categorias tmpCategoria = null;
		for (Categorias categoria : listaCategorias) {
			if (categoria.getId() == id) {
				tmpCategoria = categoria;
			}
		}
		return tmpCategoria;
	}

    public Categorias deleteCategoria(Long id) {
        Categorias tmpCategoria = null;
		for (Categorias categoria : listaCategorias) {
			if (categoria.getId() == id) {
				tmpCategoria = listaCategorias.remove(listaCategorias.indexOf(categoria));
				break;
			}
		}
		return tmpCategoria;
    }

    public Categorias addCategoria(Categorias categoria) {
		listaCategorias.add(categoria);
        return categoria;
    }

    public Categorias updateCategoria(long id, String nombre, String descripcion) {
		Categorias tmpCategoria = null;
		for (Categorias categoria : listaCategorias) {
			if (categoria.getId()==id) {
				if (nombre!=null) categoria.setNombre(nombre);
				if (descripcion!=null) categoria.setDescripcion(descripcion);
				tmpCategoria = categoria;
			}
		}
		return tmpCategoria;
	}

}