package co.com.ws.confianza.dao.oauth.portal;

import co.com.ws.confianza.model.auth.portal.Portal;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PortalDAO extends JpaRepository<Portal, Long> {

}
