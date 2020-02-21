package co.com.ws.confianza.controller.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.com.ws.confianza.bussines.cuposclientes.CuposClientesService;
import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

@RestController
@RequestMapping({ "/secured/polizas" })
public class PolizasController {
	@Autowired
	private CuposClientesService cuposClientes;

	@RequestMapping(value = { "/get/polizas" }, method = { RequestMethod.GET })
	public List<PolizasClienteCupoDTO> findSegurosClientes(@RequestParam(name = "codigoCliente") String codigoCliente,
			@RequestParam(name = "fechaDesde", required = false) String fechaDesde,
			@RequestParam(name = "fechaHasta", required = false) String fechaHasta,
			@RequestParam(name = "cerFkTecnica", required = false) String cerFkTecnica,
			@RequestParam(name = "cerFkRangoValorAsegurado", required = false) String cerFkRangoValorAsegurado,
			@RequestParam(name = "cerFkGeografica", required = false) String cerFkGeografica,
			@RequestParam(name = "cerFkNumPoliza", required = false) String cerNumPoliza,
			@RequestParam(name = "cerFkNumCertificado", required = false) String cerNumCertificado,
			@RequestParam(name = "perPersona", required = false) String perPersona,
			@RequestParam(name = "primaEmitStart", required = false) String primaEmitStart,
			@RequestParam(name = "primaEmitEnd", required = false) String primaEmitEnd,
			@RequestParam(name = "cerValorAseguradoStart", required = false) String cerValorAseguradoStart,
			@RequestParam(name = "cerValorAseguradoEnd", required = false) String cerValorAseguradoEnd) {
		List<PolizasClienteCupoDTO> list = new ArrayList<PolizasClienteCupoDTO>();
		try {
			if (codigoCliente != null && !codigoCliente.isEmpty()) {
				list = cuposClientes.findPolizas(codigoCliente, fechaDesde, fechaHasta, cerFkTecnica,
						cerFkRangoValorAsegurado, cerFkGeografica, cerNumPoliza, cerNumCertificado, perPersona,
						primaEmitStart, primaEmitEnd, cerValorAseguradoStart, cerValorAseguradoEnd);
			}
		} catch (Exception e) {
			System.out.println("Error--------------------------_> " + e);
		}
		return list;
	}

}
