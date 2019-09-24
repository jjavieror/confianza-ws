package co.com.ws.confianza.dao.external.produccionacomulada;

import java.util.List;

import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;

public interface ProduccionAcomuladaDAO {

	List<ProduccionAcomuladaDTO> findProduccionAcomulada(String nit);

}
