package co.com.ws.confianza.dao.external.concurso;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import co.com.ws.confianza.dao.concurso.rowmapper.ConcursoRowMapper;
import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

@Repository
public class ConcursoDAOImpl extends AbstractJdbcOracleRepository implements ConcursoDAO {

	private static final String BEAN_QUERIES = "queriesConcursos";
	private static final String FIND_CONCURSOS = "FIND_CONCURSOS";
	private static final String NITAGENTE = "NITAGENTE";
	private static final String PARAMSLIKE = "PARAMSLIKE";

	public ConcursoDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<ConcursoDTO> findConcurso(String nitIntermediario, String typeName) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(NITAGENTE, nitIntermediario);
		System.out.println("---------------->    Numero" + typeName + "-------------->" + typeName.equals(typeName));
		if(typeName.equals("1")) {
			mapParameters.addValue(PARAMSLIKE, "%CONCUR%");
		}else {
			mapParameters.addValue(PARAMSLIKE, "%CONVEN%");
		}
		return findAllBean(FIND_CONCURSOS, mapParameters, new ConcursoRowMapper());
	}
}
