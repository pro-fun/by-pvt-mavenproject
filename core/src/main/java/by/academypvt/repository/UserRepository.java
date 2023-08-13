package by.academypvt.repository;


import by.academypvt.domain.User;
import by.academypvt.exception.ClientException;

import java.util.ArrayList;
import java.util.List;

public class UserRepository extends FileWorker {
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
        User user = (User) users.stream().filter(user1 -> user1.getUserid()==clientId).findFirst().orElseThrow(()->new ClientException("Пользователь с логином " + clientId + "не найден"));
        return user;
    }


    public User addUser(User user) {
        users = allUsers();
        users.add(user);
        serializeObject(users, PATH);
        return user;
    }
    public void deleteUser(User user){
        users = allUsers();
        users.remove(user);
        serializeObject(users, PATH);
    }
}
