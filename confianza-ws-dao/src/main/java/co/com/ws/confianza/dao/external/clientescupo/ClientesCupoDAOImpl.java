package co.com.ws.confianza.dao.external.clientescupo;

import java.util.List;

import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;
import co.com.ws.confianza.dao.clientescupo.rowmapper.ClientesCuposRowmapper;
import co.com.ws.confianza.dao.clientescupo.rowmapper.PolizasRowmapper;
import co.com.ws.confianza.dao.external.AbstractJdbcOracleRepository;
import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;
import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

@Repository
public class ClientesCupoDAOImpl extends AbstractJdbcOracleRepository implements ClientesCupoDAO {
	
	private static final String BEAN_QUERIES = "queriesClientesCupo";
	private static final String FIND_TUS_CLIENTES = "FIND_TUS_CLIENTES";
	private static final String FKINTERMEDIARIO = "FKINTERMEDIARIO";
	private static final String FECHAHASTA = "FECHAHASTA";
	private static final String FECHADESDE = "FECHADESDE";
	private static final String FIND_POLIZAS = "FIND_POLIZAS";
	private static final String VALIDATION_POLIZAS = "VALIDATION_POLIZAS";

	public ClientesCupoDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<PolizasClienteCupoDTO> findPolizas(String codigo, String fechaDesde, String fechaHasta,
			String cerFkTecnica, String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza,
			String cerNumCertificado) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		mapParameters.addValue(FKINTERMEDIARIO, codigo);
		mapParameters.addValue(FECHAHASTA, fechaHasta);
		mapParameters.addValue(FECHADESDE, fechaDesde);
		mapParameters.addValue(VALIDATION_POLIZAS, stringQueryValidation(cerFkTecnica, cerFkRangoValorAsegurado,
				cerFkGeografica, cerNumPoliza, cerNumCertificado));
		return findAllBean(FIND_POLIZAS, mapParameters, new PolizasRowmapper());
	}

	@Override
	public List<ClientesCupoDTO> findClientesCupos(String cliente, String fecha) {
		MapSqlParameterSource mapParametersClientes = new MapSqlParameterSource();
		mapParametersClientes.addValue(FKINTERMEDIARIO, cliente);
		return findAllBean(FIND_TUS_CLIENTES, mapParametersClientes, new ClientesCuposRowmapper());
	}

	public String stringQueryValidation(String cerFkTecnica, String cerFkRangoValorAsegurado, String cerFkGeografica,
			String cerNumPoliza, String cerNumCertificado) {
		StringBuilder string = new StringBuilder();
		if (cerFkTecnica != null) {
			string.append(" AND A.CER_FK_TECNICA = " + cerFkTecnica);
		}
		if (cerFkRangoValorAsegurado != null) {
			string.append(" AND A.CER_FK_RANGOVLRASEGURADO = " + cerFkRangoValorAsegurado);
		}
		if (cerFkGeografica != null) {
			string.append(" AND A.CER_FK_GEOGRAFICA = " + cerFkGeografica);
		}
		if (cerNumCertificado != null) {
			string.append(" AND A.CER_NUM_CERTIFICADO = " + cerNumCertificado);
		}
		if (cerNumPoliza != null) {
			string.append(" AND A.CER_NUM_POLIZA = " + cerNumPoliza);
		}
		return string.toString();
	}
}
