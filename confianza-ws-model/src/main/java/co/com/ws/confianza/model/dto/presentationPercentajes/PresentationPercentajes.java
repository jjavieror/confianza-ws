package co.com.ws.confianza.model.dto.presentationPercentajes;

import java.io.Serializable;

public class PresentationPercentajes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String name;

	public String period;

	public String compliance;

	public String extracontractualRc;

	public String generalRc;

	public String trcm;

	public String property;

	public String transport;

	public String vidaGrupo;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public String getCompliance() {
		return compliance;
	}

	public void setCompliance(String compliance) {
		this.compliance = compliance;
	}

	public String getExtracontractualRc() {
		return extracontractualRc;
	}

	public void setExtracontractualRc(String extracontractualRc) {
		this.extracontractualRc = extracontractualRc;
	}

	public String getGeneralRc() {
		return generalRc;
	}

	public void setGeneralRc(String generalRc) {
		this.generalRc = generalRc;
	}

	public String getTrcm() {
		return trcm;
	}

	public void setTrcm(String trcm) {
		this.trcm = trcm;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getTransport() {
		return transport;
	}

	public void setTransport(String transport) {
		this.transport = transport;
	}

	public String getVidaGrupo() {
		return vidaGrupo;
	}

	public void setVidaGrupo(String vidaGrupo) {
		this.vidaGrupo = vidaGrupo;
	}
	
	

}
