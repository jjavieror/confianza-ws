package co.com.ws.confianza.controller.rest;

import co.com.ws.confianza.bussines.concurso.ConcursoService;
import co.com.ws.confianza.controller.rest.ConcursoController;
import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/secured/concurso" })
public class ConcursoController {
	
	@Autowired
	private ConcursoService concursoService;

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<ConcursoDTO> findCartera(@RequestParam(name = "nitIntermediario") String nitIntermediario) {
		return concursoService.findConcurso(nitIntermediario);
	}
}
