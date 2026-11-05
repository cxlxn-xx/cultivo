package ar.com.cultivo.dao;
import ar.com.cultivo.entities.Gasto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IGastosDao extends JpaRepository<Gasto, Integer> {
    @Query("select g from Gasto g where g.plantacion.id = ?1")
    public List<Gasto> findByPlantacion(Integer idPlantacion);
}