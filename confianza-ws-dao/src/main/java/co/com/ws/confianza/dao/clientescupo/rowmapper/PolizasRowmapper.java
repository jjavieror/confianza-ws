package co.com.ws.confianza.dao.clientescupo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

public class PolizasRowmapper implements RowMapper<PolizasClienteCupoDTO> {
	public PolizasClienteCupoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		PolizasClienteCupoDTO polizas = new PolizasClienteCupoDTO();
		polizas.setaCerFechaDesde(rs.getDate("CER_FECHA_DESDE"));
		polizas.setaCerFechaHasta(rs.getDate("CER_FECHA_HASTA"));
		polizas.setaCerNumCertificado(rs.getString("CER_NUM_CERTIFICADO"));
		polizas.setaCerNumPolizas(rs.getString("CER_NUM_POLIZA"));
		polizas.setaCerPrimaEmit(rs.getString("CER_PRIMA_EMIT"));
		polizas.setcPerPersona(rs.getString("CPER_PERSONA"));
		polizas.setcPerPersonaNombre(rs.getString("CPER_PERSONA_NOMBRE"));
		polizas.setgPerPersona(rs.getString("GPER_PERSONA"));
		polizas.setgPerPersonaNombre(rs.getString("GPER_PERSONA_NOMBRE"));
		polizas.setaCerValorAsegurado(rs.getString("CER_VALOR_ASEGURADO"));
		polizas.setePerPersona(rs.getString("EPER_PERSONA"));
		polizas.setePerPersonaNombre(rs.getString("EPER_PERSONA_NOMBRE"));
		polizas.setTecRamoDesc(rs.getString("TEC_RAMO_DESC"));
		polizas.setTecSubProducto(rs.getString("TEC_SUBPRODUCTO"));
		polizas.setCerFechaExpedicion(rs.getDate("CER_FECHA_EXPEDICION"));
		return polizas;
	}
}
