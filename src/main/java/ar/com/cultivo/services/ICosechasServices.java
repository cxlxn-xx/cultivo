package ar.com.cultivo.services;

import ar.com.cultivo.entities.Comprador;
import ar.com.cultivo.entities.Cosechas;
import ar.com.cultivo.entities.Cultivos;

import java.util.List;

public interface ICosechasServices {
    List<Cosechas> getAll();


    Cosechas get(Integer id);

    void save(Cosechas entity);

    String delete(Cosechas entity);

}
