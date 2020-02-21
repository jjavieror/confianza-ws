package co.com.ws.confianza.dao.concurso.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

public class ConcursoRowMapper implements RowMapper<ConcursoDTO> {
	public ConcursoDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		ConcursoDTO concursoDTO = new ConcursoDTO();
		concursoDTO.setMeta(rs.getString("META"));
		concursoDTO.setNombreConcurso(rs.getString("CONCURSO_NOMBRE") + "-" + rs.getString("PREMIO_CATEGORIA"));
		concursoDTO.setPorcProduccion(rs.getString("PRODUCCION"));
		concursoDTO.setPorcRecaudo(rs.getString("PORC_RECAUDO"));
		concursoDTO.setProduccion(rs.getString("PORC_PRODUCCION"));
		concursoDTO.setRecaudo(rs.getString("RECAUDO"));
		concursoDTO.setPrizeCategory(rs.getString("PREMIO_CATEGORIA"));
		return concursoDTO;
	}
}
