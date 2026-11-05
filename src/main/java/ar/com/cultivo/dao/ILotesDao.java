package ar.com.cultivo.dao;

import ar.com.cultivo.entities.Lote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ILotesDao extends JpaRepository<Lote, Integer> {
@Query("select l from Lote l where l.descripcion like ?1")
    public List<Lote> findByDescripcion(String string);

}
