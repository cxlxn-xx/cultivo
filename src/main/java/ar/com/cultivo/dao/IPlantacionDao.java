package ar.com.cultivo.dao;

import ar.com.cultivo.entities.Plantacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface IPlantacionDao extends JpaRepository<Plantacion, Integer> {
    @Query("select p from Plantacion p where p.periodo = ?1")
    List<Plantacion> findByPeriodo(String periodo);
    @Query("select p from Plantacion p where p.fechaPlantacion between ?1 and ?2")
    List<Plantacion> findByFechaPlantacionBetween(LocalDate desde, LocalDate hasta);
    @Query("select p from Plantacion p where p.periodo = ?1 and p.cultivo.codigo = ?2")
    List<Plantacion> findByPeriodoAndCultivos(String periodo, Integer codigoCultivos);

}
