package ar.com.cultivo.services;

import ar.com.cultivo.entities.Cosechas;
import ar.com.cultivo.entities.Venta;

import java.time.LocalDate;
import java.util.List;

public interface IVentasServices {
    List<Venta> getAll();

    Venta get(Integer id);

    void save(Venta entity);

    String delete(Venta entity);
    List<Venta> findByCompradorAndFechaBetween(Integer codigoComprador, LocalDate desde, LocalDate hasta);



}




