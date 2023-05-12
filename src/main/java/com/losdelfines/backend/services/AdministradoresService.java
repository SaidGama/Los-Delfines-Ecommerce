package com.losdelfines.backend.services;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import com.losdelfines.backend.models.Administradores;
import com.losdelfines.backend.models.CambioContrasena;
import com.losdelfines.backend.repositories.AdministradoresRepository;

@Service
public class AdministradoresService {
	public final AdministradoresRepository administradoresRepository;
	@Autowired
	public AdministradoresService(AdministradoresRepository administradoresRepository) {
		this.administradoresRepository = administradoresRepository;
	}//constructor
	
	@GetMapping
	public List<Administradores> getAllAdministradores(){
		return administradoresRepository.findAll();
	}//todos los administradores
	
	public Administradores getAdministradores(Long id) {
		return administradoresRepository.findById(id).orElseThrow(
				() -> new IllegalArgumentException("Administrador con id " + id +" no existe.")
				);
	}//getAdmi
    
	public Administradores deleteAdministradores(long id) {
		 Administradores tmpAdministradores = null;
		 if(administradoresRepository.existsById(id)) {
			 tmpAdministradores=administradoresRepository.findById(id).get();
			 administradoresRepository.deleteById(id);
		 }//if
		 return tmpAdministradores;
	 }//deleteadmistradores
	
	 public Administradores addAdministradores(Administradores administrador) {
		 Administradores tmpAdministradores=null;
		 if (administradoresRepository.findByCorreo(administrador.getCorreo()).isEmpty()) {
			 tmpAdministradores = administradoresRepository.save(administrador);
		 }//if
		 return tmpAdministradores;
	 }//agregar Administrador
	 
	 public Administradores updateAdministrador(Long id,CambioContrasena cambioContrasena) {
		 Administradores tmpAdministradores = null;
			 if (administradoresRepository.existsById(id)) { //si existe
				 if ( (cambioContrasena.getContrasena() !=null) &&
						 (cambioContrasena.getContrasena() !=null)) { //password !null
					 tmpAdministradores = administradoresRepository.findById(id).get();
					 System.out.println(tmpAdministradores);
					 System.out.println(cambioContrasena);
					 if(tmpAdministradores.getContrasena().equals(cambioContrasena.getContrasena())) { //pasword correcto
						 tmpAdministradores.setContrasena(cambioContrasena.getNewContrasena());
						 administradoresRepository.save(tmpAdministradores);
					 } else {
						 tmpAdministradores=null;
					 }//if equals
				 }// !null
			 }else {
				 System.out.println("Update - el usuario con id " + id + " no existe");
			}//else
		 return tmpAdministradores;
	 }//updateProducto
}//AdmiServie