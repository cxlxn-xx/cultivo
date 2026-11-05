package ar.com.cultivo.services;

import ar.com.cultivo.entities.Plantacion;

import java.time.LocalDate;
import java.util.List;

public interface IPlantacionServices {
    List<Plantacion> getAll();

    Plantacion get(Integer id);

    void save(Plantacion entity);

    String delete(Plantacion entity);

    List<Plantacion> findByPeriodo(String periodo);

    List<Plantacion> findByPeriodoAndCultivos(String periodo, Integer codigo);

    List<Plantacion> findByFechaBetween(LocalDate desde, LocalDate hasta);
}
