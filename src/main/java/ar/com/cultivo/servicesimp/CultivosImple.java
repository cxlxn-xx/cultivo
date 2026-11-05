package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.ICultivosDao;
import ar.com.cultivo.entities.Cultivos;
import ar.com.cultivo.services.ICultivosServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public  class CultivosImple implements ICultivosServices {
    @Autowired
    private ICultivosDao entityDao;


    public List<Cultivos> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "descripcion")) ;   }


    public List<Cultivos> findByDescrip(String descripcion) {
        return entityDao.findByDescripcion("%" + descripcion+ "%");
    }


    public Cultivos get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Cultivos entity) {
        entityDao.save(entity);
    }


    public String delete(Cultivos entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return "No se puede eliminar porque tiene registros asociados.";
        }
    }
}