package co.com.ws.confianza.controller.rest;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.com.ws.confianza.bussines.cuposclientes.CuposClientesService;
import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;

@RestController
@RequestMapping({ "/secured/clientes-cupos" })
public class ClientesCuposController {
	
	@Autowired
	private CuposClientesService cuposClientes;

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<ClientesCupoDTO> cuposClientesFind(@RequestParam(name = "agente") String agente,
			@RequestParam(name = "fecha", required = false) String fecha) {
		List<ClientesCupoDTO> list = new ArrayList<ClientesCupoDTO>();
		if (agente != null && !agente.isEmpty()) {
			list = cuposClientes.findCuposClientes(agente, fecha);
		}
		return list;
	}
}