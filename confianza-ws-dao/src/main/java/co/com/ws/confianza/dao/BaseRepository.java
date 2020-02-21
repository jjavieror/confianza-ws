package co.com.ws.confianza.dao;

import java.io.Serializable;
import java.util.List;

/**
 * Interface para los DAOS intelcostbpms de jdbctemplate.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados.
 * @version 1.0
 */
public interface BaseRepository<M> {

    List<M> findAll();

    M findById(Serializable id);

    M save(M model);

    void update(M model);

    void delete(M model);

}
