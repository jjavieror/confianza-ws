package co.com.ws.confianza.model.dto.cartera;

import java.io.Serializable;
import java.util.Date;

public class CarteraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	public String nomsuc;
	public String poliza;
	public String certif;
	public String nomclic;
	public String nitc;
	public Date fecter;
	/* Nuevos campos segunda version del query */
	public String ramo;
	public Date fecini;
	public String prima;
	public String iva;
	public String primaGastos;
	public String totalPoliza;
	public String valorAsegurado;

	public String getNomsuc() {
		return nomsuc;
	}

	public void setNomsuc(String nomsuc) {
		this.nomsuc = nomsuc;
	}

	public String getRamo() {
		return ramo;
	}

	public void setRamo(String ramo) {
		this.ramo = ramo;
	}

	public String getPoliza() {
		return poliza;
	}

	public void setPoliza(String poliza) {
		this.poliza = poliza;
	}

	public String getCertif() {
		return certif;
	}

	public void setCertif(String certif) {
		this.certif = certif;
	}

	public String getNomclic() {
		return nomclic;
	}

	public void setNomclic(String nomclic) {
		this.nomclic = nomclic;
	}

	public String getNitc() {
		return nitc;
	}

	public void setNitc(String nitc) {
		this.nitc = nitc;
	}

	public Date getFecter() {
		return fecter;
	}

	public void setFecter(Date fecter) {
		this.fecter = fecter;
	}

	public Date getFecini() {
		return fecini;
	}

	public void setFecini(Date fecini) {
		this.fecini = fecini;
	}

	public String getPrima() {
		return prima;
	}

	public void setPrima(String prima) {
		this.prima = prima;
	}

	public String getIva() {
		return iva;
	}

	public void setIva(String iva) {
		this.iva = iva;
	}

	public String getPrimaGastos() {
		return primaGastos;
	}

	public void setPrimaGastos(String primaGastos) {
		this.primaGastos = primaGastos;
	}

	public String getTotalPoliza() {
		return totalPoliza;
	}

	public void setTotalPoliza(String totalPoliza) {
		this.totalPoliza = totalPoliza;
	}

	public String getValorAsegurado() {
		return valorAsegurado;
	}

	public void setValorAsegurado(String valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}


}
