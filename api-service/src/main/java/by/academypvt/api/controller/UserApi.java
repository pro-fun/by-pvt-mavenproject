package by.academypvt.api.controller;

import by.academypvt.api.dto.UserRequest;
import by.academypvt.api.dto.UserResponse;

public interface UserApi {
    void registration(UserRequest userRequest);
    UserResponse authorization(String login, String password);
}
