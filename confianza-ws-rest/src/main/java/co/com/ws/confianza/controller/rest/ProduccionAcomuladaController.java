package co.com.ws.confianza.controller.rest;

import co.com.ws.confianza.bussines.produccionacomulada.ProduccionAcomuladaService;
import co.com.ws.confianza.controller.rest.ProduccionAcomuladaController;
import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/secured/produccion-acomulada" })
public class ProduccionAcomuladaController {
	@Autowired
	private ProduccionAcomuladaService produccionAcomuladaService;

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<ProduccionAcomuladaDTO> findProduccionAcomulada(@RequestParam(name = "nit") String nit) {
		return produccionAcomuladaService.findListProduccionAcoulada(nit);
	}
}
