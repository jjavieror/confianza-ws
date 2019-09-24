package co.com.ws.confianza.model.dto.concurso;

import java.io.Serializable;

public class ConcursoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String nombreConcurso;
	private String meta;
	private String produccion;
	private String recaudo;
	private String porcProduccion;
	private String porcRecaudo;

	public String getNombreConcurso() {
		return nombreConcurso;
	}

	public void setNombreConcurso(String nombreConcurso) {
		this.nombreConcurso = nombreConcurso;
	}

	public String getMeta() {
		return meta;
	}

	public void setMeta(String meta) {
		this.meta = meta;
	}

	public String getProduccion() {
		return produccion;
	}

	public void setProduccion(String produccion) {
		this.produccion = produccion;
	}

	public String getRecaudo() {
		return recaudo;
	}

	public void setRecaudo(String recaudo) {
		this.recaudo = recaudo;
	}

	public String getPorcProduccion() {
		return porcProduccion;
	}

	public void setPorcProduccion(String porcProduccion) {
		this.porcProduccion = porcProduccion;
	}

	public String getPorcRecaudo() {
		return porcRecaudo;
	}

	public void setPorcRecaudo(String porcRecaudo) {
		this.porcRecaudo = porcRecaudo;
	}

}
