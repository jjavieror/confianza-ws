package co.com.ws.confianza.common.util.dto;

import java.io.Serializable;
import java.util.List;

/**
 * Clas para los menus.
 *
 * @author Didier Esteban Garcia Olave.
 * @copy Todos los derechos reservados .
 * @version 1.0
 */
public class MenuDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private String alias;

    private String name;

    private String url;

    private String aliasParent;

    private String aliasAuthorization;

    private String secHasPermission;
	private String secDomainObject;

	
    private transient List<MenuDTO> subMenus;

    private int typeAdmom;

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAliasParent() {
        return aliasParent;
    }

    public void setAliasParent(String aliasParent) {
        this.aliasParent = aliasParent;
    }

    public String getAliasAuthorization() {
        return aliasAuthorization;
    }

    public void setAliasAuthorization(String aliasAuthorization) {
        this.aliasAuthorization = aliasAuthorization;
    }

    public List<MenuDTO> getSubMenus() {
        return subMenus;
    }

    public void setSubMenus(List<MenuDTO> subMenus) {
        this.subMenus = subMenus;
    }

    public int getTypeAdmom() {
        return typeAdmom;
    }

    public void setTypeAdmom(int typeAdmom) {
        this.typeAdmom = typeAdmom;
    }

    
    public String getSecHasPermission() {
		return secHasPermission;
	}

	public void setSecHasPermission(String secHasPermission) {
		this.secHasPermission = secHasPermission;
	}

	public String getSecDomainObject() {
		return secDomainObject;
	}

	public void setSecDomainObject(String secDomainObject) {
		this.secDomainObject = secDomainObject;
	}

	@Override
	public String toString() {
		return "MenuDTO [alias=" + alias + ", name=" + name + ", url=" + url + ", aliasParent=" + aliasParent
				+ ", aliasAuthorization=" + aliasAuthorization + ", secHasPermission=" + secHasPermission
				+ ", secDomainObject=" + secDomainObject + ", typeAdmom=" + typeAdmom + "]";
	}

}
