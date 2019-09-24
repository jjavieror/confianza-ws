package co.com.ws.confianza.bussines.presentationPercentajes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.presentationPercentajes.PresentationPersentajeDAO;
import co.com.ws.confianza.model.dto.presentationPercentajes.PresentationPercentajes;

@Service
@Transactional
public class PresentationPrecentajesServicesImpl implements PresentationPercentajesService {

	@Autowired
	private PresentationPersentajeDAO presentationPercentajes;

	@Transactional(readOnly = true)
	@Override
	public List<PresentationPercentajes> findPresentationPercentajes(String nitIntermediary) {
		return presentationPercentajes.findPresnetationPercentajes(nitIntermediary);
	}

}
