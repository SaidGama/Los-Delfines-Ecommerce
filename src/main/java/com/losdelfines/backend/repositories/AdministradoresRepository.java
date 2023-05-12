package com.losdelfines.backend.repositories;

import com.losdelfines.backend.models.Administradores;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //es un lugar donde guardo datoss
public interface AdministradoresRepository extends JpaRepository<Administradores, Long>  {
	Optional<Administradores> findByCorreo(String correo);
    
}//interface administradores repo
