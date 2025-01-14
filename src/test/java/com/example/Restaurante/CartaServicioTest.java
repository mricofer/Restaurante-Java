package com.example.Restaurante;

import com.example.Restaurante.models.Carta;
import com.example.Restaurante.models.Plato;
import com.example.Restaurante.repositories.CartaRepositorio;
import com.example.Restaurante.repositories.PlatoRepositorio;
import com.example.Restaurante.services.CartaServicio;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureTestDatabase
public class CartaServicioTest {

    @Autowired
    private CartaServicio servicio;

    @Autowired
    private CartaRepositorio repositorioCarta;

    @Autowired
    private PlatoRepositorio repositorioPlato;

    @BeforeEach
    public void inicializarDatos(){
        Carta c1 = new Carta();
        c1.setPrecioTotal(10.0);
        c1.setPlatoId(1);
        c1.setTipoComidaId(1);

        repositorioCarta.save(c1);

        Plato p1 = new Plato();
        p1.setCategoria(null);
        p1.setIngrediente("Pollo");
        p1.setPrecioBase(10.0);
        p1.setNombrePlato("Pollo con papas");

        repositorioPlato.save(p1);
    }

    @Test
    public void TestModificarPrecioNegativo(){
        //GIVEN
        //WHEN
        //THEN
        Exception exception = assertThrows(Exception.class, ()-> servicio.modificarPrecio(1, -10.0));
        assertEquals("El precio no puede ser negativo.", exception.getMessage());
    }

    @Test
    public void TestModificarPrecioPositivo(){
        //GIVEN

        //WHEN
        Carta carta = servicio.modificarPrecio(1, 20.0);
        //THEN
        assertEquals(20.0, carta.getPrecioTotal());
    }

}
