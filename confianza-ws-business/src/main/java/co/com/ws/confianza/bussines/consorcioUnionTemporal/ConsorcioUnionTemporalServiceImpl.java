package co.com.ws.confianza.bussines.consorcioUnionTemporal;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.consorciouniontemporal.ConsorcioUnionTemporalDAO;
import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

@Service
@Transactional
public class ConsorcioUnionTemporalServiceImpl implements ConsorcioUnionTemporalService {
	
	@Autowired
	private ConsorcioUnionTemporalDAO consorcioUT;

	@Transactional(readOnly = true)
	@Override
	public List<ConsorcioTemporalesDTO> findClientesConsorcioTemporal(String cliente, String fecha) {
		return this.consorcioUT.findClientesConsorcioTemporal(cliente, fecha);
	}
}