package co.com.ws.confianza.common.util.dto;


import java.io.Serializable;
import java.util.Date;

import co.com.ws.confianza.common.util.Util;

/**
 * Clas para los filtros por fechas
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class DatesDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Date startDate;

    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getStringStartDate() {
        return Util.formatDate(startDate);
    }

    public String getStringEndDate() {
        return Util.formatDate(endDate);
    }

    @Override
    public String toString() {
        return "DatesDTO [startDate=" + startDate + ", endDate=" + endDate + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
        result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        DatesDTO other = (DatesDTO) obj;
        if (endDate == null) {
            if (other.endDate != null) {
                return false;
            }
        } else if (!endDate.equals(other.endDate)) {
            return false;
        }
        if (startDate == null) {
            if (other.startDate != null) {
                return false;
            }
        } else if (!startDate.equals(other.startDate)) {
            return false;
        }
        return true;
    }

    public DatesDTO(Date startDate, Date endDate) {
        super();
        this.startDate = startDate;
        this.endDate = endDate;
    }

}
