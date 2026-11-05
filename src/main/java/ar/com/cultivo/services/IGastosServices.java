package ar.com.cultivo.services;

import ar.com.cultivo.entities.Gasto;

import java.util.List;

public interface IGastosServices {
    List<Gasto> getAll();

    Gasto get(Integer id);

    void save(Gasto entity);

    String delete(Gasto entity);

}
