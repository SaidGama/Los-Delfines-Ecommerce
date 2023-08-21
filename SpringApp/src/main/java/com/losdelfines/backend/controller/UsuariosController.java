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

import com.losdelfines.backend.models.CambioContrasena;
import com.losdelfines.backend.models.Usuarios;
import com.losdelfines.backend.services.UsuariosServices;

//CRUD     Create    - Read     - Update      - Delete
//HTTP     POST      - GET      - PUT         - DELETE

@RestController
@RequestMapping (path="/usuarios/")
public class UsuariosController {
	private final UsuariosServices usuariosServices;

	@Autowired
	public UsuariosController(UsuariosServices usuariosServices) {
		this.usuariosServices = usuariosServices;
	}//constructor
	
	@GetMapping
	public List<Usuarios> GetAllUsuarios(){
		return usuariosServices.getAllUsuarios();
	}//getAllUsers
	
	@GetMapping(path="{userId}")
	public Usuarios getUsuarios(@PathVariable("userId") Long id) {
		return usuariosServices.getUsuarios(id);
	}//getUser
	
	@DeleteMapping(path="{userId}")
	public Usuarios deleteUsuarios(@PathVariable("userId") Long id) {
		return usuariosServices.deleteUsuarios(id);
	}//deleteUser
	
	@PostMapping
	public Usuarios addUsuarios(@RequestBody Usuarios usuarios) {
		return usuariosServices.addUsuarios(usuarios);
	}//addUser
	
	//   DTO  DATA Transfer Object	
	@PutMapping(path="{userId}")
	public Usuarios updateUsuarios(@PathVariable("userId") Long id,
			@RequestBody CambioContrasena cambioContrasena) {
		return usuariosServices.updateUsuarios(id, cambioContrasena);
	}//updateUser
	
	
}//UsuariosController
