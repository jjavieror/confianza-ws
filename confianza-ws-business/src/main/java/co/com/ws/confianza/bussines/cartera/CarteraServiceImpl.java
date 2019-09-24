package co.com.ws.confianza.bussines.cartera;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.cartera.CarteraDAO;
import co.com.ws.confianza.model.dto.cartera.CarteraDTO;

@Service
@Transactional
public class CarteraServiceImpl implements CarteraService {
	@Autowired
	private CarteraDAO carteraDao;

	@Transactional(readOnly = true)
	@Override
	public List<CarteraDTO> findCartera(String code) {
		return carteraDao.findCartera(code);
	}
}