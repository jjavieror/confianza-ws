package co.com.ws.confianza.common.util.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Clase generica para las consultas que retornan, id, alias, name, val.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class SelectOptionsDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private String id;

	private Class<?> clazz = SelectOptionsDTO.class;

	private String alias;

	private String name;

	private String val;

	public SelectOptionsDTO() {
		super();

	}

	public SelectOptionsDTO(String id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public SelectOptionsDTO(String id, String alias, String name) {
		super();
		this.id = id;
		this.alias = alias;
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public final String getAlias() {
		return alias;
	}

	public final void setAlias(String alias) {
		this.alias = alias;
	}

	@Override
	public String toString() {
		return "SelectOptionsDTO [id=" + id + ", alias=" + alias + ", name=" + name + ", val=" + val + "]";
	}

	public String getVal() {
		return val;
	}

	public void setVal(String val) {
		this.val = val;
	}

	@JsonIgnore
	@JsonProperty(value = "clazz")
	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

}
