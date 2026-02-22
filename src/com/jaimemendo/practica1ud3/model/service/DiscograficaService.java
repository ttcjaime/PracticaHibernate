package com.jaimemendo.practica1ud3.model.service;

import com.jaimemendo.practica1ud3.model.data.DiscograficaDAO;
import com.jaimemendo.practica1ud3.model.entity.Discografica;
import org.hibernate.exception.ConstraintViolationException;

import javax.persistence.PersistenceException;
import java.util.List;

public class DiscograficaService {
    private DiscograficaDAO discograficaDAO = new DiscograficaDAO();

    public void addDiscografica(Discografica discografica) {
        discograficaDAO.add(discografica);
    }

    public void deleteDiscografica(Discografica discografica) {
        try {
            discograficaDAO.delete(discografica);
        } catch (PersistenceException e) {
            if (e.getCause() instanceof ConstraintViolationException) {
                throw new IllegalStateException("NO_SE_PUEDE_ELIMINAR");
            }
            throw e;
        }
    }

    public void updateDiscografica(Discografica discografica) {
        discograficaDAO.update(discografica);
    }

    public List<Discografica> showAllDiscograficas() {
        return discograficaDAO.showAll();
    }

    public Discografica showOneDiscografica(String name) {
        return discograficaDAO.getOne(name);
    }

}
