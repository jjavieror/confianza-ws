package co.com.ws.confianza.common.util.dto;

import java.io.Serializable;

/**
 * Clase para recuperar las autorizaciones durante el login.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class AuthLoginDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final String INAUTH = "I";

    public static final String UPAUTH = "U";

    public static final String DELAUTH = "D";

    public static final String SELAUTH = "S";

    private String authorization;

    private Long idRole;

    private String inAuth;

    private String upAuth;

    private String delAuth;

    private String seAuth;

    public String getAuthorization() {
        return authorization;
    }

    public void setAuthorization(String authorization) {
        this.authorization = authorization;
    }

    public Long getIdRole() {
        return idRole;
    }

    public void setIdRole(Long idRole) {
        this.idRole = idRole;
    }

    public String getInAuth() {
        return inAuth;
    }

    public void setInAuth(String inAuth) {
        this.inAuth = inAuth;
    }

    public String getUpAuth() {
        return upAuth;
    }

    public void setUpAuth(String upAuth) {
        this.upAuth = upAuth;
    }

    public String getDelAuth() {
        return delAuth;
    }

    public void setDelAuth(String delAuth) {
        this.delAuth = delAuth;
    }

    public String getSeAuth() {
        return seAuth;
    }

    public void setSeAuth(String seAuth) {
        this.seAuth = seAuth;
    }

    @Override
    public String toString() {
        return "AuthLoginDTO [authorization=" + authorization + ", idRole=" + idRole + ", inAuth=" + inAuth + ", upAuth=" + upAuth + ", delAuth="
                + delAuth + ", seAuth=" + seAuth + "]";
    }

}
