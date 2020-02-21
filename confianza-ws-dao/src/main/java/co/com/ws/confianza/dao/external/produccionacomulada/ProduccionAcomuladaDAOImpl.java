package co.com.ws.confianza.dao.external.produccionacomulada;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.dao.produccionAcomulada.rowmapper.ProduccionAcomuladaRowMapper;
import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;

@Repository
public class ProduccionAcomuladaDAOImpl extends AbstractJdbcOracleRepository implements ProduccionAcomuladaDAO {
	private static final String BEAN_QUERIES = "queriesProduccionAcomulada";
	private static final String NITPRODUCTION = "NITPRODUCTION";
	private static final String FIND_PRODUCTION_ACOM = "FIND_PRODUCTION_ACOM";

	public ProduccionAcomuladaDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<ProduccionAcomuladaDTO> findProduccionAcomulada(String nit) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(NITPRODUCTION, nit);
		return findAllBean(FIND_PRODUCTION_ACOM, mapParameters, new ProduccionAcomuladaRowMapper());
	}
}