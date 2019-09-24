package co.com.ws.confianza.model.dto.clientescupo;

import java.io.Serializable;
import java.util.Date;

public class PolizasClienteCupoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private String aCerNumPolizas;
	private String aCerNumCertificado;
	private String cPerPersona;
	private String cPerPersonaNombre;
	private String ePerPersona;
	private String ePerPersonaNombre;
	private String gPerPersona;
	private String gPerPersonaNombre;
	private Date aCerFechaDesde;
	private Date aCerFechaHasta;
	private String aCerPrimaEmit;
	private String aCerValorAsegurado;
	private String valorDeducible;
	private String tecRamoDesc;

	public String getaCerNumPolizas() {
		return aCerNumPolizas;
	}

	public void setaCerNumPolizas(String aCerNumPolizas) {
		this.aCerNumPolizas = aCerNumPolizas;
	}

	public String getaCerNumCertificado() {
		return aCerNumCertificado;
	}

	public void setaCerNumCertificado(String aCerNumCertificado) {
		this.aCerNumCertificado = aCerNumCertificado;
	}

	public String getcPerPersona() {
		return cPerPersona;
	}

	public void setcPerPersona(String cPerPersona) {
		this.cPerPersona = cPerPersona;
	}

	public String getcPerPersonaNombre() {
		return cPerPersonaNombre;
	}

	public void setcPerPersonaNombre(String cPerPersonaNombre) {
		this.cPerPersonaNombre = cPerPersonaNombre;
	}

	public String getePerPersona() {
		return ePerPersona;
	}

	public void setePerPersona(String ePerPersona) {
		this.ePerPersona = ePerPersona;
	}

	public String getePerPersonaNombre() {
		return ePerPersonaNombre;
	}

	public void setePerPersonaNombre(String ePerPersonaNombre) {
		this.ePerPersonaNombre = ePerPersonaNombre;
	}

	public String getgPerPersona() {
		return gPerPersona;
	}

	public void setgPerPersona(String gPerPersona) {
		this.gPerPersona = gPerPersona;
	}

	public String getgPerPersonaNombre() {
		return gPerPersonaNombre;
	}

	public void setgPerPersonaNombre(String gPerPersonaNombre) {
		this.gPerPersonaNombre = gPerPersonaNombre;
	}

	public Date getaCerFechaDesde() {
		return aCerFechaDesde;
	}

	public void setaCerFechaDesde(Date aCerFechaDesde) {
		this.aCerFechaDesde = aCerFechaDesde;
	}

	public Date getaCerFechaHasta() {
		return aCerFechaHasta;
	}

	public void setaCerFechaHasta(Date aCerFechaHasta) {
		this.aCerFechaHasta = aCerFechaHasta;
	}

	public String getaCerPrimaEmit() {
		return aCerPrimaEmit;
	}

	public void setaCerPrimaEmit(String aCerPrimaEmit) {
		this.aCerPrimaEmit = aCerPrimaEmit;
	}

	public String getaCerValorAsegurado() {
		return aCerValorAsegurado;
	}

	public void setaCerValorAsegurado(String aCerValorAsegurado) {
		this.aCerValorAsegurado = aCerValorAsegurado;
	}

	public String getValorDeducible() {
		return valorDeducible;
	}

	public void setValorDeducible(String valorDeducible) {
		this.valorDeducible = valorDeducible;
	}

	public String getTecRamoDesc() {
		return tecRamoDesc;
	}

	public void setTecRamoDesc(String tecRamoDesc) {
		this.tecRamoDesc = tecRamoDesc;
	}

}