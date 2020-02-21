package co.com.ws.confianza.bussines.cartera;

import java.util.List;

import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

public interface CarteraService {

	List<CarteraDTO> findCartera(String code, String ramo, String nitTc, String poliza, String certif,
			String sucur, String primaStart, String primaEnd, String valorAseguradoStart, String valorAseguradoFinal);

}
