package ar.com.cultivo.services;

import ar.com.cultivo.entities.Cultivos;

import java.util.List;
import java.util.Optional;

public interface ICultivosServices {
    List<Cultivos> getAll();
    List<Cultivos> findByDescrip(String descrip);
    Cultivos get(Integer id);
    void save(Cultivos entity);
    String delete(Cultivos entity);


}


