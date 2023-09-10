package by.academypvt.service.impl;


import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.api.dto.user.Role;
import by.academypvt.domain.User;
import by.academypvt.exception.ClientException;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.UserService;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepositoryImpl, UserMapper userMapper) {
        this.userRepository = userRepositoryImpl;
        this.userMapper = userMapper;
    }

    @Override
    public void registration(UserRequest userRequest) throws SQLException {
        List<User> users = userRepository.allUsers();
        var user = userMapper.mapToUser(userRequest);
        boolean isLoginPresent = users.stream().anyMatch(user1 -> user1.getLogin().equals(user.getLogin()));
        if (isLoginPresent) {
            throw new ClientException("Введённый логин " + user.getLogin() + " уже занят. Введите другой логин.");
        }
        boolean isAdminPresent = users.stream().anyMatch(user2 -> user2.getRole().equals(Role.ADMIN));
        if (!isAdminPresent) {
            User user1 = new User(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(), user.getRole());
            user1.setRole(Role.ADMIN);
            long id = 1L;
            if (!users.isEmpty()) {
                id = users.get(users.size() - 1).getUserid() + 1;
            }
            user.setUserid(id);
            userRepository.addUser(user1);
        }
        if (users == null) {
            user.setUserid(1);
        }
        userRepository.addUser(user);
    }

    @Override
    public UserResponse authorization(String login, String password) {
        User user = userRepository.findByLogin(login);
        if (user.getPassword().equals(password)) {
            var userResponse = userMapper.mapFromUser(user);
            return userResponse;
        } else return null;
    }

    public void deleteClient(long clientId) {
        userRepository.deleteUser(userRepository.getUserById(clientId).getUserid());
    }

    public List<UserResponse> usersInfo() throws SQLException {
        return userRepository.allUsers().stream().map(userMapper::mapFromUser).collect(Collectors.toList());
    }

    @Override
    public UserResponse findUserById(Long id) {
        return userMapper.mapFromUser(userRepository.getUserById(id));
    }

    @Override
    public void deleteUser(Long userid) {
        userRepository.deleteUser(userid);
    }
}
