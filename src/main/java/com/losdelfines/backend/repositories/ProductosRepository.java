package com.losdelfines.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.losdelfines.backend.models.Productos;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
    
}
