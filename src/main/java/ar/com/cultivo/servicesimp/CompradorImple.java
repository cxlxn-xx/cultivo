package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.ICompradorDao;
import ar.com.cultivo.entities.Comprador;
import ar.com.cultivo.services.ICompradorServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompradorImple implements ICompradorServices {
    @Autowired
    private ICompradorDao entityDao;

    @Override
    public List<Comprador> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "nombre")
        );
    }

    public List<Comprador> findByNombre(String nombre) {
        return entityDao.findByNombre("%" + nombre + "%");
    }


    public Comprador get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Transactional
    public void save(Comprador entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Comprador entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
