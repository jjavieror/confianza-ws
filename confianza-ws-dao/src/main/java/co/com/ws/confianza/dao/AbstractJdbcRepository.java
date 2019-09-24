package co.com.ws.confianza.dao;

import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;

import co.com.ws.confianza.common.util.Constant;
import co.com.ws.confianza.common.util.Page;
import co.com.ws.confianza.common.util.PaginateDTO;
import co.com.ws.confianza.common.util.PaginationHelper;
import co.com.ws.confianza.common.util.Util;
import co.com.ws.confianza.common.util.dto.SelectOptionsDTO;
import co.com.ws.confianza.dao.rowmapper.SelectOptionsRowMapper;

/**
 * Clase abstracta para los DAOS intelcostbpms de jdbctemplate.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados.
 * @version 1.0
 */
public abstract class AbstractJdbcRepository extends BaseJdbcTemplateDAO {

	private static final Logger LOGGER = LoggerFactory.getLogger(AbstractJdbcRepository.class);

	private static final String GENERIC_BEAN_QUERY = "queriesGeneric";

	protected static final Object PAGINATE_QUERY = "PAGINATE_QUERY";

	private String beanQueries;

	private Map<String, String> queryMap = null;

	private Map<String, String> genericQueryMap = null;

	@Autowired
	private ApplicationContext applicationContext;

	private static final String CONTADOR_SESSION_PAGES = "ContadorSessionPages";

	private static final String PAGINATE_SESSION_PAGES = "PaginateSessionPages";

	/**
	 * Instantiates a new abstract jdbc repository.
	 *
	 * @param rowMapper
	 *            the row mapper
	 * @param updater
	 *            the updater
	 * @param tableName
	 *            the table name
	 * @param idColumn
	 *            the id column
	 * @param jdbcTemplate
	 *            the jdbc template
	 */

	public AbstractJdbcRepository(String beanQueries) {

		this.beanQueries = beanQueries;

	}

	@SuppressWarnings("unchecked")

	public void initParams() {

		if (this.beanQueries != null && getApplicationContext() != null) {

			this.queryMap = (Map<String, String>) getApplicationContext().getBean(this.beanQueries);
		}

		this.genericQueryMap = (Map<String, String>) getApplicationContext().getBean(GENERIC_BEAN_QUERY);
	}

	public <T> List<T> findAll(String query, MapSqlParameterSource mapParameters, RowMapper<T> rowMapper) {

		return getNamedParameterJdbcTemplate().query(query, mapParameters, rowMapper);
	}

	public <T> T findObjectBean(String nameQuery, MapSqlParameterSource mapParameters, RowMapper<T> rowMapper) {

		T item = null;
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {

			try {
				StringBuilder query = new StringBuilder(String.format(getQueryMap().get(nameQuery)));

				List<T> results = getNamedParameterJdbcTemplate().query(query.toString(), mapParameters, rowMapper);
				boolean data = results != null && results.getClass() != null && !results.isEmpty();
				if (data && results.getClass().getName() != null && results.get(0) != null) {
					item = DataAccessUtils.requiredSingleResult(results);
				}
			} catch (DataAccessException e) {
				LOGGER.error("Error findAllBean ", e);
			}

		}
		return item;
	}

	public <T> List<T> findAllBean(String nameQuery, MapSqlParameterSource mapParameters, RowMapper<T> rowMapper) {

		LOGGER.debug("nameQuery");
		List<T> list = null;
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {

			try {
				StringBuilder query = new StringBuilder(String.format(getQueryMap().get(nameQuery), ""));
				LOGGER.debug("query {} ", query);
				list = getNamedParameterJdbcTemplate().query(query.toString(), mapParameters, rowMapper);
			} catch (DataAccessException e) {
				LOGGER.error("Error findAllBean ", e);
			}

		}
		return list;
	}

	public List<SelectOptionsDTO> findAllSelectOptions(String id, String name, String tableName) {
		StringBuilder query = new StringBuilder(
				String.format(getGenericQueryMap().get("findAllSelectOptions"), id, name, tableName.toUpperCase()));

		return getNamedParameterJdbcTemplate().query(query.toString(), new MapSqlParameterSource(),
				new SelectOptionsRowMapper());
	}

