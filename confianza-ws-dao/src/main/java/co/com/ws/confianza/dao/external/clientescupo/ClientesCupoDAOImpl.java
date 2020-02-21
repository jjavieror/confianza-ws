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
			String cerNumCertificado, String perPersona, String primaEmitStart, String primaEmitEnd,
			String cerValorAseguradoStart, String cerValorAseguradoEnd) {
		System.out.println("Inicia polizas----------------------------------> findPolizas");
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		System.out.println("Query UNO---------------------> " + queryPolizas(codigo, fechaDesde, fechaHasta,
				cerFkTecnica, cerFkRangoValorAsegurado, cerFkGeografica, cerNumPoliza, cerNumCertificado, perPersona,
				primaEmitStart, primaEmitEnd, cerValorAseguradoStart, cerValorAseguradoEnd));
		System.out.println("Paso por este medio-------------------------->       findPolizas");
		return findAllBeanString(queryPolizas(codigo, fechaDesde, fechaHasta, cerFkTecnica, cerFkRangoValorAsegurado,
				cerFkGeografica, cerNumPoliza, cerNumCertificado, perPersona, primaEmitStart, primaEmitEnd,
				cerValorAseguradoStart, cerValorAseguradoEnd), mapParameters, new PolizasRowmapper());
	}

	@Override
	public List<ClientesCupoDTO> findClientesCupos(String cliente, String fecha) {
		MapSqlParameterSource mapParametersClientes = new MapSqlParameterSource();
		mapParametersClientes.addValue(FKINTERMEDIARIO, cliente);
		return findAllBean(FIND_TUS_CLIENTES, mapParametersClientes, new ClientesCuposRowmapper());
	}

	public String stringQueryValidation(String cerFkTecnica, String cerFkRangoValorAsegurado, String cerFkGeografica,
			String cerNumPoliza, String cerNumCertificado, String perPersona, String cerValorAseguradoStart,
			String cerValorAseguradoEnd) {
		StringBuilder string = new StringBuilder();
		if (cerFkTecnica != null) {
			string.append(" AND H.TEC_RAMO IN (" + cerFkTecnica + ")");
		}
		if (cerFkRangoValorAsegurado != null) {
			string.append(" AND A.CER_FK_RANGOVLRASEGURADO = '" + cerFkRangoValorAsegurado + "'");
		}
		if (cerFkGeografica != null) {
			string.append(" AND A.CER_FK_GEOGRAFICA IN (" + cerFkGeografica + ")");
		}
		if (cerNumCertificado != null) {
			string.append(" AND A.CER_NUM_CERTIFICADO = '" + cerNumCertificado + "'");
		}
		if (cerNumPoliza != null) {
			string.append(" AND A.CER_NUM_POLIZA = '" + cerNumPoliza + "'");
		}
		if (perPersona != null) {
			string.append(" AND C.PER_PERSONA = '" + perPersona + "'");
		}

		if (cerValorAseguradoStart != null && cerValorAseguradoEnd != null) {
			string.append(" AND A.CER_VALOR_ASEGURADO BETWEEN " + Integer.valueOf(cerValorAseguradoStart) + " AND "
					+ Integer.valueOf(cerValorAseguradoEnd));
		}

		System.out
				.println(cerFkTecnica + cerFkRangoValorAsegurado + cerFkGeografica + cerNumCertificado + cerNumPoliza);
		System.out.println("QUERY-STRING----------------------->" + string.toString());
		/*
		 * FILTRO POR NIT C.PER_PERSONA = '901049519' AND FILTRO POR PRIMA String
		 * perPersona, String primaEmit, String cerValorAsegurado A.CER_PRIMA_EMIT
		 * BETWEEN '100000' AND '300000' AND
		 * 
		 * FILTRO POR VALOR ASEGURADO A.CER_VALOR_ASEGURADO BETWEEN '200000000' AND
		 * '300000000'
		 */
		return string.toString();
	}

	public String queryPrimaEmit(String primaEmitStart, String primaEmitEnd) {
		StringBuilder string = new StringBuilder();
		if (primaEmitStart != null && primaEmitEnd != null) {
			string.append(" AND x.CER_PRIMA_EMIT BETWEEN " + Integer.valueOf(primaEmitStart) + " AND "
					+ Integer.valueOf(primaEmitEnd));
		}
		return string.toString();
	}

	public String queryPolizas(String codigo, String fechaDesde, String fechaHasta, String cerFkTecnica,
			String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza, String cerNumCertificado,
			String perPersona, String primaEmitStart, String primaEmitEnd, String cerValorAseguradoStart,
			String cerValorAseguradoEnd) {
		System.out.println("Paso por este medio-------------------------->       queryPolizas");
		StringBuilder query = new StringBuilder();
		query.append("SELECT *  FROM (");
		query.append("SELECT 	MAX(H.TEC_SUBPRODUCTO_DESC) AS TEC_SUBPRODUCTO,");
		query.append("MAX(CAST(H.TEC_RAMO_DESC AS VARCHAR2(100))) AS TEC_RAMO_DESC,");
		query.append("MAX(CAST(A.CER_NUM_POLIZA AS VARCHAR2(100))) AS CER_NUM_POLIZA,");
		query.append("MAX(CAST(A.CER_NUM_CERTIFICADO AS VARCHAR2(100))) AS CER_NUM_CERTIFICADO,");
		query.append("MAX(C.PER_PERSONA) AS CPER_PERSONA,");
		query.append("MAX(C.PER_PERSONA_NOMBRE) AS CPER_PERSONA_NOMBRE,");
		query.append("CASE WHEN H.TEC_RAMO='34' THEN '0' ELSE E.PER_PERSONA END AS EPER_PERSONA,");
		query.append(
				"CASE WHEN H.TEC_RAMO='34' THEN 'TODOS LOS ASEGURADOS' ELSE E.PER_PERSONA_NOMBRE END AS EPER_PERSONA_NOMBRE,");
		query.append("MAX(G.PER_PERSONA) AS GPER_PERSONA,");
		query.append("MAX(G.PER_PERSONA_NOMBRE) AS GPER_PERSONA_NOMBRE,");
		query.append("MAX(A.CER_FECHA_DESDE) AS CER_FECHA_DESDE,");
		query.append("MAX(A.CER_FECHA_HASTA) AS CER_FECHA_HASTA,");
		query.append("CAST(SUM(A.CER_VALOR_ASEGURADO) AS VARCHAR2(100)) AS CER_VALOR_ASEGURADO,");
		query.append("CAST(SUM(A.CER_PRIMA_EMIT) AS VARCHAR2(100)) AS CER_PRIMA_EMIT,");
		query.append("MAX(A.CER_FECHA_EXPEDICION) AS CER_FECHA_EXPEDICION");
		query.append(" FROM BDG.FACT_CERTIFICADOS A ");
		query.append("JOIN BDG.DIM_PERSONA_VINCULACION B ON A.CER_FK_TOMADOR = B.PERVIN_ID");
		query.append(" JOIN BDG.DIM_PERSONA C ON B.PERVIN_CODIGO = C.PER_CODIGO AND C.ESTADO = 'ACTIVO'");
		query.append(" JOIN BDG.DIM_PERSONA_VINCULACION D ON A.CER_FK_ASEGURADO = D.PERVIN_ID");
		query.append(" JOIN BDG.DIM_PERSONA E ON D.PERVIN_CODIGO = E.PER_CODIGO AND E.ESTADO = 'ACTIVO'");
		query.append(" JOIN BDG.DIM_PERSONA_VINCULACION F ON A.CER_FK_CLIENTE = F.PERVIN_ID");
		query.append(" JOIN BDG.DIM_PERSONA G ON F.PERVIN_CODIGO = G.PER_CODIGO AND G.ESTADO = 'ACTIVO'");
		query.append(" JOIN BDG.DIM_TECNICA H ON A.CER_FK_TECNICA =H.TEC_ID");
		query.append(" JOIN BDG.DIM_INTERMEDIARIO I ON I.INTRM_ID = A.CER_FK_INTERMEDIARIO");
		query.append(" WHERE       I.INTRM_INTERMEDIARIO = '" + codigo + "'");
		query.append(" AND A.CER_FECHA_EXPEDICION BETWEEN TO_DATE('" + fechaDesde + "', 'mm/dd/yyyy') AND TO_DATE('" + fechaHasta + "', 'mm/dd/yyyy', 'mm/dd/yyyy') " );
		query.append(stringQueryValidation(cerFkTecnica, cerFkRangoValorAsegurado, cerFkGeografica, cerNumPoliza,
						cerNumCertificado, perPersona, cerValorAseguradoStart, cerValorAseguradoEnd));
		query.append(" GROUP BY H.TEC_SUBPRODUCTO_DESC, H.TEC_RAMO_DESC, A.CER_NUM_POLIZA, A.CER_NUM_CERTIFICADO, ");
		query.append(" CASE WHEN H.TEC_RAMO='34' THEN '0' ELSE E.PER_PERSONA END, ");
		query.append(" CASE WHEN H.TEC_RAMO='34' THEN 'TODOS LOS ASEGURADOS' ELSE E.PER_PERSONA_NOMBRE END");
		query.append(" ORDER BY CER_FECHA_EXPEDICION DESC ");
		query.append(") X");
		query.append(" WHERE ROWNUM <= 500 " + queryPrimaEmit(primaEmitStart, primaEmitEnd));
		System.out.println("Query -------------> " + query.toString());
		return query.toString();
	}

	public String formatParamsIn(String trama) {
		String[] format = trama.split(",");
		String newTrama = "";
		for (int i = 0; i < format.length; i++) {
			System.out.println(format.length + "   " + i);
			if ((format.length - 1) == i) {
				newTrama += "'" + format[i] + "'";
			} else {
				newTrama += "'" + format[i] + "',";
			}
		}
		return newTrama;
	}
}
