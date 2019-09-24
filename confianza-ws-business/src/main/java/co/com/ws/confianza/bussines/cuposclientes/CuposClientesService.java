package co.com.ws.confianza.bussines.cuposclientes;

import java.util.List;

import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;
import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

public interface CuposClientesService {

	List<ClientesCupoDTO> findCuposClientes(String cliente, String fecha);

	List<PolizasClienteCupoDTO> findPolizas(String codigo, String fechaDesde, String fechaHasta, String cerFkTecnica,
			String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza, String cerNumCertificado);

}
