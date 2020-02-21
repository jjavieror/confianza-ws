package co.com.ws.confianza.common.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Clase de utilidad para la paginacion.
 *
 * @author Harley Aranda.
 * @copy Todos los derechos reservados.
 * @version 1.0
 */
public class PaginateDTO {

    private String draw;

    private String order;

    private String orderType;

    private String pageSize;

    private String pageNo;

    private List<String> columns;

    private List<Object> values;

    private List<String> operators;

    private String andOrd;

    private String prefixWhere;

    private List<String> totalElementsP;

    public PaginateDTO() {
        this.columns = new ArrayList<String>();
        this.values = new ArrayList<Object>();
        this.operators = new ArrayList<String>();
        this.pageSize = "10";
        this.pageNo = "1";
        this.andOrd = "and";
        this.prefixWhere = "";
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getPageSize() {
        return pageSize;
    }

    public void setPageSize(String pageSize) {
        this.pageSize = pageSize;
    }

    public String getPageNo() {
        return pageNo;
    }

    public void setPageNo(String pageNo) {
        this.pageNo = pageNo;
    }

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public List<Object> getValues() {
        return values;
    }

    public void setValues(List<Object> values) {
        this.values = values;
    }

    public List<String> getOperators() {
        return operators;
    }

    public void setOperators(List<String> operators) {
        this.operators = operators;
    }

    public String getDraw() {
        return draw;
    }

    public void setDraw(String draw) {
        this.draw = draw;
    }

    public String getAndOrd() {
        return andOrd;
    }

    public void setAndOrd(String andOrd) {
        this.andOrd = andOrd;
    }

    public String getPrefixWhere() {
        return prefixWhere;
    }

    public void setPrefixWhere(String prefixWhere) {
        this.prefixWhere = prefixWhere;
    }

    public List<String> getTotalElementsP() {
        return totalElementsP;
    }

    public void setTotalElementsP(List<String> totalElementsP) {
        this.totalElementsP = totalElementsP;
    }

    @Override
    public String toString() {
        return "PaginateDTO [draw=" + draw + ", order=" + order + ", orderType=" + orderType + ", pageSize=" + pageSize + ", pageNo=" + pageNo
                + ", columns=" + columns + ", values=" + values + ", operators=" + operators + ", andOrd=" + andOrd + ", prefixWhere=" + prefixWhere
                + ", totalElementsP=" + totalElementsP + "]";
    }

}
