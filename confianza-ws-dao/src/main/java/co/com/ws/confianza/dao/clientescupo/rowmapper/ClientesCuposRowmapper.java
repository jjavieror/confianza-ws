package co.com.ws.confianza.dao.clientescupo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;

public class ClientesCuposRowmapper implements RowMapper<ClientesCupoDTO> {
	public ClientesCupoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ClientesCupoDTO clientesCupos = new ClientesCupoDTO();
		clientesCupos.setDocumentoCliente(rs.getString("NIT_CLIENTE"));
		clientesCupos.setRazonSocialCliente(rs.getString("NOM_CLIENTE"));
		clientesCupos.setValorCumulo(rs.getString("CUMULO_CLIENTE"));
		clientesCupos.setValorCupo(rs.getString("CUPO_CLIENTE"));
		clientesCupos.setValorDisponible(rs.getString("DISPO_CLIENTE"));

		return clientesCupos;
	}
}
