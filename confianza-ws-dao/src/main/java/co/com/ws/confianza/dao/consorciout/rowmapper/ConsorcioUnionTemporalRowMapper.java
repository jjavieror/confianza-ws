package co.com.ws.confianza.dao.consorciout.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

public class ConsorcioUnionTemporalRowMapper implements RowMapper<ConsorcioTemporalesDTO> {
	public ConsorcioTemporalesDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConsorcioTemporalesDTO consorcioUnion = new ConsorcioTemporalesDTO();
		consorcioUnion.setDocumento(rs.getString("NIT_CONSORCIADO"));
		consorcioUnion.setRazonSocialIntermediario(rs.getString("NOM_CONSORCIADO"));
		consorcioUnion.setNombreConsorcioUnionTemporal(rs.getString("NOM_CONSORCIO"));
		consorcioUnion.setValorCumulo(rs.getString("CUMULO_CONSORCIADO"));
		consorcioUnion.setValorCupo(rs.getString("CUPO_CONSORCIADO"));
		consorcioUnion.setValorDisponible(rs.getString("DISPO_CONSORCIADO"));
		return consorcioUnion;
	}
}
