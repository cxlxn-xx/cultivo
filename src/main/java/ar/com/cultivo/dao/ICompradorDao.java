package ar.com.cultivo.dao;

import ar.com.cultivo.entities.Comprador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICompradorDao extends JpaRepository<Comprador, Integer> {
@Query("select c from Comprador c where c.nombre like ?1 ")
    public List<Comprador>findByNombre(String string);
}
