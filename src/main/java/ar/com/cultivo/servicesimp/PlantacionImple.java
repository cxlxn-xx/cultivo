package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.IPlantacionDao;
import ar.com.cultivo.entities.Plantacion;
import ar.com.cultivo.services.IPlantacionServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class PlantacionImple implements IPlantacionServices {
    @Autowired
    private IPlantacionDao entityDao;

    public List<Plantacion> getAll() {
        return entityDao.findAll(
                Sort.by(Sort.Direction.ASC, "periodo")
        );
    }
    public Plantacion get(Integer id) {
        return  entityDao.findById(id).orElse(null);
    }


    @Transactional
    public void save(Plantacion entity) {
        entityDao.save(entity);
    }

    @Transactional
    public String delete(Plantacion entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public List<Plantacion> findByPeriodoAndCultivos(String periodo, Integer codigoCultivos) {
        return entityDao. findByPeriodoAndCultivos(periodo, codigoCultivos);
    }

    public List<Plantacion> findByPeriodo(String periodo) {
        return entityDao.findByPeriodo(periodo);

    }
    public List<Plantacion> findByFechaBetween(LocalDate desde, LocalDate hasta) {
        return entityDao.findByFechaPlantacionBetween(desde, hasta);
    }
}
