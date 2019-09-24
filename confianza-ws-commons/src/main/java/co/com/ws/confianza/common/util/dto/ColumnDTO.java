package co.com.ws.confianza.common.util.dto;

/**
 * Clase generica emular columnas de las grillas.
 *
 * @author Mayly Gibbs .
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class ColumnDTO {

	private String name;
	
	private String labelName;
	
	public ColumnDTO() {
		super();
	}
	
	public ColumnDTO (String name,String labelName) {
		super();
		this.name = name;
		this.labelName = labelName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLabelName() {
		return labelName;
	}

	public void setLabelName(String labelName) {
		this.labelName = labelName;
	}
}
