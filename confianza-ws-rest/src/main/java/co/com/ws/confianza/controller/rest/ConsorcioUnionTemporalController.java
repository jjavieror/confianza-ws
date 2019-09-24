package co.com.ws.confianza.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ws.confianza.bussines.consorcioUnionTemporal.ConsorcioUnionTemporalService;
import co.com.ws.confianza.model.dto.consorciotemporales.ConsorcioTemporalesDTO;

@RestController
@RequestMapping({ "/secured/consorcio-union-temporal" })
public class ConsorcioUnionTemporalController {
	@Autowired
	private ConsorcioUnionTemporalService consorcioUnionTemporal;

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<ConsorcioTemporalesDTO> cuposClientesFind(@RequestParam(name = "agente") String agente,
			@RequestParam(name = "fecha", required = false) String fecha) {
		List<ConsorcioTemporalesDTO> list = new ArrayList<ConsorcioTemporalesDTO>();
		if (agente != null && !agente.isEmpty()) {
			list = consorcioUnionTemporal.findClientesConsorcioTemporal(agente, fecha);
		}
		return list;
	}
}