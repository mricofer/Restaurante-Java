package com.example.Restaurante.services;

import com.example.Restaurante.models.FormaPago;
import com.example.Restaurante.repositories.FormaPagoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FormaPagoServicio {
    @Autowired
    private FormaPagoRepositorio formaPagoRepositorio;

    /**
     * Buscar todas las formas de pago
     */

    public List<FormaPago> getFormasPago() {
        return formaPagoRepositorio.findAll();
    }

    /**
     * Buscar una forma de pago por id
     *
     * @param id
     * @return
     */

    public FormaPago getFormaPagoById(Integer id) {
        return formaPagoRepositorio.findById(id).orElse(null);
    }

    /**
     * Crear una forma de pago o modificar una existente
     *
     * @param formaPago
     * @return
     */

    public FormaPago crearFormaPago(FormaPago formaPago) {
        return formaPagoRepositorio.save(formaPago);
    }

    /**
     * Eliminar una forma de pago
     *
     * @param formaPago
     */

    public void eliminarFormaPago(FormaPago formaPago) {
        formaPagoRepositorio.delete(formaPago);
    }
}
