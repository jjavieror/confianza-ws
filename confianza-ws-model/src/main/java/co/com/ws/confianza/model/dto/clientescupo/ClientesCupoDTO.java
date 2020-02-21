package co.com.ws.confianza.model.dto.clientescupo;

public class ClientesCupoDTO {

	public String razonSocialCliente;
	public String documentoCliente;
	public String valorCupo;
	public String valorCumulo;
	public String valorDisponible;

	public String getRazonSocialCliente() {
		return razonSocialCliente;
	}

	public void setRazonSocialCliente(String razonSocialCliente) {
		this.razonSocialCliente = razonSocialCliente;
	}

	public String getDocumentoCliente() {
		return documentoCliente;
	}

	public void setDocumentoCliente(String documentoCliente) {
		this.documentoCliente = documentoCliente;
	}

	public String getValorCupo() {
		return valorCupo;
	}

	public void setValorCupo(String valorCupo) {
		this.valorCupo = valorCupo;
	}

	public String getValorCumulo() {
		return valorCumulo;
	}

	public void setValorCumulo(String valorCumulo) {
		this.valorCumulo = valorCumulo;
	}

	public String getValorDisponible() {
		return valorDisponible;
	}

	public void setValorDisponible(String valorDisponible) {
		this.valorDisponible = valorDisponible;
	}

}
