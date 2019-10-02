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

	public ClientesCupoDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<PolizasClienteCupoDTO> findPolizas(String codigo, String fechaDesde, String fechaHasta,
			String cerFkTecnica, String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza,
			String cerNumCertificado) {
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		System.out.println(queryPolizas(codigo, fechaDesde, fechaHasta, cerFkTecnica, cerFkRangoValorAsegurado,
				cerFkGeografica, cerNumPoliza, cerNumCertificado));
		return findAllBeanString(queryPolizas(codigo, fechaDesde, fechaHasta, cerFkTecnica, cerFkRangoValorAsegurado,
				cerFkGeografica, cerNumPoliza, cerNumCertificado), mapParameters, new PolizasRowmapper());
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
			string.append(" AND A.CER_FK_TECNICA = '" + cerFkTecnica + "'");
		}
		if (cerFkRangoValorAsegurado != null) {
			string.append(" AND A.CER_FK_RANGOVLRASEGURADO = '" + cerFkRangoValorAsegurado + "'");
		}
		if (cerFkGeografica != null) {
			string.append(" AND A.CER_FK_GEOGRAFICA = '" + cerFkGeografica + "'");
		}
		if (cerNumCertificado != null) {
			string.append(" AND A.CER_NUM_CERTIFICADO = '" + cerNumCertificado + "'");
		}
		if (cerNumPoliza != null) {
			string.append(" AND A.CER_NUM_POLIZA = '" + cerNumPoliza + "'");
		}
		System.out
				.println(cerFkTecnica + cerFkRangoValorAsegurado + cerFkGeografica + cerNumCertificado + cerNumPoliza);
		System.out.println("QUERY-STRING----------------------->" + string.toString());
		return string.toString();
	}

	public String queryPolizas(String codigo, String fechaDesde, String fechaHasta, String cerFkTecnica,
			String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza, String cerNumCertificado) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT CAST(H.TEC_RAMO_DESC AS VARCHAR2(100))\n" + "						AS\n"
				+ "						TEC_RAMO_DESC,\n" + "						CAST(A.CER_NUM_POLIZA AS\n"
				+ "						VARCHAR2(100)) AS\n" + "						CER_NUM_POLIZA,\n"
				+ "						CAST(A.CER_NUM_CERTIFICADO AS\n" + "						VARCHAR2(100)) AS\n"
				+ "						CER_NUM_CERTIFICADO,\n" + "						C.PER_PERSONA\n"
				+ "						AS\n" + "						CPER_PERSONA,\n"
				+ "						C.PER_PERSONA_NOMBRE AS CPER_PERSONA_NOMBRE,\n"
				+ "						E.PER_PERSONA AS\n" + "						EPER_PERSONA,\n"
				+ "						E.PER_PERSONA_NOMBRE AS\n" + "						EPER_PERSONA_NOMBRE,\n"
				+ "						G.PER_PERSONA AS GPER_PERSONA,\n"
				+ "						G.PER_PERSONA_NOMBRE AS\n" + "						GPER_PERSONA_NOMBRE,\n"
				+ "						A.CER_FECHA_DESDE,\n" + "						A.CER_FECHA_HASTA,\n"
				+ "						A.CER_PRIMA_EMIT,\n" + "						CAST(A.CER_VALOR_ASEGURADO AS\n"
				+ "						VARCHAR2(100)) AS\n" + "						CER_VALOR_ASEGURADO\n"
				+ "						FROM BDG.FACT_CERTIFICADOS A\n" + "						JOIN\n"
				+ "						BDG.DIM_PERSONA_VINCULACION B ON A.CER_FK_TOMADOR = B.PERVIN_ID\n"
				+ "						JOIN BDG.DIM_PERSONA C ON B.PERVIN_CODIGO = C.PER_CODIGO AND\n"
				+ "						C.ESTADO = 'ACTIVO'\n"
				+ "						JOIN BDG.DIM_PERSONA_VINCULACION D ON\n"
				+ "						A.CER_FK_ASEGURADO = D.PERVIN_ID\n"
				+ "						JOIN BDG.DIM_PERSONA E ON\n"
				+ "						D.PERVIN_CODIGO = E.PER_CODIGO AND\n"
				+ "						E.ESTADO = 'ACTIVO'\n" + "						JOIN\n"
				+ "						BDG.DIM_PERSONA_VINCULACION F ON A.CER_FK_CLIENTE = F.PERVIN_ID\n"
				+ "						JOIN BDG.DIM_PERSONA G ON F.PERVIN_CODIGO = G.PER_CODIGO AND\n"
				+ "						G.ESTADO = 'ACTIVO'\n"
				+ "						JOIN BDG.DIM_TECNICA H ON A.CER_FK_TECNICA =\n"
				+ "						H.TEC_ID\n"
				+ "						JOIN BDG.DIM_INTERMEDIARIO I ON I.INTRM_ID =\n"
				+ "						A.CER_FK_INTERMEDIARIO\n"
				+ "						WHERE I.INTRM_INTERMEDIARIO\n" + "						='" + codigo + "' AND\n"
				+ "						A.CER_FECHA_HASTA\n" + "						>\n"
				+ "						TO_DATE('" + fechaHasta + "','mm/dd/yyyy') AND\n"
				+ "						A.CER_FECHA_DESDE <\n" + "						TO_DATE('" + fechaDesde
				+ "','mm/dd/yyyy') " + stringQueryValidation(cerFkTecnica, cerFkRangoValorAsegurado, cerFkGeografica,
						cerNumPoliza, cerNumCertificado)
				+ "");
		return query.toString();
	}
}
