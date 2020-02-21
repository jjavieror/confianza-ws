package co.com.ws.confianza.dao.external.concurso;

import java.util.List;

import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

public interface ConcursoDAO {

	List<ConcursoDTO> findConcurso(String nitIntermediario, String typeName);

}
