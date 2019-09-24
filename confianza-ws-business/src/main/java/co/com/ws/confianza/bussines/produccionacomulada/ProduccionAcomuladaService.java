package co.com.ws.confianza.bussines.produccionacomulada;

import java.util.List;

import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;

public interface ProduccionAcomuladaService {

	List<ProduccionAcomuladaDTO> findListProduccionAcoulada(String nit);

}
