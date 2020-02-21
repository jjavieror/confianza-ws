package co.com.ws.confianza.controller.rest;

import co.com.ws.confianza.bussines.cartera.CarteraService;
import co.com.ws.confianza.controller.rest.CarteraController;
import co.com.ws.confianza.model.dto.cartera.CarteraDTO;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({ "/secured/cartera" })
public class CarteraController {

	@Autowired
	public CarteraService carteraService;

	@RequestMapping(value = { "/get" }, method = { RequestMethod.GET })
	public List<CarteraDTO> findCartera(@RequestParam(name = "code") String code,
			@RequestParam(name = "sucursal", required = false) String sucur,
			@RequestParam(name = "ramo", required = false) String ramo,
			@RequestParam(name = "nitTc", required = false) String nitTc,
			@RequestParam(name = "poliza", required = false) String poliza,
			@RequestParam(name = "certif", required = false) String certif,
			@RequestParam(name = "primaStart", required = false) String primaStart,
			@RequestParam(name = "primaEnd", required = false) String primaEnd,
			@RequestParam(name = "valorAseguradoStart", required = false) String valorAseguradoStart,
			@RequestParam(name = "valorAseguradoFinal", required = false) String valorAseguradoFinal) {
		System.out.println("Paso por el controlador");
		return carteraService.findCartera(code, ramo, nitTc, poliza, certif, sucur, primaStart, primaEnd,
				valorAseguradoStart, valorAseguradoFinal);
	}
}
