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

	public CarteraDAOImpl() {
		super(BEAN_QUERIES);
	}

	@Override
	public List<CarteraDTO> findCartera(String code, String ramo, String nitTc, String poliza, String certif,
			String sucur, String primaStart, String primaEnd, String valorAseguradoStart, String valorAseguradoFinal) {
		System.out.println("paso por el DAO Implements");
		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		return findAllBeanString(queryCartera(code, ramo, nitTc, poliza, certif, sucur, primaStart, primaEnd,
				valorAseguradoStart, valorAseguradoFinal), mapParameters, new CarteraRowMapper());
	}

	public String queryCartera(String code, String ramo, String nitTc, String poliza, String certif, String sucur,
			String primaStart, String primaEnd, String valorAseguradoStart, String valorAseguradoFinal) {
		StringBuilder string = new StringBuilder();
		string.append("SELECT NOMSUC,");
		string.append("(SELECT DESCRI FROM CONFIANZA.S03100 B WHERE B.CODRAM = A.RAMO) RAMO,");
		string.append("POLIZA,CERTIF,NOMCLI,NITC,FECTER,FECINI,CAST(PRIMA AS VARCHAR2(100)) AS PRIMA,");
		string.append("CAST(IVA AS VARCHAR2(100)) AS IVA,");
		string.append("CAST(GASTOS AS VARCHAR2(100)) AS PRIMA_GASTOS,");
		string.append("CAST(PRIMA+IVA+GASTOS AS VARCHAR2(100)) AS TOTAL_POLIZA,");
		string.append("(SELECT SUM(VASEG) FROM CONFIANZA.S03020 B WHERE B.SUCUR = A.SUCUR AND ");
		string.append("B.POLIZA = A.POLIZA AND B.CERTIF = A.CERTIF ) AS VALOR_ASEGURADO");
		string.append(" FROM CONFIANZA.DET_SALDOS A ");
		string.append(" WHERE NITAGE = " + code
				+ " AND FECHACORTE = TO_DATE(TO_CHAR(LAST_DAY(TRUNC(SYSDATE)), 'DD/MM/YYYY'),'DD/MM/YYYY') "
				+ queryValidatorCatera(ramo, nitTc, poliza, certif, sucur, primaStart, primaEnd, valorAseguradoStart,
						valorAseguradoFinal));
		System.out.println("String query cartera --------------------->" + string.toString());
		return string.toString();
	}

	public String queryValidatorCatera(String ramo, String nitTc, String poliza, String certif, String sucur,
			String primaStart, String primaEnd, String valorAseguradoStart, String valorAseguradoFinal) {
		StringBuilder string = new StringBuilder();
		if (ramo != null) {
			string.append(" AND A.RAMO = '" + ramo + "'");
		}
		if (nitTc != null) {
			string.append(" AND NITC = '" + nitTc + "'");
		}
		if (poliza != null) {
			string.append(" AND POLIZA = '" + poliza + "'");
		}
		if (certif != null) {
			string.append(" AND CERTIF = '" + certif + "'");
		}
		if (sucur != null) {
			string.append(" AND SUCUR IN (" + sucur + ")");
		}
		if (primaStart != null && primaEnd != null) {
			string.append(" AND PRIMA BETWEEN '" + primaStart + "' AND '" + primaEnd + "'");
		}
		if (valorAseguradoStart != null && valorAseguradoFinal != null) {
			string.append(
					" AND VALOR_ASEGURADO BETWEEN '" + valorAseguradoStart + "' AND '" + valorAseguradoFinal + "'");
		}
		return string.toString();
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