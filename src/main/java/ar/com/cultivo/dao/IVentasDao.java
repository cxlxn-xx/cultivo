package ar.com.cultivo.dao;

import ar.com.cultivo.entities.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface IVentasDao extends JpaRepository<Venta, Integer> {

    // Etapa 2 - Consulta 4
    @Query("select v from Venta v where v.comprador.codigo = ?1 and v.fecha between ?2 and ?3")
    List<Venta> findByCompradorAndFechaBetween(Integer codigoComprador, LocalDate desde, LocalDate hasta);
    // Etapa 2 - Consulta 5
    @Query("select sum(v.cantidadVendida * v.precioUnitario) from Venta v where v.comprador.codigo = ?1 and v.fecha between ?2 and ?3")
    public Double totalByCompradorAndFechaBetween(Integer codigoComprador, LocalDate desde, LocalDate hasta);

}


