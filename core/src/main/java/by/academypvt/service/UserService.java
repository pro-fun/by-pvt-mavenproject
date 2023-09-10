package by.academypvt.service;

import by.academypvt.api.dto.good.GoodResponse;
import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;

import java.sql.SQLException;
import java.util.List;

public interface UserService {


    void registration(UserRequest userRequest) throws SQLException;
    UserResponse authorization(String login, String password) throws SQLException;
    List<UserResponse> usersInfo() throws SQLException;
    UserResponse findUserById(Long id);
    void deleteUser(Long userid);
}

