package by.academypvt.service.impl;


import by.academypvt.domain.Role;
import by.academypvt.domain.User;
import by.academypvt.exception.ClientException;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.UserService;

import java.util.List;


public class UserServiceImpl implements UserService {
    private UserRepository userRepository;


    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User registration(String login, String password, String name, String surname) {
        List<User> users = userRepository.allUsers();
        boolean isLoginPresent = users.stream().anyMatch(user1 -> user1.getLogin().equals(login));
        if (isLoginPresent) {
            throw new ClientException("Введённый логин " + login + " уже занят. Введите другой логин.");
        }
        boolean isAdminPresent = users.stream().anyMatch(user2 -> user2.getRole().equals(Role.ADMIN));
        if (!isAdminPresent) {
            User user = new User(name, surname, login, password);
            user.setRole(Role.ADMIN);
            long id = 1L;
            if (!users.isEmpty()) {
                id = users.get(users.size() - 1).getUserid() + 1;
            }
            user.setUserid(id);
            return userRepository.addUser(user);
        }
        User user = new User(name, surname, login, password);
        user.setRole(Role.USER);
        user.setUserid(users.get(users.size() - 1).getUserid() + 1);
        return userRepository.addUser(user);
    }

    public void deleteClient(long clientId) {
        userRepository.deleteUser(userRepository.getUserById(clientId));
    }

    public void usersInfo() {
        System.out.println(userRepository.allUsers().toString());
    }

}
