package co.com.ws.confianza.bussines.concurso;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.external.concurso.ConcursoDAO;
import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

@Service
@Transactional
public class ConcursoServiceImpl implements ConcursoService {
	@Autowired
	private ConcursoDAO concursoDao;

	@Override
	public List<ConcursoDTO> findConcurso(String nitIntermediario) {
		return this.concursoDao.findConcurso(nitIntermediario);
	}
}