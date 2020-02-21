package co.com.ws.confianza.bussines.produccionacomulada;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.produccionacomulada.ProduccionAcomuladaDAO;
import co.com.ws.confianza.model.dto.produccionacomulada.ProduccionAcomuladaDTO;

@Service
@Transactional
public class ProduccionAcomuladaServicesImpl implements ProduccionAcomuladaService {

	@Autowired
	private ProduccionAcomuladaDAO produccionAcomuladaDao;

	@Transactional(readOnly = true)
	@Override
	public List<ProduccionAcomuladaDTO> findListProduccionAcoulada(String nit) {
		return this.produccionAcomuladaDao.findProduccionAcomulada(nit);
	}
}
