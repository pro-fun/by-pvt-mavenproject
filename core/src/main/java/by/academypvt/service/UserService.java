package by.academypvt.service;

import by.academypvt.domain.User;

public interface UserService {


    User registration(String login, String password, String name, String surname);
    void deleteClient(long clientId);
    void usersInfo();

}

