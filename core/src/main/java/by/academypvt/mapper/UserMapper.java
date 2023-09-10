package by.academypvt.mapper;

import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.domain.User;


public class UserMapper {
    public User mapToUser(UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getSurname(), userRequest.getLogin(), userRequest.getPassword(), userRequest.getRole());
        return user;
    }

    public UserResponse mapFromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setUserid(user.getUserid());
        userResponse.setName(user.getName());
        userResponse.setLogin(user.getLogin());
        userResponse.setRole(user.getRole());
        return userResponse;
    }

}
