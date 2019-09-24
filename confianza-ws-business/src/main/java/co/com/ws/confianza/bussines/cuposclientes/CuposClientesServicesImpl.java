package co.com.ws.confianza.bussines.cuposclientes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.clientescupo.ClientesCupoDAO;
import co.com.ws.confianza.model.dto.clientescupo.ClientesCupoDTO;
import co.com.ws.confianza.model.dto.clientescupo.PolizasClienteCupoDTO;

@Service
@Transactional
public class CuposClientesServicesImpl implements CuposClientesService {
	
	@Autowired
	private ClientesCupoDAO clienteCupoDao;

	@Transactional(readOnly = true)
	@Override
	public List<ClientesCupoDTO> findCuposClientes(String cliente, String fecha) {
		return this.clienteCupoDao.findClientesCupos(cliente, fecha);
	}

	@Transactional(readOnly = true)
	@Override
	public List<PolizasClienteCupoDTO> findPolizas(String codigo, String fechaDesde, String fechaHasta,
			String cerFkTecnica, String cerFkRangoValorAsegurado, String cerFkGeografica, String cerNumPoliza,
			String cerNumCertificado) {
		return this.clienteCupoDao.findPolizas(codigo, fechaDesde, fechaHasta, cerFkTecnica, cerFkRangoValorAsegurado,
				cerFkGeografica, cerNumPoliza, cerNumCertificado);
	}
}
