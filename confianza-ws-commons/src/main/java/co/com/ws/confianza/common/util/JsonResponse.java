package co.com.ws.confianza.common.util;

import java.io.Serializable;

import flexjson.JSONSerializer;

public class JsonResponse implements Serializable {
	private static final long serialVersionUID = 808L;

	private Long id;

	private String message;

	private StatusResponse statusResponse;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public StatusResponse getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(StatusResponse statusResponse) {
		this.statusResponse = statusResponse;
	}

	public void addError(JsonResponse jsonResponse, Exception e) {
		jsonResponse.setStatusResponse(StatusResponse.E);
	}

	public String parseJsonToString(JsonResponse jsonResponse) {
		JSONSerializer serializer = new JSONSerializer();
		return serializer.exclude("jsonResponse.class").serialize(jsonResponse);
	}
}
