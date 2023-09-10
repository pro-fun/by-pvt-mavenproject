package by.academypvt.repository.impl;


import by.academypvt.domain.User;
import by.academypvt.exception.ClientException;
import by.academypvt.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl extends FileWorker implements UserRepository {
    private static List<User> users = new ArrayList<>();
    public static String PATH = "C:\\Users\\pprof\\by-pvt-mavenproject\\core\\src\\main\\resources\\users";

    public void saveChangesWithUsers(List<User> users){
        serializeObject(users, PATH);
    }
    public List<User> allUsers() {
        Object object = deserializeObject(PATH);
        List<User> users = new ArrayList<>();
        if ((object instanceof List<?>)) {
            users = (List<User>) object;
        }
        return users;
    }
    public User getUserById(long clientId){
        List<User> users = allUsers();
        User user = (User) users.stream().filter(user1 -> user1.getUserid()==clientId).findAny().orElseThrow(()->new ClientException("Пользователь с логином " + clientId + "не найден"));
        return user;
    }


    public User addUser(User user) {
        users = allUsers();
        users.add(user);
        serializeObject(users, PATH);
        return user;
    }
    public void deleteUser(Long userId){
        users = allUsers();
        users.remove(userId);
        serializeObject(users, PATH);
    }

    @Override
    public User findByLogin(String userLogin) {
        return null;
    }


    public User findByLogin(String login, String password){
        List<User> thisUsers = allUsers();
        User user = (User)thisUsers.stream().filter(user1 -> user1.getLogin().equals(login)).findAny().orElseThrow((() -> new ClientException("Пользователь с логином " + login + " не найден")));
        if (!user.getPassword().equals(password)) {
            throw new ClientException("Не верно введён пароль");
        }
        return user;
    }
}
