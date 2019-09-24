package co.com.ws.confianza.common.util;

/**
 * Expresiones regulares para validacion.
 *
 * @author Didier esteban garcia olave.
 * @copy Todos los derechos reservados a confianza.
 * @version 1.0
 */

public final class Patterns {

    public static final String ALLOWED_CHART = "^$|[A-Za-z0-9//\u00E1//\u00E9//\u00ED//\u00F3//\u00FA//\u00C1//\u00C9//\u00CD//\u00D3//\u00DA//\u00D1//\u00F1\\s-+()$%_&/]+";

    public static final String DESCRIPTION_ALLOWED_CHART = "^$|[A-Za-z0-9//\u00E1//\u00E9//\u00ED//\u00F3//\u00FA//\u00C1//\u00C9//\u00CD//\u00D3//\u00DA//\u00D1//\u00F1//\u003C//\u003E//\u0021//\u0028//\u0029//\u002A//\u002B//\u002F//\u00BF\\s-+_()?:=$%#@&,./ ]+";

    public static final String EMAIL_ALLOWED_CHART = "^[a-zA-Z0-9_.-]+\\@+[a-zA-Z0-9-_]+\\.+[a-zA-Z0-9]{2,4}+";

    public static final String NUMBERS_ARRAY_CHART = "^$|[0-9,]+";

    public static final String NUMBERS_CHART = "^$|[0-9]+";

    public static final String STATE_CHART = "^$|[AICD]+";

    public static final String BOOL_CHART = "^$|[SN]+";

    private Patterns() {

    }
}