package by.academypvt;

import by.academypvt.service.UserService;
import by.academypvt.service.impl.UserServiceImpl;

public class Main {
    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        userService.registration("user9", "123", "Igor","Petrov" );
        userService.registration("user10", "222", "Andrey","Semenov" );
        userService.usersInfo();
        userService.deleteClient(3);
        System.out.println("***********************");
        userService.usersInfo();



    }
}