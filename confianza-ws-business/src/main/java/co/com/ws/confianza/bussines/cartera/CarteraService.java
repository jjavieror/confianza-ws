package co.com.ws.confianza.bussines.cartera;

import java.util.List;

import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

public interface CarteraService {

	List<CarteraDTO> findCartera(String code);

}
