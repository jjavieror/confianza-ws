package co.com.ws.confianza.model.dto.cartera;

import java.io.Serializable;
import java.util.Date;

public class CarteraDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	public String nomsuc;
	public String ramo;
	public String poliza;
	public String certif;
	public String nomclic;
	public String nitc;
	public Date fecter;
	public String sumaPrimaIvaGastos1;
	public String sumaPrimaIvaGastos2;

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

	public String getSumaPrimaIvaGastos1() {
		return sumaPrimaIvaGastos1;
	}

	public void setSumaPrimaIvaGastos1(String sumaPrimaIvaGastos1) {
		this.sumaPrimaIvaGastos1 = sumaPrimaIvaGastos1;
	}

	public String getSumaPrimaIvaGastos2() {
		return sumaPrimaIvaGastos2;
	}

	public void setSumaPrimaIvaGastos2(String sumaPrimaIvaGastos2) {
		this.sumaPrimaIvaGastos2 = sumaPrimaIvaGastos2;
	}

}
