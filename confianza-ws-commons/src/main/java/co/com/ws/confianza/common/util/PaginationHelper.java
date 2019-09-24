package co.com.ws.confianza.common.util;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

/**
 * Clase que serializa las consultas paginadas.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class PaginationHelper<E> {

    public <T> Page<T> fetchPage(final NamedParameterJdbcTemplate jt, final String sqlCountRows, final String sqlFetchRows,
            final MapSqlParameterSource mapParameters, final int pageNo, final int pageSize, final RowMapper<T> rowMapper) {

        // Determine how many rows are available
        final int rowCount = jt.queryForObject(sqlCountRows, mapParameters, Integer.class);

        // Calculate the number of pages
        int pageCount = rowCount / pageSize;
        if (rowCount > pageSize * pageCount) {
            pageCount++;
        }

        // Create the page object
        final Page<T> page = new Page<T>();
        page.setPageNumber(pageNo);
        page.setPagesAvailable(pageCount);
        page.setRowCount(rowCount);

        // Fetch a single page of results
        final int startRow = (pageNo - 1) * pageSize;
        
        jt.query(sqlFetchRows, mapParameters, new ResultSetExtractor<Object>() {

            @Override
            public Object extractData(ResultSet rs) throws SQLException, DataAccessException {
                final List<T> pageItems = page.getPageItems();
                int currentRow = 0;
                while (rs.next() && currentRow < startRow + pageSize) {
                    if (currentRow >= startRow) {
                        pageItems.add(rowMapper.mapRow(rs, currentRow));
                    }
                    currentRow++;
                }
                return page;
            }
        });
        return page;
    }

}
