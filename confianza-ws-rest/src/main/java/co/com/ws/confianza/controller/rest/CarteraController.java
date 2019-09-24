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
	public List<CarteraDTO> findCartera(@RequestParam(name = "code") String code) {
		return carteraService.findCartera(code);
	}
}
