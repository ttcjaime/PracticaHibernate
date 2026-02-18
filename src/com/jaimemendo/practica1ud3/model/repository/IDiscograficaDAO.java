package com.jaimemendo.practica1ud3.model.repository;
import com.jaimemendo.practica1ud3.model.entity.Discografica;

import java.util.List;

public interface IDiscograficaDAO {

    Discografica add(Discografica discografica);
    boolean delete(Discografica discografica);
    boolean update(Discografica discografica);
    List<Discografica> showAll();
    Discografica getOne(String name);

}
