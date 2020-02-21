package co.com.ws.confianza.bussines.concurso;

import java.util.List;

import co.com.ws.confianza.model.dto.concurso.ConcursoDTO;

public interface ConcursoService {

	List<ConcursoDTO> findConcurso(String nitIntermediario, String typeName);

}
