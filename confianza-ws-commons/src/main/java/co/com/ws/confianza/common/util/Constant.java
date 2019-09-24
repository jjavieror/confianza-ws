package co.com.ws.confianza.common.util;

/**
 * Constantes comunes.
 *
 *
 * @author Didier esteban garcia olave.
 * @copy Todos los derechos reservados a confianza.
 * @version 1.0
 */

public final class Constant {
	
	public static final String JSON = "json";
	
	public static final String SUCCESS = "success";
    
	public static final String ERROR_INTERNO = "Error interno";

    public static final String ERROR = Util.ERROR;

    public static final String CREATE = "Create";

    public static final String EDIT = "Edit";

    public static final String BREADCRUMBS = "breadCrumbs";

    public static final String OPERATOR_EQUAL = "=";

    public static final String OPERATOR_LIKE = "like";
    
    public static final String OPERATOR_LIKE_WITH_UPPER = "like_with_upper";
    
    public static final String OPERATOR_EQUAL_WITH_MONTH_FUNCTION = "equal_with_month_function";
    
    public static final String OPERATOR_EQUAL_WITH_YEAR_FUNCTION = "equal_with_year_function";

    public static final String OPERATOR_IN = "in";

    public static final String OPERATOR_NOT_EQUAL = "<>";

    public static final String OPERATOR_BETWEEN = "BETWEEN";

    public static final String OPERATOR_BETWEEN_OTHER = "BETWEEN_OTHER";

    public static final String OPERATOR_CONTAINS = "CONTAINS";

    public static final String OPERATOR_GREATER_EQUALS = ">=";

    public static final String OPERATOR_LOWER_EQUALS = "<=";

    public static final String MESSAGE_NOT_NULL = "No puede ser null";

    public static final String VISITOR_SESSION = "objUsuario";

    public static final String COMPANY_VISITOR_SESSION = "objCompanyUsuario";

    public static final String NUMBERS_CHART = "^$|[0-9]+";

    public static final String DATE_CHART = "^$|[0-9]{0,2}-[0-9]{0,2}-[0-9]{0,4}-";

    public static final String MESSAGE_NAME = "El nombre contiene caracteres no permitidos";

    public static final String STATE_CHART = "^$|[AICD]+";

    public static final String MESSAGE_STATE = "El estado contiene caracteres no permitidos";

    public static final String MESSAGE_DESCRIPTION = "La descripci&oacute;n contiene caracteres no permitidos";

    public static final String OR = "or";

    public static final String AND = "and";

    public static final String NO_SOPORTADO = "No soportado";

    public static final String ALLOWED_CHARACTERS = "^$|[A-Za-z0-9//\u00E1//\u00E9//\u00ED//\u00F3//\u00FA//\u00C1//\u00C9//\u00CD//\u00D3//\u00DA//\u00D1//\u00F1\\s-+()$%_&,.!/]+";

    public static final String DESCRIPTION_ALLOWED_CHARACTERS = "^$|[A-Za-z0-9//\u00E1//\u00E9//\u00ED//\u00F3//\u00FA//\u00C1//\u00C9//\u00CD//\u00D3//\u00DA//\u00D1//\u00F1//\u003C//\u003E//\u0021//\u0028//\u0029//\u002A//\u002B//\u002F//\u00BF\\s-+_()?:=!$%#@&,./ ]+";

    public static final String EMAIL_ALLOWED_CHARACTERS = "^[a-zA-Z0-9_.-]+\\@+[a-zA-Z0-9-_]+\\.+[a-zA-Z0-9]{2,4}\\.{0,1}[a-zA-Z0-9]{0,4}$";

    public static final String NUMBERS_ARRAY_CHARACTERS = "^$|[0-9,]+";

    public static final String NUMBER_CHARACTERS = "^$|[0-9]+";

    public static final String STATE_CHARACTERS = "^$|[AICD]+";
    //Number varchar date 
    public static final String COLUMNTYPE_CHARACTERS = "^$|[NVD]+";

    public static final String BOOLEAN_CHARACTERS = "^$|[SN]+";

    public static final String STATE_MESSAGE = "State contains unallowed characters";

    public static final String MAIL_MESSAGE = "Mail contains unallowed characters";

    public static final String GENERAL_MESSAGE = "It contains unallowed characters";

    public static final String NAME_MESSAGE = "Name contains unallowed characters";

    public static final String PRICE_MESSAGE = "Price contains unallowed characters";

    public static final String ID_MESSAGE = "Id contains unallowed characters";

    public static final String CODE_MESSAGE = "Code contains unallowed characters";

    public static final String DESCRIPTION_LENGTH_MESSAGE = "Description is greater than allowed";

    public static final String PUBLICATION_MEDIA_MESSAGE = "Publication media contains unallowed characters";

    public static final String PACKAGE_ID_MESSAGE = "Packages contains unallowed characters";

    public static final String IMPROVEMENT_ID_MESSAGE = "Improvements contains unallowed characters";

    public static final String URL_MESSAGE = "Invalid URL";

    public static final String TOTAL_UNITS_MESSAGE = "Total units contain unallowed characters";

    public static final String NUMBERS_MESSAGE = "Only numbers allowed";

    public static final String CLOSING_DAY_MESSAGE = "Closing day contains unallowed characters";

    public static final String CLOSING_HOUR_MESSAGE = "Closing hour contains unallowed characters";

    public static final String NOT_NULL_MESSAGE = "It must be not null";

    public static final String ID_NULL_MESSAGE = "Id ".concat(Constant.NOT_NULL_MESSAGE);

    public static final String ID_GREATER_THAN_ZERO_MESSAGE = "Id must be greater than zero";

    public static final String NULL_USER_MESSAGE = "User ".concat(Constant.NOT_NULL_MESSAGE);

    public static final String ERROR_EXCEPTION = "Error. Contact your administrator, please";
    
    public static final String ERROR_NO_IDENTIFICADO = "000";

    public static final String ERROR_CHAR = "001";

    public static final String ERROR_EMPTY = "002";

    public static final String ERROR_LONG = "003";
    
    public static final String YYYY_MM_DD_HH_MMA = "yyyy-MM-dd_hh:mma";
    
    public static final String DD_MM_YYYY = "dd-MM-YYYY";

    private Constant() {

    }
}
