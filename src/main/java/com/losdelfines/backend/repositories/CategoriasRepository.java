package com.losdelfines.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.losdelfines.backend.models.Categorias;
import java.util.Optional;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>{
    Optional<Categorias> findByNombre(String nombre);
}