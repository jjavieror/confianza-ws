package co.com.ws.confianza.business.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.com.ws.confianza.dao.oauth.user.UserDAO;
import co.com.ws.confianza.model.auth.user.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void delete(Long id) {
		userDAO.deleteById(id);
	}

	@Override
	public User findById(Long id) {
		return userDAO.getOne(id);
	}

	@Override
	public User save(User user) {
		if (user.getPassword() != null) {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		}
		// TODO fechas de registro y actualizacion

		return userDAO.saveAndFlush(user);
	}

	@Override
	@Transactional(readOnly = true)
	public User findEntityByUsername(String username) {
		return userDAO.findByUsernameIgnoreCase(username);
	}

}