	public List<SelectOptionsDTO> findAllSelectOptions(String id, String name, String tableName, String columnInclude,
			String valueInclude) {
		StringBuilder query = new StringBuilder(
				String.format(getGenericQueryMap().get("findAllSelectOptions"), id, name, tableName.toUpperCase()));

		MapSqlParameterSource msp = new MapSqlParameterSource();
		if (columnInclude != null && valueInclude != null) {
			query.append(" where " + columnInclude + " = :" + columnInclude);
			msp.addValue(columnInclude, valueInclude);

		}

		return getNamedParameterJdbcTemplate().query(query.toString(), msp, new SelectOptionsRowMapper());
	}

	public Long getNumber(String query) {
		return getJdbcTemplate().queryForObject(query, Long.class);
	}

	public Long getNumberWithParams(String query, MapSqlParameterSource mapParameters) {
		try {
			LOGGER.debug("query  getNumberWithParams {}", query);
			List<Long> results = getNamedParameterJdbcTemplate().queryForList(query, mapParameters, Long.class);
			if (validateLongResult(results)) {
				return DataAccessUtils.longResult(results);
			}

			return countLong(results);

		} catch (DataAccessException e) {
			LOGGER.error("Error getNumberWithParams ", e);
		}
		return 0L;

	}

	public List<Long> getNumberListWithParamsBean(String nameQuery, MapSqlParameterSource mapParameters) {
		List<Long> result = Collections.emptyList();
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {
			try {
				StringBuilder query = new StringBuilder(getQueryMap().get(nameQuery));

				result = getNamedParameterJdbcTemplate().queryForList(query.toString(), mapParameters, Long.class);
			} catch (DataAccessException e) {
				LOGGER.error("Error getNumberListWithParamsBean ", e);
			}
		}
		return result;
	}

	public String getStringWithParams(String query, MapSqlParameterSource mapParameters) {
		return getNamedParameterJdbcTemplate().queryForObject(query, mapParameters, String.class);
	}

	public String getStringWithParamsBean(String nameQuery, MapSqlParameterSource mapParameters) {
		String rst = "";
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {
			try {
				StringBuilder query = new StringBuilder(String.format(getQueryMap().get(nameQuery)));

				List<String> results = getNamedParameterJdbcTemplate().queryForList(query.toString(), mapParameters,
						String.class);
				rst = countString(results);

			} catch (DataAccessException e) {
				LOGGER.error("Error getNumberWithParamsBean ", e);
			}

		}
		return rst;

	}

	public int update(String query, MapSqlParameterSource mapParameters) {
		return getNamedParameterJdbcTemplate().update(query, mapParameters);
	}

	public Long getNumberWithParamsBean(String nameQuery, MapSqlParameterSource mapParameters) {
		Long rst = 0L;
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {
			try {
				StringBuilder query = new StringBuilder(String.format(getQueryMap().get(nameQuery)));
				List<Long> results = getNamedParameterJdbcTemplate().queryForList(query.toString(), mapParameters,
						Long.class);
				rst = countLong(results);

			} catch (DataAccessException e) {
				LOGGER.error("Error getNumberWithParamsBean ", e);
			}

		}
		return rst;
	}

	public List<String> getStringListWithParamsBean(String nameQuery, MapSqlParameterSource mapParameters) {
		List<String> result = Collections.emptyList();
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {
			try {
				StringBuilder query = new StringBuilder(getQueryMap().get(nameQuery));

				result = getNamedParameterJdbcTemplate().queryForList(query.toString(), mapParameters, String.class);
			} catch (DataAccessException e) {
				LOGGER.error("Error getStringListWithParamsBean ", e);
			}
		}
		return result;
	}

	private Long countLong(List<Long> results) {
		Long rst = 0L;
		if (validateLongResult(results)) {
			rst = DataAccessUtils.longResult(results);
		}
		return rst;
	}

