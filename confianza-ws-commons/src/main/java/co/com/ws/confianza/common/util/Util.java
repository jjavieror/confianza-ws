package co.com.ws.confianza.common.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.ModelAndView;

import co.com.ws.confianza.common.util.dto.SelectOptionsDTO;
import flexjson.JSONSerializer;
import flexjson.transformer.DateTransformer;

/**
 * Clase para las utilidades.
 *
 *
 * @author Didier esteban garcia olave.
 * @copy Todos los derechos reservados a confianza.
 * @version 1.0
 */
@Component
public class Util {

	private static final String REGEX_CHARACTER = "[()$%#@&,.?:=*+_/]";

	private static final String REGEX_ACCENT3 = "\u00BF";

	private static final String REGEX_ACCENT2 = "\u0021";

	private static final String REGEX_ACCENT1 = "\u003E";

	private static final String ACCENT_N = "\u00F1";

	private static final String ACCENT_U = "\u00FA";

	private static final String ACCENT_O = "\u00F3";

	private static final String ACCENT_I = "\u00ED";

	private static final String REGEX_GUION = "\u003C";

	private static final String ACCENT_E = "\u00E9";

	public static final String ADMIN_COMMON_GRID_LIST = "common/grid";

	public static final String ADMIN_COMMON_GRID_LIST_NOAUTH = "common/gridNoAuth";

	private static final String JSON = "json";

	private static final String DATA = "data";

	private static final String RECORDS_FILTERED = "recordsFiltered";

	private static final String RECORDS_TOTAL = "recordsTotal";

	private static final String DRAW = "draw";

	private static final String ER_NUMBER = "\\d+";

	private static final String UNICODE = "\u00C0\u00E0\u00C8\u00E8" + "\u00CC\u00EC\u00D2\u00F2\u00D9\u00F9"
			+ "\u00C1\u00E1\u00C9\u00E9\u00CD\u00ED\u00D3\u00F3\u00DA\u00FA\u00DD\u00FD"
			+ "\u00C2\u00E2\u00CA\u00EA\u00CE\u00EE\u00D4\u00F4\u00DB\u00FB\u0176\u0177"
			+ "\u00C3\u00E3\u00D5\u00F5\u00D1\u00F1"
			+ "\u00C4\u00E4\u00CB\u00EB\u00CF\u00EF\u00D6\u00F6\u00DC\u00FC\u0178\u00FF" + "\u00C5\u00E5"
			+ "\u00C7\u00E7" + "\u0150\u0151\u0170\u0171";

	private static final String PLAIN_ASCII = "AaEeIiOoUu" // grave
			+ "AaEeIiOoUuYy" // acute
			+ "AaEeIiOoUuYy" // circumflex
			+ "AaOoNn" // tilde
			+ "AaEeIiOoUuYy" // umlaut
			+ "Aa" // ring
			+ "Cc" // cedilla
			+ "OoUu";

	/** The os. */
	public static final String OS = System.getProperty("os.name").toLowerCase();

	/** The Constant USERID. */
	public static final String USERID = "userId";

	/** The Constant USER_STATUS. */
	public static final String USER_STATUS = "userStatus";

	/** The Constant LOGGER. */
	private static final Logger LOGGER = LoggerFactory.getLogger(Util.class);

	private static final String PATH_MESSAGES = "spring/messages.xml";

	private static final int CONSTANT_CERO = 0;

	private static final String A = "\u00E1";

	public static final String ERROR = "Error";

	private static final long RUNTIME = 1000;

	static final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

	public Util() {
		super();
	}

