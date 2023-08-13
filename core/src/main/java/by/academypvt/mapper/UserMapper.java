package by.academypvt.mapper;

import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.domain.User;

public class UserMapper {
    public User mapToUser(UserRequest userRequest) {
        User user = new User(userRequest.getName(), userRequest.getSurname(), userRequest.getLogin(), userRequest.getPassword());
        return user;
    }

    public UserResponse mapFromUser(User user) {
        UserResponse userResponse = new UserResponse();
        userResponse.setName(user.getName());
        userResponse.setFullName(user.getSurname());
        userResponse.setLogin(user.getLogin());
        return userResponse;
    }

}
