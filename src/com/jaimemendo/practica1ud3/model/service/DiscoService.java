package com.jaimemendo.practica1ud3.model.service;

import com.jaimemendo.practica1ud3.model.data.DiscoDAO;
import com.jaimemendo.practica1ud3.model.entity.Disco;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.util.List;

public class DiscoService {

    private DiscoDAO discoDao = new DiscoDAO();

    public Disco addDisco(Disco disco) {
        return discoDao.add(disco);
    }

    public void deleteDisco(Disco disco) {
        try {
            discoDao.delete(disco);
        } catch (PersistenceException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new IllegalStateException("NO_SE_PUEDE_ELIMINAR");
            }
            throw e;
        }
    }

    public void updateDisco(Disco disco) {
        discoDao.update(disco);
    }

    public List<Disco> showAllDisco() {
        return discoDao.showAll();
    }

    public Disco showOneDisco(String name) {
        return discoDao.getOne(name);
    }

    public Disco getIdDisco(int idDisco) {
        return discoDao.getId(idDisco);
    }

}
