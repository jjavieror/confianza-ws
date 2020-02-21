package co.com.ws.confianza.dao.presentationPercentajes.rowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.presentationPercentajes.PresentationPercentajes;

public class PresentationPersentajesRowMapper implements RowMapper<PresentationPercentajes> {

	@Override
	public PresentationPercentajes mapRow(ResultSet rs, int rowNum) throws SQLException {
		PresentationPercentajes percentajes = new PresentationPercentajes();
		percentajes.setCompliance(rs.getString("CUMPLIMIENTO"));
		percentajes.setExtracontractualRc(rs.getString("RC_EXTRACONTRACTUAL"));
		percentajes.setGeneralRc(rs.getString("RC_GENERAL"));
		percentajes.setName(rs.getString("NOMBRE"));
		percentajes.setPeriod(rs.getString("PERIODO"));
		percentajes.setProperty(rs.getString("PROPERTY"));
		percentajes.setTransport(rs.getString("TRANSPORTE"));
		percentajes.setTrcm(rs.getString("TRCM"));
		percentajes.setVidaGrupo(rs.getString("VIDA_GRUPO"));
		// TODO Auto-generated method stub
		return percentajes;
	}

}
