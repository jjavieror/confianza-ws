package co.com.ws.confianza.service;

import co.com.ws.confianza.model.auth.user.User;

public interface SecurityService {

    String findLoggedInUsername();

    void autologin(String username, String password);

    User getCurrentUser();

}
