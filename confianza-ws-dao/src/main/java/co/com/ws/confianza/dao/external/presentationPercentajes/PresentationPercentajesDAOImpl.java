package co.com.ws.confianza.dao.external.presentationPercentajes;

import java.util.List;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.dao.presentationPercentajes.rowMapper.PresentationPersentajesRowMapper;
import co.com.ws.confianza.model.dto.presentationPercentajes.PresentationPercentajes;

@Repository
public class PresentationPercentajesDAOImpl extends AbstractJdbcOracleRepository implements PresentationPersentajeDAO {

	private static final String BEAN_QUERIES = "queriesPresentationPercentajes";
	private static final String NITINTERMEDIARY = "NITINTERMEDIARY";
	private static final String QUERYPRESENTATIONPERCENTAJES = "QUERYPRESENTATIONPERCENTAJES";

	public PresentationPercentajesDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<PresentationPercentajes> findPresnetationPercentajes(String nitInterediary) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(NITINTERMEDIARY, nitInterediary);
		return findAllBean(QUERYPRESENTATIONPERCENTAJES, mapParameters, new PresentationPersentajesRowMapper());
	}

}
