package by.academypvt;

import by.academypvt.domain.User;
import by.academypvt.repository.impl.UserRepositoryImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        UserRepositoryImpl userRepositoryImpl = new UserRepositoryImpl();
        List<User> users = userRepositoryImpl.allUsers();
        for (User user1: users) {
            System.out.println(user1.toString());

        }

    }
}