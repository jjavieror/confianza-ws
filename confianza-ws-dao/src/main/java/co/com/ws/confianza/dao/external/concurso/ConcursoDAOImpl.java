package co.com.ws.confianza.dao.external.concurso;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import co.com.ws.confianza.dao.AbstractJdbcOracleRepository;
import co.com.ws.confianza.dao.concurso.rowmapper.ConcursoRowMapper;
import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

@Repository
public class ConcursoDAOImpl extends AbstractJdbcOracleRepository implements ConcursoDAO {

	private static final String BEAN_QUERIES = "queriesConcursos";
	private static final String FIND_CONCURSOS = "FIND_CONCURSOS";
	private static final String NITAGENTE = "NITAGENTE";

	public ConcursoDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<ConcursoDTO> findConcurso(String nitIntermediario) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(NITAGENTE, nitIntermediario);
		return findAllBean(FIND_CONCURSOS, mapParameters, new ConcursoRowMapper());
	}
}
