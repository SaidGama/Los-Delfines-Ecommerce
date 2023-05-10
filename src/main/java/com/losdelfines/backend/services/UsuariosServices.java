package com.losdelfines.backend.services;

import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.losdelfines.backend.models.Usuarios;

@Service
public class UsuariosServices {
    private final ArrayList<Usuarios> lista = new ArrayList<>();
    @Autowired
    public UsuariosServices() {
    	lista.add(new Usuarios ("Miguel Montes de Oca", "mickey@gmail.com", "Bilbao, Iztapalapa, CDMX", "Parangaricutirimicuaro", "5556575859"));
    	lista.add(new Usuarios ("Manuel Amaya", "manu@gmail.com", "Yucaltepen, Merida, Yucatán", "Password", "5560616263"));
    	lista.add(new Usuarios ("Said Gama", "said@gmail.com", "Ecatepec", "Contraseña", "5570717273"));
    }//constructor
    
    public ArrayList<Usuarios> getAllUsuarios(){
    	return lista;	
    	}//getAllUsuarios
    
    public Usuarios getUsuarios(Long id) {
    	Usuarios tmpUser=null;
		for (Usuarios usuarios:lista) {//recorre los usuarios de la lista
			if (usuarios.getId()==id) {
				return usuarios;
			}//if
		}//for
		return tmpUser;
    }//getUsuarios
    
    public Usuarios deleteUsuarios(Long id) {
    	Usuarios tmpUser=null;
		for (Usuarios usuarios:lista) {//recorre los usuarios de la lista
			if (usuarios.getId()==id) {
				tmpUser = lista.remove(lista.indexOf(usuarios));
				break;
			}//if
		}//for
		return tmpUser;
	}//deleteUsuarios

	public Usuarios addUsuarios(Usuarios usuarios) {
		lista.add(usuarios);
		return usuarios;
	}//addUsuarios

	public Usuarios updateUsuarios(Long id, String nombre, String correo, String domicilio, String contraseña, String telefono) {
		Usuarios tmpUser = null;
		for (Usuarios usuarios:lista) {
			if (usuarios.getId()==id) {
				if (nombre!=null) usuarios.setNombre(nombre);
				if (correo!=null) usuarios.setCorreo(correo);
				if (domicilio!=null) usuarios.setDomicilio(domicilio);
				if (contraseña!=null) usuarios.setContraseña(contraseña);
				if (telefono!=null) usuarios.setTelefono(contraseña);
				tmpUser=usuarios;
				break;
			}//if
		}//for
		return tmpUser;
	}//updateUsuarios
    
}//class UsuariosServices