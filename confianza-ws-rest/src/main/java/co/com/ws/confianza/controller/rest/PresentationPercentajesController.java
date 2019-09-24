package co.com.ws.confianza.controller.rest;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ws.confianza.bussines.presentationPercentajes.PresentationPercentajesService;
import co.com.ws.confianza.model.dto.presentationPercentajes.PresentationPercentajes;

@RestController
@RequestMapping({ "/secured/presentation-percentajes" })
public class PresentationPercentajesController {
	
	@Autowired
	private PresentationPercentajesService presentationPercentajes;
	
	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<PresentationPercentajes> findPresentationPercentajes(@RequestParam(name = "nitIntermediary") String nitIntermediary) {
		return presentationPercentajes.findPresentationPercentajes(nitIntermediary);
	}

}