	/**
	 * Gets the property.
	 *
	 * @param property
	 *            the property
	 * @return the property
	 */
	public static final String getProperty(String property) {
		String rst = "";
		try {
			Properties prop = PropertiesLoaderUtils.loadAllProperties("application.properties");
			if (property != null) {
				rst = prop.getProperty(property);

			}

		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return rst;
	}

	/**
	 * Gets the property.
	 *
	 * @param property
	 *            the property
	 * @return the property
	 */
	public static final String getMessagesProperty(String property) {
		String rst = "";
		try {
			Properties prop = PropertiesLoaderUtils.loadAllProperties("spring/languages/messages.properties");
			if (property != null) {
				rst = prop.getProperty(property);

			}

		} catch (IOException e) {
			LOGGER.error(e.getMessage(), e);
		}
		return rst;
	}

	/**
	 * Removes the session.
	 *
	 * @param name
	 *            the name
	 */
	public static final void removeSession(String name) {
		ServletRequestAttributes attr = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attr.getRequest();

		if (request != null && request.getSession().getAttribute(name) != null) {
			request.getSession().removeAttribute(name);
		}
	}

	/**
	 * Array string to long.
	 *
	 * @param userId
	 *            the user id
	 * @return the list
	 */
	public static final List<Long> arrayStringToLong(String userId) {
		List<String> users = Arrays.asList(userId.split("\\s*,\\s*"));
		List<Long> lista = new ArrayList<Long>();
		for (String user : users) {
			lista.add(Long.valueOf(user));
		}
		return lista;
	}

	/**
	 * Gets the separator folder.
	 *
	 * @return the separator folder
	 */
	public static final String getSeparatorFolder() {
		if (isWindows()) {
			return "\\";
		} else {
			return "/";
		}

	}

	/**
	 * Checks if is windows.
	 *
	 * @return true, if is windows
	 */
	public static final boolean isWindows() {

		return OS.indexOf("win") >= 0;

	}

	/**
	 * Checks if is unix.
	 *
	 * @return true, if is unix
	 */
	public static final boolean isUnix() {

		return OS.indexOf("nix") >= CONSTANT_CERO || OS.indexOf("nux") >= CONSTANT_CERO
				|| OS.indexOf("aix") > CONSTANT_CERO;

	}

	/**
	 * Format uses.
	 *
	 * @param uses
	 *            the uses
	 * @return the string
	 */
	public static final String formatUses(List<String> uses) {
		StringBuilder msg = new StringBuilder();

		for (String s : uses) {
			msg.append(s).append("<br/>");
		}

		return msg.toString();
	}

	/**
	 * Method that retrieves a long number from a string.
	 *
	 * @param string
	 *            the string
	 * @return Long
	 */
	public static Long getLongFromString(String string) {
		Pattern numbersPattern = Pattern.compile(ER_NUMBER);
		Long number = 0L;
		StringBuilder rst = new StringBuilder();
		if (string != null) {
			Matcher m = numbersPattern.matcher(string);
			while (m.find()) {
				rst.append(m.group());
			}
			if (!rst.toString().isEmpty()) {
				number += Long.parseLong(rst.toString());
			}

		}
		return number;
	}

	/**
	 * Method that retrieves a number from a string.
	 *
	 * @param string
	 *            the string
	 * @return String
	 */
	public static String getNumberFromString(String string) {
		Pattern numbersPattern = Pattern.compile(ER_NUMBER);
		StringBuilder number = new StringBuilder();
		StringBuilder rst = new StringBuilder();
		if (string != null) {
			Matcher m = numbersPattern.matcher(string);
			while (m.find()) {
				rst.append(m.group());
			}
			if (!rst.toString().isEmpty()) {
				number.append(rst.toString());
			}

		}
		return number.toString();
	}

	/**
	 * Method that retrieves an integer from a string.
	 *
	 * @param string
	 *            the string
	 * @return int
	 */
	public static int getIntFromString(String string) {
		Pattern namesPattern = Pattern.compile(ER_NUMBER);
		int nro = 0;
		StringBuilder rst = new StringBuilder();
		if (string != null) {
			Matcher m = namesPattern.matcher(string);
			while (m.find()) {
				rst.append(m.group());
			}
			if (!rst.toString().isEmpty()) {
				nro += Integer.parseInt(rst.toString());
			}

		}
		return nro;
	}

	/**
	 * Method that validates if the content of a string is numeric.
	 *
	 * @param string
	 *            the string
	 * @return boolean
	 */
	public static boolean isNumber(String string) {
		Pattern numbersPattern = Pattern.compile(ER_NUMBER);
		boolean rst = false;
		if (string != null && !"".equals(string)) {
			Matcher m = numbersPattern.matcher(string);
			if (m.matches()) {
				rst = true;
			}
		}
		return rst;
	}

	/**
	 * Methos to add an error to a modelAndView.
	 *
	 * @param bindingResult
	 *            the binding result
	 * @param filed
	 *            the filed
	 * @param message
	 *            the message
	 */
	public static void addError(BindingResult bindingResult, String filed, String message) {
		FieldError fieldError = new FieldError(bindingResult.getObjectName(), filed, message);
		bindingResult.addError(fieldError);
	}

	/**
	 * Gets the locale.
	 *
	 * @return the locale
	 */
	public static Locale getLocale() {
		return LocaleContextHolder.getLocale();
	}

	public static int getMaxElements(int start, int count) {
		int max = 0;
		if (start > 0) {
			max = count * start;
		}
		return max;
	}

	@SuppressWarnings({ "static-access" })
	public static String getMessage(String nameMessage, Object[] args) {
		ClassPathXmlApplicationContext classPathXmlApp = new ClassPathXmlApplicationContext(PATH_MESSAGES);
		try {
			return classPathXmlApp.getMessage(nameMessage, args, getLocale().getDefault());
		} catch (Exception e) {
			LOGGER.error("ERROR: {} {}", e.getMessage(), e);
		} finally {
			classPathXmlApp.close();
		}
		return "";
	}

	public static String getRandomText(int longitude) {
		String rst = "";
		int[][] words = new int[3][2];
		words[0][0] = 97;
		words[0][1] = 122;
		words[1][0] = 65;
		words[1][1] = 90;
		words[2][0] = 48;
		words[2][1] = 57;
		Random r = new Random();
		for (int i = 0; i < longitude; i++) {
			int fila = r.nextInt(words.length);
			rst += String.valueOf((int) (Math.random() * (words[fila][1] - words[fila][0])) + words[fila][0]);
		}
		LOGGER.info("getRandomText {} ", rst);
		return rst;
	}

	public static void addWhereParam(String name, String value, PaginateDTO paginate, String operator) {
		if (value != null && !value.isEmpty()) {
			paginate.getColumns().add(name);
			paginate.getValues().add(value);
			paginate.getOperators().add(operator);
		}
	}

	public static void addWhereParam(String name, Long value, PaginateDTO paginate, String operator) {
		if (value != null && value > 0L) {
			paginate.getColumns().add(name);
			paginate.getValues().add(value);
			paginate.getOperators().add(operator);
		}
	}

	public static void addWhereParamZero(String name, Long value, PaginateDTO paginate, String operator) {
		if (value != null) {
			paginate.getColumns().add(name);
			paginate.getValues().add(value);
			paginate.getOperators().add(operator);
		}
	}

	public static void addWhereParam(String name, List<?> value, PaginateDTO paginate, String operator) {
		if (value != null && !value.isEmpty()) {
			paginate.getColumns().add(name);
			paginate.getValues().add(value);
			paginate.getOperators().add(operator);
		}
	}

	public static String decodeHtmlISO88591(String cadena) {

		return cadena.replaceAll("&Aacute;", "\u00C1").replaceAll("&aacute;", A).replaceAll("&Eacute;", "\u00C9")
				.replaceAll("&eacute;", "\u00E9").replaceAll("&Iacute;", "\u00CD").replaceAll("&iacute;", "\u00ED")
				.replaceAll("&Oacute;", "\u00D3").replaceAll("&oacute;", "\u00F3").replaceAll("&Uacute;", "\u00DA")
				.replaceAll("&uacute;", "\u00FA").replaceAll("&Ntilde;", "\u00D1").replaceAll("&ntilde;", "\u00F1");

	}

	public static Long startRuntime() {
		return System.currentTimeMillis() / RUNTIME;
	}

	public static Long endRuntime(Long tiempoInicial) {
		Long tiempoFinal = System.currentTimeMillis() / RUNTIME;
		return tiempoFinal - tiempoInicial;
	}

	public static String formatDate(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
			return formatoFecha.format(fecha);
		}
		return "";

	}

