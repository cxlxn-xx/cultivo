package ar.com.cultivo.services;

import ar.com.cultivo.entities.Lote;

import java.util.List;

public interface ILotesServices {
    List<Lote> getAll();

    List<Lote> findByDescrip(String descripcion);

    Lote get(Integer id);

    void save(Lote entity);

    String delete(Lote entity);
}
