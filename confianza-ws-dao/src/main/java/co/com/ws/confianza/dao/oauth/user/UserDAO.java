package co.com.ws.confianza.dao.oauth.user;

import co.com.ws.confianza.model.auth.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDAO extends JpaRepository<User, Long> {
	
	 User findByUsernameIgnoreCase(String username);

}
