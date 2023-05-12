package com.losdelfines.backend.controller;
import com.losdelfines.backend.models.Categorias;

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
import com.losdelfines.backend.services.CategoriasService;

@RestController
@RequestMapping(path = "/categorias/")
public class CategoriasController {

    private final CategoriasService categoriasService;

    @Autowired
    public CategoriasController(CategoriasService categoriasService){
        this.categoriasService = categoriasService;
    }

    @GetMapping
    public List<Categorias> getAllCategorias(){
        return categoriasService.getAllCategorias();
    }
    
    @GetMapping(path = "{categoriaId}")
    public Categorias getCategoria(@PathVariable("categoriaId")  Long id){
        return categoriasService.getCategoria(id);
    }
    @DeleteMapping(path = "{categoriaId}")
    public Categorias removeCategoria(@PathVariable("categoriaId")  Long id){
        return categoriasService.deleteCategoria(id);
    }
    @PostMapping
    public Categorias addCategoria(@RequestBody Categorias categoria){
        return categoriasService.addCategoria(categoria);
    }

    @PutMapping(path = "{categoriaId}")
    public Categorias updateProducto (@PathVariable("categoriaId") long id,
    @RequestParam(required = false) String nombre,
    @RequestParam(required = false) String descripcion){
        return categoriasService.updateCategoria(id, nombre, descripcion);
    }

}
