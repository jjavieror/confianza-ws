package co.com.ws.confianza.dao.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.common.util.dto.SelectOptionsDTO;

/**
 * Clase que procesa y mapea el resultSet.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados.
 * @version 1.0
 */
public class SelectOptionsRowMapper implements RowMapper<SelectOptionsDTO> {

	@Override
	public SelectOptionsDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		SelectOptionsDTO select = new SelectOptionsDTO();
		select.setId(rs.getString("id"));
		select.setName(rs.getString("name"));

		return select;
	}

}
