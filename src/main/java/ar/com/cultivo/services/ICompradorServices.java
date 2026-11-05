package ar.com.cultivo.services;

import ar.com.cultivo.entities.Comprador;

import java.util.List;

public interface ICompradorServices {

    List<Comprador> getAll();
    List<Comprador> findByNombre(String nombre);
    Comprador get(Integer id);
    void save(Comprador entity);
    String delete(Comprador entity);
}
