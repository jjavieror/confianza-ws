package co.com.ws.confianza.bussines.presentationPercentajes;

import java.util.List;

import co.com.ws.confianza.model.dto.presentationPercentajes.PresentationPercentajes;

public interface PresentationPercentajesService {

	List<PresentationPercentajes> findPresentationPercentajes(String nitIntermediary);

}