	private String countString(List<String> results) {
		String rst = "";
		if (validateStringResult(results)) {
			rst = results.get(0);
		}
		return rst;
	}

	private boolean validateLongResult(List<Long> results) {
		boolean data = results != null && results.getClass() != null && !results.isEmpty();
		return data && results.getClass().getName() != null && results.get(0) != null;
	}

	private boolean validateStringResult(List<String> results) {
		boolean data = results != null && results.getClass() != null && !results.isEmpty();
		return data && results.getClass().getName() != null && results.get(0) != null;
	}

	public int updateQueryBean(String nameQuery, MapSqlParameterSource mapParameters) {
		int rst = 0;
		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null) {
			try {
				StringBuilder query = new StringBuilder(String.format(getQueryMap().get(nameQuery)));
				rst = getNamedParameterJdbcTemplate().update(query.toString(), mapParameters);

			} catch (DataAccessException e) {
				LOGGER.error("Error updateQueryBean ", e);
			}
		}
		return rst;
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public <T> Page findPaginate(String nameQueryCount, String nameQuery, PaginateDTO paginateDTO,
			RowMapper<T> rowMapper) {

		MapSqlParameterSource mapParameters = new MapSqlParameterSource();
		StringBuilder whereParams = new StringBuilder();
		if (paginateDTO.getColumns() != null && paginateDTO.getValues() != null && paginateDTO.getOperators() != null
				&& !paginateDTO.getColumns().isEmpty() && !paginateDTO.getValues().isEmpty()
				&& !paginateDTO.getOperators().isEmpty()) {

			whereParams.append(" WHERE ");
			LOGGER.debug("paginateDTO.getColumns().size()----------------- {} ", paginateDTO.getColumns());

			for (int j = 0; j < paginateDTO.getColumns().size(); j++) {
				if (j > 0) {
					whereParams.append(" ").append(paginateDTO.getAndOrd()).append(" ");
				}

				if (paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_IN)) {
					whereParams.append(paginateDTO.getPrefixWhere()).append(paginateDTO.getColumns().get(j)).append(" ")
							.append(Constant.OPERATOR_IN).append(" (:").append(paginateDTO.getColumns().get(j))
							.append(")'");
					mapParameters.addValue(paginateDTO.getColumns().get(j), paginateDTO.getValues().get(j));
				} else if (paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_LIKE)) {
					whereParams.append(paginateDTO.getPrefixWhere()).append(paginateDTO.getColumns().get(j))
							.append(" like ").append(":").append(paginateDTO.getColumns().get(j));
					mapParameters.addValue(paginateDTO.getColumns().get(j), "%" + paginateDTO.getValues().get(j) + "%");
				} else if (paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_LIKE_WITH_UPPER)) {
					whereParams.append(paginateDTO.getPrefixWhere())
							.append("UPPER(" + paginateDTO.getColumns().get(j) + ")").append(" like ").append(":")
							.append(paginateDTO.getColumns().get(j));
					mapParameters.addValue(paginateDTO.getColumns().get(j), "%" + paginateDTO.getValues().get(j) + "%");
				} else if (paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_EQUAL_WITH_MONTH_FUNCTION)) {
					LOGGER.debug("OPERATOR_MONTH FUNCTION ----------------- {}",
							paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_EQUAL_WITH_MONTH_FUNCTION));
					whereParams.append(paginateDTO.getPrefixWhere())
							.append("CONCAT(MONTH(" + paginateDTO.getColumns().get(j) + "),'/',YEAR("
									+ paginateDTO.getColumns().get(j) + "))")
							.append(" = ").append(":").append(paginateDTO.getColumns().get(j));
					mapParameters.addValue(paginateDTO.getColumns().get(j), paginateDTO.getValues().get(j));
				} else if (paginateDTO.getOperators().get(j).equals(Constant.OPERATOR_NOT_EQUAL)) {
					whereParams.append(paginateDTO.getPrefixWhere()).append(paginateDTO.getColumns().get(j))
							.append(paginateDTO.getOperators().get(j)).append(":")
							.append(paginateDTO.getColumns().get(j));
					mapParameters.addValue(paginateDTO.getColumns().get(j), paginateDTO.getValues().get(j));
				} else {
					LOGGER.debug("OPERATOR_EQUALS----------------- ");
					whereParams.append(paginateDTO.getPrefixWhere()).append(paginateDTO.getColumns().get(j))
							.append(paginateDTO.getOperators().get(j)).append(" :")
							.append(paginateDTO.getColumns().get(j));
					mapParameters.addValue(paginateDTO.getColumns().get(j), paginateDTO.getValues().get(j));
					LOGGER.debug("Value columna----- {} ", paginateDTO.getValues().get(j));
					LOGGER.debug("OPERATOR_EQUALS----------------- {} ", whereParams);
				}

			}
		}

		if (getQueryMap() != null && getQueryMap().get(nameQuery) != null
				&& getQueryMap().get(nameQueryCount) != null) {
			StringBuilder query = new StringBuilder(
					String.format(getQueryMap().get(nameQuery), whereParams.toString()));
			StringBuilder queryCount = new StringBuilder(
					String.format(getQueryMap().get(nameQueryCount), whereParams.toString()));

			if (paginateDTO.getOrder() != null && !paginateDTO.getOrder().isEmpty()) {
				query.append(" ORDER BY ").append(paginateDTO.getOrder());
				if (paginateDTO.getOrderType() != null && !paginateDTO.getOrderType().isEmpty()) {
					query.append(" ").append(paginateDTO.getOrderType());
				}
			}
			PaginationHelper ph = new PaginationHelper();
			LOGGER.debug("query {} ", query);
			return ph.fetchPage(getNamedParameterJdbcTemplate(), queryCount.toString(), query.toString(), mapParameters,
					Util.stringToInt(paginateDTO.getPageNo()), Util.stringToInt(paginateDTO.getPageSize()), rowMapper);
		} else {
			LOGGER.error("No se encontraron los queries nameQuery {}  y {} ", nameQuery, nameQueryCount);
			return null;
		}

	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public void setApplicationContext(ApplicationContext applicationContext) {

		this.applicationContext = applicationContext;
	}

	public String getBeanQueries() {
		return beanQueries;
	}

	public void setBeanQueries(String beanQueries) {
		this.beanQueries = beanQueries;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getQueryMap() {

		if (this.queryMap == null && getApplicationContext() != null && this.beanQueries != null) {

			this.queryMap = (Map<String, String>) getApplicationContext().getBean(this.beanQueries);
		}

		return this.queryMap;

	}

	public void setQueryMap(Map<String, String> queryMap) {
		this.queryMap = queryMap;
	}

	@SuppressWarnings("unchecked")
	public Map<String, String> getGenericQueryMap() {

		if (this.genericQueryMap == null && getApplicationContext() != null) {
			this.genericQueryMap = (Map<String, String>) getApplicationContext().getBean(GENERIC_BEAN_QUERY);
		}

		return genericQueryMap;
	}

	public void setGenericgetQueryMap(Map<String, String> genericQueryMap) {
		this.genericQueryMap = genericQueryMap;
	}

	public void setDates(Date startDate, Date endDate, MapSqlParameterSource mapSqlParameterSource,
			String nameStartDate, String nameEndDate) {
		Date newEndDate = endDate;
		Date newStartDate = startDate;
		if (startDate == null) {
			Calendar c = Calendar.getInstance();
			newStartDate = c.getTime();
			newEndDate = c.getTime();
		}

		mapSqlParameterSource.addValue(nameStartDate, Util.formatDate(newStartDate));
		mapSqlParameterSource.addValue(nameEndDate, Util.formatDate(newEndDate));
	}

	public String getNameCountSessionPages() {

		return this.getClass().getSimpleName().concat(CONTADOR_SESSION_PAGES);

	}

	public String getPaginateCountSessionPages() {

		return this.getClass().getSimpleName().concat(PAGINATE_SESSION_PAGES);

	}

	public void delete(String query) {
		getJdbcTemplate().execute(query);
	}

}
