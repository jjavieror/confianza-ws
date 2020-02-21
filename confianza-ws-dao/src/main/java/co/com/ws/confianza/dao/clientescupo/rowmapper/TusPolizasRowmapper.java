package co.com.ws.confianza.dao.clientescupo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.clientescupo.TusPolizasDTO;

public class TusPolizasRowmapper implements RowMapper<TusPolizasDTO> {
	public TusPolizasDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		TusPolizasDTO tusPolizas = new TusPolizasDTO();
		tusPolizas.setCerFkGeografica(rs.getString("CER_FK_GEOGRAFICA"));
		tusPolizas.setCerFkRangoVlraSegurado(rs.getString("CER_FK_RANGOVLRASEGURADO"));
		tusPolizas.setCerFkTecnica(rs.getString("CER_FK_TECNICA"));
		tusPolizas.setCerNumCertificado(rs.getString("CER_NUM_CERTIFICADO"));
		tusPolizas.setCerNumPoliza(rs.getString("CER_NUM_POLIZA"));

		return tusPolizas;
	}
}