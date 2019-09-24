package co.com.ws.confianza.business.user;

import co.com.ws.confianza.model.auth.user.User;

public interface UserService {

	void delete(Long id);

	User findById(Long id);

	User save(User user);

	User findEntityByUsername(String username);
}
