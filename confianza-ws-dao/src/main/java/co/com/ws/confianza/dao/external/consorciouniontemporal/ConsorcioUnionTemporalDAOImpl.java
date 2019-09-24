package co.com.ws.confianza.dao.external.consorciouniontemporal;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import co.com.ws.confianza.dao.consorciout.rowmapper.ConsorcioUnionTemporalRowMapper;
import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

@Repository
public class ConsorcioUnionTemporalDAOImpl extends AbstractJdbcOracleRepository implements ConsorcioUnionTemporalDAO {

	private static final String BEAN_QUERIES = "queriesConsorcioUnionTemporal";
	private static final String FIND_CONSORCIOS_UT = "FIND_CONSORCIOS_UT";
	private static final String CODEINTERMEDIARY = "CODEINTERMEDIARY";
	private static final String CER_FECHA_HASTA = "CER_FECHA_HASTA";

	public ConsorcioUnionTemporalDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<ConsorcioTemporalesDTO> findClientesConsorcioTemporal(String cliente, String fecha) {
		MapSqlParameterSource mapParametersClientes = new MapSqlParameterSource();
		mapParametersClientes.addValue(CODEINTERMEDIARY, cliente);
		if (fecha != null && !fecha.isEmpty()) {
			mapParametersClientes.addValue(CER_FECHA_HASTA, fecha);
		} else {
			mapParametersClientes.addValue(CER_FECHA_HASTA, "01/01/2019");
		}
		return findAllBean(FIND_CONSORCIOS_UT, mapParametersClientes, new ConsorcioUnionTemporalRowMapper());
	}
}
