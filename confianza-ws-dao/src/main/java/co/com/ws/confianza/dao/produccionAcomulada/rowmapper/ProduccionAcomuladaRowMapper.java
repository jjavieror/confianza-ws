package co.com.ws.confianza.dao.produccionAcomulada.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;

public class ProduccionAcomuladaRowMapper implements RowMapper<ProduccionAcomuladaDTO> {
	public ProduccionAcomuladaDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ProduccionAcomuladaDTO produccion = new ProduccionAcomuladaDTO();
		produccion.setCumplimiento(rs.getString("CUMPLIMIENTO"));
		produccion.setNit(rs.getString("NIT"));
		produccion.setNombre(rs.getString("NOMBRE"));
		produccion.setPeriodo(rs.getString("PERIODO"));
		produccion.setProperty(rs.getString("PROPERTY"));
		produccion.setRcEctractual(rs.getString("RC_EXTRACONTRACTUAL"));
		produccion.setRcGeneral(rs.getString("RC_GENERAL"));
		produccion.setTransporte(rs.getString("TRANSPORTE"));
		produccion.setTrcm(rs.getString("TRCM"));

		return produccion;
	}
}