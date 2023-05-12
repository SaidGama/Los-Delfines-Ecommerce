package com.losdelfines.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.losdelfines.backend.models.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
}//interface CarritoRepository
