package co.com.ws.confianza.dao.external.clientescupo;

import java.util.List;

import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;
import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

public interface ClientesCupoDAO {

	List<PolizasClienteCupoDTO> findPolizas(String codigo, String fechaDesde, String fechaHasta, String cerFkTecnica,
			String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza, String cerNumCertificado);

	List<ClientesCupoDTO> findClientesCupos(String cliente, String fecha);

}
