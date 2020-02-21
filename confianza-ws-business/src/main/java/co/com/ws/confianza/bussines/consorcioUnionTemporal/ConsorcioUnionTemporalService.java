package co.com.ws.confianza.bussines.consorcioUnionTemporal;

import java.util.List;

import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

public interface ConsorcioUnionTemporalService {

	List<ConsorcioTemporalesDTO> findClientesConsorcioTemporal(String cliente, String fecha);

}