	public static String formatDateLine(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("dd-MM-yyyy");
			return formatoFecha.format(fecha);
		} else {
			return null;
		}
	}

	public static String formatDateLineReverse(Date fecha) {
		if (fecha != null) {
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			return formatoFecha.format(fecha);
		} else {
			return null;
		}
	}

	public static Long dateToMiliseconds(String yyyyMMdd) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-M-dd hh:mm:ss");
		String dateInString = yyyyMMdd;
		Date date = sdf.parse(dateInString);
		return date.getTime();
	}

	public static String getSeparadorFolder() {
		if (isWindows()) {
			return "\\";
		} else {
			return "/";
		}

	}

	public static String removeSpecialChars(String string) {
		return string.replaceAll("\\?", "").replaceAll("\\$", "").replaceAll("\\%", "").replaceAll("\\#", "")
				.replaceAll("\\~", "").replaceAll("/", "").replaceAll("|", "").replaceAll("'", "").replaceAll("\\(", "")
				.replaceAll("\\)", "");

	}

	public static Integer[] stringListToIntegerArray(List<String> stringList) {
		List<Integer> integerArray = new ArrayList<Integer>();
		if (stringList != null) {
			for (String str : stringList) {
				if (str != null && str.length() < 10 && isNumber(str)) {

					integerArray.add(Integer.parseInt(str));

				}
			}
		}
		return integerArray.toArray(new Integer[0]);
	}

	public static <T> ModelAndView getGridList(PaginateDTO paginateDTO, Page<T> page) {

		return getGridListData(paginateDTO, page);
	}

	public static <T> ModelAndView getGridListNoAuth(PaginateDTO paginateDTO, Page<T> page) {
		return getGridListData(paginateDTO, page);
	}

	public static <T> ModelAndView getGridListData(PaginateDTO paginateDTO, Page<T> page) {
		if (page != null) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put(DRAW, paginateDTO.getDraw());
			map.put(RECORDS_TOTAL, page.getRowCount());
			map.put(RECORDS_FILTERED, page.getRowCount());
			map.put(DATA, page.getPageItems());
			JSONSerializer serializer = new JSONSerializer();

			serializer.include(DATA).include(DRAW).include(RECORDS_TOTAL).include(RECORDS_FILTERED).exclude("*.class")
					.exclude("*.clazz").transform(new DateTransformer("dd/MM/yyyy hh:mm:ss"), Date.class);
			return new ModelAndView(JSON, JSON, serializer.serialize(map));
		}
		return new ModelAndView(JSON, JSON, "");

	}

	public static boolean roleIntersection(Collection<GrantedAuthority> userRoles,
			Collection<GrantedAuthority> authorizationRole) {
		authorizationRole.retainAll(userRoles);
		return authorizationRole.size() > 0 ? true : false;
	}

	public static void excuteInternalUrl(HttpServletRequest request, String urlBloquearUsuario,
			NameValuePair[] parameters) {
		String[] partsUrl = request.getRequestURL().toString().split("/");
		String url = "http://";
		for (int i = 2; i < partsUrl.length - 1; i++) {
			if (i > 2) {
				url += "/";
			}
			url += partsUrl[i];
		}
		url += Util.getProperty(urlBloquearUsuario);

		PostMethod post = new PostMethod(url);

		post.addParameters(parameters);

		HttpClient client = new HttpClient();
		try {
			client.executeMethod(post);

		} catch (MalformedURLException e) {
			LOGGER.error("ERROR: ", e.getMessage());
		} catch (IOException e) {
			LOGGER.error("ERROR: {} ", e.getMessage());
		} finally {
			post.releaseConnection();
		}
	}

	public String getPathStaticFiles() {
		String jBossPath = System.getProperty("jboss.server.home.dir");
		String path = jBossPath.concat(getSeparatorFolder() + "deploy" + getSeparatorFolder() + "static.war");
		File estatico = new File(path);
		if (!estatico.exists()) {
			estatico.mkdir();
		}
		String pathWebInf = path.concat(getSeparatorFolder() + "WEB-INF");
		File webInf = new File(pathWebInf);
		if (!webInf.exists()) {
			webInf.mkdir();
		}

		return path;
	}

	public static String thePasswordIsValid(String password) {

		String response = "";
		if (password != null && password.length() < 6) {
			response = "Password must be greater than 6 characters";
		}

		return response;
	}

	public static String readURL(String path) throws MalformedURLException, IOException {
		URL url = new URL(path);
		BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
		StringBuffer response = new StringBuffer();
		String line;
		while ((line = in.readLine()) != null) {
			response.append(line);
		}
		return response.toString();
	}

	public static Long stringToLong(String str) {
		Pattern numberPattern = Pattern.compile("\\d+");
		Long number = 0L;
		String response = "";
		if (str != null) {
			Matcher m = numberPattern.matcher(str);
			while (m.find()) {
				response += m.group();
			}
			if (!response.equals("")) {
				number += Long.parseLong(response);
			}
		}
		return number;
	}

	public static int stringToInt(String str) {
		Pattern numberPattern = Pattern.compile("\\d+");
		int number = 0;
		String response = "";
		if (str != null) {
			Matcher m = numberPattern.matcher(str);
			while (m.find()) {
				response += m.group();
			}
			if (!response.equals("")) {
				number += Integer.parseInt(response);
			}
		}
		return number;
	}

	public String DecodeHtmlISO88591(String str) {

		String response = "";
		try {
			response = new String(str.getBytes("UTF-8"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			LOGGER.error("ERROR: {} {}", e.getMessage(), e);
		}

		response = str.replaceAll("&Aacute;", "\u00C1").replaceAll("&Aacute;", "\u00C1")
				.replaceAll("&aacute;", "\u00E1").replaceAll("&Eacute;", "\u00C9").replaceAll("&eacute;", "\u00E9")
				.replaceAll("&Iacute;", "\u00CD").replaceAll("&iacute;", "\u00ED").replaceAll("&Oacute;", "\u00D3")
				.replaceAll("&oacute;", "\u00F3").replaceAll("&Uacute;", "\u00DA").replaceAll("&uacute;", "\u00FA")
				.replaceAll("&Ntilde;", "\u00D1").replaceAll("&ntilde;", "\u00F1").replaceAll("&iquest;", "\u00bf");

		return response;
	}

	public static String decodeAccents(String str) {

		return str.replaceAll("&Aacute;", "A").replaceAll("&aacute;", "a").replaceAll("&Eacute;", "E")
				.replaceAll("&eacute;", "e").replaceAll("&Iacute;", "I").replaceAll("&iacute;", "i")
				.replaceAll("&Oacute;", "O").replaceAll("&oacute;", "o").replaceAll("&Uacute;", "U")
				.replaceAll("&uacute;", "u").replaceAll("&Ntilde;", "N").replaceAll("&ntilde;", "n");
	}

	public String formatMilesNumber(Long value) {
		String response = "";

		if ((value != null) && (value.longValue() > 0L)) {
			DecimalFormat num = new DecimalFormat("#,###");
			response = num.format(value);
		}

		return response;
	}

	public static boolean validateFormat(String input, String regex) {
		Pattern pattern = null;
		Matcher mat = null;
		boolean match = false;

		pattern = Pattern.compile(regex);
		mat = pattern.matcher(input);
		match = mat.matches();

		return match;
	}

	public static String dateToString(Date date) {
		String format = "dd/MM/yy";
		SimpleDateFormat dateFormat = new SimpleDateFormat(format);

		return dateFormat.format(date);
	}

	public static String convertNonAscii(String s) {
		if (s == null) {
			return null;
		}
		StringBuilder sb = new StringBuilder();
		int n = s.length();
		for (int i = 0; i < n; i++) {
			char c = s.charAt(i);
			int pos = UNICODE.indexOf(c);
			if (pos > -1) {
				sb.append(PLAIN_ASCII.charAt(pos));
			} else {
				sb.append(c);
			}
		}
		return sb.toString();
	}

	public static String normalizeString(String value) {

		if (value != null) {
			value = value.toLowerCase().trim().replaceAll(" +", " ");
			value = value.replaceAll(" ", "-");
			value = value.replaceAll("-+", "-");
			value = value.replaceAll("\u00E1", "a");
			value = value.replaceAll("\u00E9", "e");
			value = value.replaceAll("\u00ED", "i");
			value = value.replaceAll("\u00F3", "o");
			value = value.replaceAll("\u00FA", "u");
			value = value.replaceAll("\u00F1", "n");
			value = value.replaceAll("\u003C", "-");
			value = value.replaceAll("\u003E", "-");
			value = value.replaceAll("\u0021", "-");
			value = value.replaceAll("\u00BF", "-");
			value = value.replaceAll("[()$%#@,?:=*+_/]", "-");
			value = value.replaceAll("[&]", "y").replaceAll(" +", " ").replaceAll("-+", "-");

		}

		return value;
	}

	public static final String normalizeText(String pvalue) {
		String value = null;

		if (pvalue != null) {
			value = pvalue.toLowerCase().trim().replaceAll(" +", " ").replaceAll(" ", "-").replaceAll("-+", "-")
					.replaceAll(A, "a").replaceAll("\\.", "").replaceAll("\\+", "").replaceAll(ACCENT_E, "e")
					.replaceAll(ACCENT_I, "i").replaceAll(ACCENT_O, "o").replaceAll(ACCENT_U, "u")
					.replaceAll(ACCENT_N, "n").replaceAll(REGEX_GUION, "-").replaceAll(REGEX_ACCENT1, "-")
					.replaceAll(REGEX_ACCENT2, "-").replaceAll(REGEX_ACCENT3, "-").replaceAll(REGEX_CHARACTER, "-")
					.replaceAll("-{2,}", "-");
			value = value.startsWith("-") ? value.substring(1, value.length()) : value;
			value = value.endsWith("-") ? value.substring(0, value.length() - 1) : value;
		}

		return value;
	}

	/**
	 * Devuelve las palabras con la primera en mayuscula
	 *
	 * @param text
	 * @return
	 */
	public static String capitalize(String text) {
		if (text != null && !text.equals("")) {
			char[] stringArray = text.toLowerCase().toCharArray();
			stringArray[0] = Character.toUpperCase(stringArray[0]);
			return new String(stringArray);
		}
		return "";
	}

	public static String generateRandomText(int size) {
		String response = "";
		int letters[][] = new int[3][2];
		letters[0][0] = 97;
		letters[0][1] = 122;
		letters[1][0] = 65;
		letters[1][1] = 90;
		letters[2][0] = 48;
		letters[2][1] = 57;
		Random r = new Random();
		for (int i = 0; i < size; i++) {
			int row = r.nextInt(letters.length);
			response += (char) ((int) (Math.random() * (letters[row][1] - letters[row][0])) + letters[row][0]);
		}
		LOGGER.info("generateRandomText {} ", response);

		return response;
	}

	public static boolean validateId(String id) {
		if (id != null && !id.isEmpty() && !id.equals("0")) {
			return true;
		}
		return false;
	}

	public static PaginateDTO gerOrder(String orderBy) {

		PaginateDTO orderDTO = new PaginateDTO();
		if (orderBy != null && !orderBy.equals("")) {
			String[] partsOrder = orderBy.split(" ");
			if (partsOrder.length > 0) {
				orderDTO.setOrder(partsOrder[0]);
			}
			if (partsOrder.length > 1) {
				orderDTO.setOrderType(partsOrder[1]);
			}
		}
		return orderDTO;
	}

	public static List<SelectOptionsDTO> getStatus() {
		List<SelectOptionsDTO> selectStatus = new ArrayList<>();

		selectStatus.add(new SelectOptionsDTO("A", "Activo"));
		selectStatus.add(new SelectOptionsDTO("I", "Inactivo"));
		return selectStatus;
	}

	public static List<SelectOptionsDTO> getColumnType() {
		List<SelectOptionsDTO> select = new ArrayList<>();

		select.add(new SelectOptionsDTO("N", "Number"));
		select.add(new SelectOptionsDTO("I", "Varchar"));
		select.add(new SelectOptionsDTO("D", "Date"));
		return select;
	}

	public static List<SelectOptionsDTO> getBooleanList() {
		List<SelectOptionsDTO> select = new ArrayList<>();

		select.add(new SelectOptionsDTO("S", "Si"));
		select.add(new SelectOptionsDTO("N", "No"));
		return select;
	}

	public static List<SelectOptionsDTO> getTypeRol() {
		List<SelectOptionsDTO> selectRoleType = new ArrayList<>();

		selectRoleType.add(new SelectOptionsDTO("1", "Interno"));
		selectRoleType.add(new SelectOptionsDTO("2", "Externo"));
		return selectRoleType;
	}

	public static Date getParseDate(String date) {
		SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
		try {
			return sf.parse(date);
		} catch (Exception e) {
			LOGGER.error("Error fecha", e);
		}
		return null;

	}

	public static String getParseDateLocalDateTime(LocalDateTime ldt) {

		DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);

		try {
			return formmat1.format(ldt);
		} catch (Exception e) {
			LOGGER.error("Error fecha", e);
		}
		return null;

	}

	public static boolean isEmptyOrNull(String str) {
		if (str != null && !str.isEmpty()) {
			return false;
		}

		return true;
	}

	public static Date getParseDateWithFormatString(String date, String format) {
		SimpleDateFormat sf = new SimpleDateFormat(format);
		try {
			return sf.parse(date);
		} catch (Exception e) {
			LOGGER.error("Error fecha", e);
		}
		return null;

	}

	public static String getFormatDate(Date date) {
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ssZ");

			return df.format(date);

		} catch (Exception e) {
			LOGGER.error("Error fecha", e);
		}
		return "";
	}

	public static String randomStringPassword(int len) {
		SecureRandom rnd = new SecureRandom();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public static String getDateFormat(Date date) {
		return new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a").format(date);

	}

	public static String getDateFormat(Date date, String format) {
		return new SimpleDateFormat(format).format(date);
	}

	public static LocalDateTime formatLocalDateTime(String date) {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm a");
		return LocalDateTime.parse(date, formatter);
	}

	public static Date addDaysToDate(Date date, int days) {
		if (days == 0) {
			return date;
		}
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_YEAR, days);
		return calendar.getTime();
	}

	public static int daysBetweenDates(Date date1, Date date2) {
		return (int) ((date2.getTime() - date1.getTime()) / 86400000);
	}

	public static int getCurrentYear() {
		Calendar cal = Calendar.getInstance();
		return cal.get(Calendar.YEAR);
	}

	public static Timestamp StringToTimeStamp(String stringDate) {

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Timestamp timestamp = null;
		try {

			Date date = formatter.parse(stringDate);

			timestamp = new Timestamp(date.getTime());

		} catch (Exception e) {
			LOGGER.error("ERROR: {} ", e.getMessage());
		}

		return timestamp;
	}

}
