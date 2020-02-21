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
		/*rowMapper query segunda version*/
		cartera.setFecini(rs.getDate("FECINI"));
		cartera.setPrima(rs.getString("PRIMA"));
		cartera.setIva(rs.getString("IVA"));
		cartera.setPrimaGastos(rs.getString("PRIMA_GASTOS"));
		cartera.setTotalPoliza(rs.getString("TOTAL_POLIZA"));
		cartera.setValorAsegurado(rs.getString("VALOR_ASEGURADO"));
		return cartera;
	}
}
