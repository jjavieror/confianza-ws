package co.com.ws.confianza.dao.cartera.rowmapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

public class CarteraRowMapper implements RowMapper<CarteraDTO> {

	public CarteraDTO mapRow(ResultSet rs, int rowNum) throws SQLException {
		CarteraDTO cartera = new CarteraDTO();
		cartera.setCertif(rs.getString("CERTIF"));
		cartera.setFecter(rs.getDate("FECTER"));
		cartera.setNitc(rs.getString("NITC"));
		cartera.setNomclic(rs.getString("NOMCLI"));
		cartera.setNomsuc(rs.getString("NOMSUC"));
		cartera.setPoliza(rs.getString("POLIZA"));
		cartera.setRamo(rs.getString("RAMO"));
		cartera.setSumaPrimaIvaGastos1(rs.getString("SUMAPRIMAIVAGASTOS1"));
		cartera.setSumaPrimaIvaGastos2(rs.getString("SUMAPRIMAIVAGASTOS1"));

		return cartera;
	}
}
