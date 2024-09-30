package com.example.restaurante.repositories;

import com.example.restaurante.models.FormaPago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormaPagoRepositorio extends JpaRepository<FormaPago, Integer> {
}
