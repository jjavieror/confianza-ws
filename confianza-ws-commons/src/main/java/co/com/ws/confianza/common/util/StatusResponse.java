package co.com.ws.confianza.common.util;

public enum StatusResponse {

	E {
		public String toString() {
			return "Error";
		}
	},

	C {
		public String toString() {
			return "Correcto";
		}
	};
}
