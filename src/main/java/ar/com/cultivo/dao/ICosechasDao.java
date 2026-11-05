package ar.com.cultivo.dao;

import ar.com.cultivo.entities.Cosechas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface ICosechasDao extends JpaRepository <Cosechas, Integer> {
    @Query("select c from Cosechas c where c.plantacion.id = ?1")
    public List<Cosechas> findByPlantacion(Integer idPlantacion);
}
