package co.com.ws.confianza.model.dto.clientescupo;

import java.io.Serializable;

public class TusPolizasDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String cerFkTecnica;
	private String cerFkRangoVlraSegurado;
	private String cerFkGeografica;
	private String cerNumPoliza;
	private String cerNumCertificado;

	public String getCerFkTecnica() {
		return cerFkTecnica;
	}

	public void setCerFkTecnica(String cerFkTecnica) {
		this.cerFkTecnica = cerFkTecnica;
	}

	public String getCerFkRangoVlraSegurado() {
		return cerFkRangoVlraSegurado;
	}

	public void setCerFkRangoVlraSegurado(String cerFkRangoVlraSegurado) {
		this.cerFkRangoVlraSegurado = cerFkRangoVlraSegurado;
	}

	public String getCerFkGeografica() {
		return cerFkGeografica;
	}

	public void setCerFkGeografica(String cerFkGeografica) {
		this.cerFkGeografica = cerFkGeografica;
	}

	public String getCerNumPoliza() {
		return cerNumPoliza;
	}

	public void setCerNumPoliza(String cerNumPoliza) {
		this.cerNumPoliza = cerNumPoliza;
	}

	public String getCerNumCertificado() {
		return cerNumCertificado;
	}

	public void setCerNumCertificado(String cerNumCertificado) {
		this.cerNumCertificado = cerNumCertificado;
	}

}
