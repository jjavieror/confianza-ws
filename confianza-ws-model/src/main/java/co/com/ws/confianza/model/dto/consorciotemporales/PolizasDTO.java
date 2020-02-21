package co.com.ws.confianza.model.dto.consorciotemporales;

import java.util.Date;

public class PolizasDTO {

	public String agencia;
	public String sucrusal;
	public String numeroPoliza;
	public String CertificadosAsociados;
	public String nombreTomador;
	public String identificacionTomador;
	public String nombreAsegurado;
	public String identificacionAsegurado;
	public String nombreBeneficiario;
	public String identificacionBeneficiario;
	public Date vigenciaFechaInicio;
	public Date vigenciaFechaFinal;
	public String primaEmitida;
	public String valorAsegurado;
	public String valorDeducible;

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getSucrusal() {
		return sucrusal;
	}

	public void setSucrusal(String sucrusal) {
		this.sucrusal = sucrusal;
	}

	public String getNumeroPoliza() {
		return numeroPoliza;
	}

	public void setNumeroPoliza(String numeroPoliza) {
		this.numeroPoliza = numeroPoliza;
	}

	public String getCertificadosAsociados() {
		return CertificadosAsociados;
	}

	public void setCertificadosAsociados(String certificadosAsociados) {
		CertificadosAsociados = certificadosAsociados;
	}

	public String getNombreTomador() {
		return nombreTomador;
	}

	public void setNombreTomador(String nombreTomador) {
		this.nombreTomador = nombreTomador;
	}

	public String getIdentificacionTomador() {
		return identificacionTomador;
	}

	public void setIdentificacionTomador(String identificacionTomador) {
		this.identificacionTomador = identificacionTomador;
	}

	public String getNombreAsegurado() {
		return nombreAsegurado;
	}

	public void setNombreAsegurado(String nombreAsegurado) {
		this.nombreAsegurado = nombreAsegurado;
	}

	public String getIdentificacionAsegurado() {
		return identificacionAsegurado;
	}

	public void setIdentificacionAsegurado(String identificacionAsegurado) {
		this.identificacionAsegurado = identificacionAsegurado;
	}

	public String getNombreBeneficiario() {
		return nombreBeneficiario;
	}

	public void setNombreBeneficiario(String nombreBeneficiario) {
		this.nombreBeneficiario = nombreBeneficiario;
	}

	public String getIdentificacionBeneficiario() {
		return identificacionBeneficiario;
	}

	public void setIdentificacionBeneficiario(String identificacionBeneficiario) {
		this.identificacionBeneficiario = identificacionBeneficiario;
	}

	public Date getVigenciaFechaInicio() {
		return vigenciaFechaInicio;
	}

	public void setVigenciaFechaInicio(Date vigenciaFechaInicio) {
		this.vigenciaFechaInicio = vigenciaFechaInicio;
	}

	public Date getVigenciaFechaFinal() {
		return vigenciaFechaFinal;
	}

	public void setVigenciaFechaFinal(Date vigenciaFechaFinal) {
		this.vigenciaFechaFinal = vigenciaFechaFinal;
	}

	public String getPrimaEmitida() {
		return primaEmitida;
	}

	public void setPrimaEmitida(String primaEmitida) {
		this.primaEmitida = primaEmitida;
	}

	public String getValorAsegurado() {
		return valorAsegurado;
	}

	public void setValorAsegurado(String valorAsegurado) {
		this.valorAsegurado = valorAsegurado;
	}

	public String getValorDeducible() {
		return valorDeducible;
	}

	public void setValorDeducible(String valorDeducible) {
		this.valorDeducible = valorDeducible;
	}

}
