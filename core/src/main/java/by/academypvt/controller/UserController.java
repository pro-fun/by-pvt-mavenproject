package by.academypvt.controller;

import by.academypvt.api.controller.UserApi;
import by.academypvt.api.dto.UserRequest;
import by.academypvt.api.dto.UserResponse;
import by.academypvt.service.impl.UserServiceImpl;

public class UserController implements UserApi {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {

        this.userService = userService;
    }


    @Override
    public void registration(UserRequest userRequest) {

    }

    @Override
    public UserResponse authorization(String login, String password) {
        return null;
    }
}
