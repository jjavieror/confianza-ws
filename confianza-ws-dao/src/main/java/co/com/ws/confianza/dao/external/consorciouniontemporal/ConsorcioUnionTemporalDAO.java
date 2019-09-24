package co.com.ws.confianza.dao.external.consorciouniontemporal;

import java.util.List;

import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

public interface ConsorcioUnionTemporalDAO {

	List<ConsorcioTemporalesDTO> findClientesConsorcioTemporal(String cliente, String fecha);

}
