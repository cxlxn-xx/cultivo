package ar.com.cultivo.servicesimp;

import ar.com.cultivo.dao.IVentasDao;

import ar.com.cultivo.entities.Venta;
import ar.com.cultivo.services.IVentasServices;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class VentasImple implements IVentasServices {
    @Autowired
    private IVentasDao entityDao;

    @Override
    public List<Venta> getAll() {
        return entityDao.findAll(Sort.by(Sort.Direction.ASC, "fecha"));
    }

    @Override
    public Venta get(Integer id) {
        return entityDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public void save(Venta entity) {
        entityDao.save(entity);
    }

    @Override
    @Transactional
    public String delete(Venta entity) {
        try {
            entityDao.delete(entity);
            return null;
        } catch (Exception e) {
            return e.getMessage().toString();
        }
    }

    public List<Venta> findByCompradorAndFechaBetween(Integer codigoComprador,
                                                      LocalDate desde, LocalDate hasta) {
        return entityDao.findByCompradorAndFechaBetween(codigoComprador, desde, hasta);
    }
}
