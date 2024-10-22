package com.example.Restaurante.repositories;

import com.example.Restaurante.models.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormaPagoRepositorio extends JpaRepository<FormaPago, Integer> {
}
