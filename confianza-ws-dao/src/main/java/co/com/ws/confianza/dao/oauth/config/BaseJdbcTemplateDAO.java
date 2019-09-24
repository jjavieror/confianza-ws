package co.com.ws.confianza.dao.oauth.config;

import java.text.SimpleDateFormat;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import co.com.ws.confianza.common.util.Util;


/**
 * Clase para los DAOS intelcostbpms de jdbctemplate.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados.
 * @version 1.0
 */
public class BaseJdbcTemplateDAO {

    @Autowired
    private Util util;

    private JdbcTemplate jdbcTemplate;

    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    private SimpleDateFormat formatDate;

    public static final String OUT_SALIDA = "SALIDA";

    @Autowired
    public void init(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        formatDate = new SimpleDateFormat("dd/MM/yyyy", LocaleContextHolder.getLocale());
        jdbcTemplate.setResultsMapCaseInsensitive(false);
    }

    /**
     * @return the util
     */
    public final Util getUtil() {
        return util;
    }

    /**
     * @param util the util to set
     */
    public final void setUtil(Util utilParam) {
        this.util = utilParam;
    }

    /**
     * @return the jdbcTemplate
     */
    public final JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    /**
     * @param jdbcTemplate the jdbcTemplate to set
     */
    public final void setJdbcTemplate(JdbcTemplate sJdbcTemplate) {
        this.jdbcTemplate = sJdbcTemplate;
    }

    public SimpleDateFormat getFormatDate() {
        return formatDate;
    }

    public void setFormatDate(SimpleDateFormat formatDate) {
        this.formatDate = formatDate;
    }

    public NamedParameterJdbcTemplate getNamedParameterJdbcTemplate() {
        return namedParameterJdbcTemplate;
    }

    public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
    }

}
