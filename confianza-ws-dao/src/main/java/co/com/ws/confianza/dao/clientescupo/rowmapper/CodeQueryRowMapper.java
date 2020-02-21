package co.com.ws.confianza.dao.clientescupo.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.clientescupo.ObjectCode;

public class CodeQueryRowMapper implements RowMapper<ObjectCode> {
	public ObjectCode mapRow(ResultSet rs, int rowNum) throws SQLException {
		ObjectCode object = new ObjectCode();
		object.setCode(Integer.valueOf(rs.getInt("CODIGO_FK")));
		object.setNombre(rs.getString("NOMBRE"));
		return object;
	}
}
