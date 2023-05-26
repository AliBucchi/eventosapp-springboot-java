package com.eventoapp.repository;

import com.eventoapp.models.Evento;
import org.springframework.data.repository.CrudRepository;

public interface EventoRepository extends CrudRepository <Evento, String> {
    Evento findByCodigo(long codigo);  //interface Spring para operação CRUD genericas em um repositorio de um tipo especifico
                                                                            //oferece varios prontos ara interagir com um banco de dados.

}
