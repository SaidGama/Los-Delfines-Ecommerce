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
import org.springframework.web.bind.annotation.RestController;
import com.losdelfines.backend.models.Administradores;
import com.losdelfines.backend.models.CambioContrasena;
import com.losdelfines.backend.services.AdministradoresService;
@RestController
@RequestMapping (path = "/administradores/") // http://127.0.0.1:8080/administradores

public class AdministradoresController {

	private final AdministradoresService administradoresService;
	
	@Autowired
	public  AdministradoresController(AdministradoresService administradoresService) {
		this.administradoresService = administradoresService;
	}//constructor
	
	@GetMapping //get en postman
	public List<Administradores> getAdministradores(){
		return administradoresService.getAllAdministradores();
	}//getallAdmi
	@GetMapping (path="{admiId}") //seleccionar un id posman
	public Administradores getAdministradores(@PathVariable("admiId") Long id) {
		return administradoresService.getAdministradores(id);
	}//getidAdmi
	@PutMapping  (path="{admiId}") //http://127.0.0.1:8080/api/productos/
	public Administradores updateAdministradores (@PathVariable("admiId") Long id,
			@RequestBody CambioContrasena cambioContrasena){
		return administradoresService.updateAdministrador(id, cambioContrasena);
	}//actualizarAdministrador

	@DeleteMapping (path="{admiId}") //eliminar en psotman 
	public Administradores deleteAdministradores(@PathVariable("admiId") Long id) {
		return administradoresService.deleteAdministradores(id);
	}//deleteAdmi

	@PostMapping 
	public Administradores addAdministradores (@RequestBody Administradores administrador) {
		return administradoresService.addAdministradores(administrador);
	}//addproducto

}//class admi controller