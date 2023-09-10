package by.academypvt.service;

import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;

import java.util.List;

public interface UserService {


    void registration(UserRequest userRequest);
    UserResponse authorization(String login, String password);
    List<UserResponse> usersInfo();

}

