package com.example.Restaurante.repositories;

import com.example.Restaurante.models.PedidoDetalles;
import com.example.Restaurante.models.TipoComida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TipoComidaRepositorio extends JpaRepository<TipoComida, Integer> {
}
