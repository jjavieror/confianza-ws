package co.com.ws.confianza.dao.external.cartera;

import java.util.List;

import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

public interface CarteraDAO {

	List<CarteraDTO> findCartera(String code, String ramo, String nitTc, String poliza, String certif,
			String sucur, String primaStart, String primaEnd, String valorAseguradoStart, String valorAseguradoFinal);

}
