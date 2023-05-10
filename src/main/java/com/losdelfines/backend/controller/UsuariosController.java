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
import com.losdelfines.backend.models.Usuarios;
import com.losdelfines.backend.services.UsuariosServices;

//CRUD     Create    - Read     - Update      - Delete
//HTTP     POST      - GET      - PUT         - DELETE

@RestController
@RequestMapping (path="/api/usuarios/")
public class UsuariosController {
	private final UsuariosServices usuariosServices;

	@Autowired
	public UsuariosController(UsuariosServices usuariosServices) {
		this.usuariosServices = usuariosServices;
	}//constructor
	
	@GetMapping
	public List<Usuarios> GetAllUsers(){
		return usuariosServices.getAllUsuarios();
	}//getAllUsers
	
	@GetMapping(path="{userId}")
	public Usuarios getUser(@PathVariable("userId") Long id) {
		return usuariosServices.getUsuarios(id);
	}//getUser
	
	@DeleteMapping(path="{userId}")
	public Usuarios deleteUser(@PathVariable("userId") Long id) {
		return usuariosServices.deleteUsuarios(id);
	}//deleteUser
	
	@PostMapping
	public Usuarios addUser(@RequestBody Usuarios usuarios) {
		return usuariosServices.addUsuarios(usuarios);
	}//addUser
	
	@PutMapping(path="{userId}")
	public Usuarios updateUser(@PathVariable("userId") Long id,
			@RequestParam(required = false) String nombre,
			@RequestParam(required = false) String correo,
			@RequestParam(required = false) String domicilio,
			@RequestParam(required = false) String contraseña,
			@RequestParam(required = false) String telefono) {
		return usuariosServices.updateUsuarios(id, nombre, correo, domicilio, contraseña, telefono);
	}//updateUser
	
	
}//UsuariosController
