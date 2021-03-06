package co.com.ws.confianza.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase que maneja las consultas paginadas.
 *
 * @author Harley Aranda .
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class Page<E> {

    private int pageNumber;

    private int pagesAvailable;

    private int rowCount;

    private List<E> pageItems = new ArrayList<E>();

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public void setPagesAvailable(int pagesAvailable) {
        this.pagesAvailable = pagesAvailable;
    }

    public void setPageItems(List<E> pageItems) {
        this.pageItems = pageItems;
    }

    public int getPageNumber() {
        return pageNumber;
    }

    public int getPagesAvailable() {
        return pagesAvailable;
    }

    public List<E> getPageItems() {
        return pageItems;
    }

    public int getRowCount() {
        return rowCount;
    }

    public void setRowCount(int rowCount) {
        this.rowCount = rowCount;
    }

}