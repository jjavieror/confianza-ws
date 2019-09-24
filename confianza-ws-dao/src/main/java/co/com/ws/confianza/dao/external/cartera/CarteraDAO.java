package co.com.ws.confianza.dao.external.cartera;

import java.util.List;

import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

public interface CarteraDAO {

	List<CarteraDTO> findCartera(String code);

}
