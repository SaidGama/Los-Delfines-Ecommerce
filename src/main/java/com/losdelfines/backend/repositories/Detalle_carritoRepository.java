package com.losdelfines.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.losdelfines.backend.models.Detalle_carrito;

@Repository
public interface Detalle_carritoRepository extends JpaRepository<Detalle_carrito, Long> {
    
}//interface Detalle_carritoRepository
