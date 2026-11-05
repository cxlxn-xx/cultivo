package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.IGastosDao;
import ar.com.cultivo.entities.Gasto;
import ar.com.cultivo.services.IGastosServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GastoImple implements IGastosServices {
    @Autowired
    private IGastosDao entityDao;

    @Override
    public List<Gasto> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "fecha")
        );
    }

    public Gasto get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Gasto entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Gasto entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public List<Gasto> findByPlantacion(Integer idPlantacion) {
        return entityDao.findByPlantacion(idPlantacion);
    }
}