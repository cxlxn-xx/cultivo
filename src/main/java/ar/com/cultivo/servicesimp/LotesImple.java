package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.ILotesDao;
import ar.com.cultivo.entities.Lote;
import ar.com.cultivo.services.ILotesServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LotesImple implements ILotesServices {
    @Autowired
    private ILotesDao entityDao;

    @Override
    public List<Lote> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "descripcion")
        );
    }
    @Override
    public List<Lote> findByDescrip(String descripcion) {
        return entityDao.findByDescripcion("%" + descripcion + "%");
    }

    @Override
    public Lote get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }
    @Override
    @Transactional
    public void save(Lote entity) {
        entityDao.save(entity);
    }

    @Override

    public String delete(Lote entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }
}
