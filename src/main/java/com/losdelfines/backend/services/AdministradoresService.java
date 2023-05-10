package com.losdelfines.backend.services;
import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.losdelfines.backend.models.Administradores;

@Service
public class AdministradoresService {
	public final ArrayList<Administradores> lista = new ArrayList<>();
	
	public AdministradoresService() {
		lista.add(new Administradores( "Said Gama", "said.gama@gmail.com", "said123contrasena"));
		lista.add(new Administradores("Ariadna Islas", "jaz.islasg@gmail.com", "lacontrasenaes1234"));
		lista.add(new Administradores("Manuel Amaya", "manuchan@gmail.com", "sequepuedovolar1233"));
		
	}//listadd
	public ArrayList<Administradores> getAllAdministradores(){
		return lista;
	}//todos los administradores
	public Administradores getAdministradores(Long id) {
		Administradores tmpAdministradores = null;
		for (Administradores administradores : lista) {
			if (administradores.getId() ==id) {
				tmpAdministradores = administradores;
			}//getAdmi
		}//for
		return tmpAdministradores;
	}//arraylist
    
	public Administradores deleteAdministradores(long id) {
		 Administradores tmpAdministradores = null;
		 for (Administradores administrador : lista) {
			 if (administrador.getId()==id) {
				 tmpAdministradores = lista.remove(lista.indexOf(administrador));
				 break;
			 }//if
		 }//foreach
		 return tmpAdministradores;
	 }//deleteadmi
	
	///
	 public Administradores addAdministradores(Administradores administrador) {
		 lista.add(administrador);
		 return administrador;
	 }//agregar Admi
	 
	 public Administradores updateAdministrador(Long id,String nombre, String correo, String contrasena) {
		 Administradores tmpAdministradores = null;
		 for (Administradores administrador : lista) {
			 if (administrador.getId()==id) {
				 if (nombre!=null) administrador.setNombre(nombre);
				 if (correo!=null) administrador.setCorreo(correo);
				 if (contrasena!=null) administrador.setContrasena(contrasena);
				 tmpAdministradores=administrador;
				 break;
			 }//if
		 }//foreach
		 return tmpAdministradores;
	 }//updateProducto
}//AdmiServie
