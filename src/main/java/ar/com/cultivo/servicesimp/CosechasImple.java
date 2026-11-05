package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.ICosechasDao;
import ar.com.cultivo.entities.Cosechas;
import ar.com.cultivo.entities.Cultivos;
import ar.com.cultivo.services.ICosechasServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CosechasImple implements ICosechasServices {
    @Autowired
    private ICosechasDao entityDao;

    @Override
    public List<Cosechas> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "fecha")
        );
    }

    public Cosechas get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Cosechas entity) {
        entityDao.save(entity);
    }


    public String delete(Cosechas entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }

    }
    public List<Cosechas> findByPlantacion(Integer idPlantacion) {
        return entityDao.findByPlantacion(idPlantacion);
    }
}
