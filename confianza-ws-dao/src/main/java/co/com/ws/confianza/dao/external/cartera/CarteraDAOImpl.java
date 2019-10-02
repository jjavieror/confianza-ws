package co.com.ws.confianza.dao.external.cartera;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import co.com.ws.confianza.dao.cartera.rowmapper.CarteraRowMapper;
import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

@Repository
public class CarteraDAOImpl extends AbstractJdbcOracleRepository implements CarteraDAO {
	
	private static final String BEAN_QUERIES = "queriesCartera";
	private static final String CODEFIND = "CODEFIND";
	private static final String FIND_CARTERA = "FIND_CARTERA";

	public CarteraDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<CarteraDTO> findCartera(String code) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(CODEFIND, code);
		return findAllBean(FIND_CARTERA, mapParameters, new CarteraRowMapper());
	}
}