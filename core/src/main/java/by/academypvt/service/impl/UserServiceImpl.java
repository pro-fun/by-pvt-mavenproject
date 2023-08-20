package by.academypvt.service.impl;


import by.academypvt.api.dto.user.UserRequest;
import by.academypvt.api.dto.user.UserResponse;
import by.academypvt.api.dto.good.Role;
import by.academypvt.domain.User;
import by.academypvt.exception.ClientException;
import by.academypvt.mapper.UserMapper;
import by.academypvt.repository.UserRepository;
import by.academypvt.service.UserService;

import java.util.List;
import java.util.stream.Collectors;


public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;


    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public void registration(UserRequest userRequest) {
        List<User> users = userRepository.allUsers();
        var user = userMapper.mapToUser(userRequest);

        boolean isLoginPresent = users.stream().anyMatch(user1 -> user1.getLogin().equals(user.getLogin()));
        if (isLoginPresent) {
            throw new ClientException("Введённый логин " + user.getLogin() + " уже занят. Введите другой логин.");
        }
        boolean isAdminPresent = users.stream().anyMatch(user2 -> user2.getRole().equals(Role.ADMIN));
        if (!isAdminPresent) {
            User user1 = new User(user.getName(), user.getSurname(), user.getLogin(), user.getPassword(),user.getRole());
            user1.setRole(Role.ADMIN);
            long id = 1L;
            if (!users.isEmpty()) {
                id = users.get(users.size() - 1).getUserid() + 1;
            }
            user.setUserid(id);
            userRepository.addUser(user1);
        }
        if (users==null){
            user.setUserid(1);
        }else{
        user.setUserid(users.get(users.size() - 1).getUserid() + 1);}
        userRepository.addUser(user);
    }

    @Override
    public UserResponse authorization(String login, String password) {
        List<User> users = userRepository.allUsers();
        User user = users.stream().filter(user1 -> user1.getLogin().equals(login)).findFirst().orElseThrow(() -> new ClientException("Пользователь с логином " + login + " не найден"));
        if (!user.getPassword().equals(password)) {
            throw new ClientException("Не верно введён пароль");
        }
        var userResponse =userMapper.mapFromUser(user);
        return userResponse;
    }

    public void deleteClient(long clientId) {
        userRepository.deleteUser(userRepository.getUserById(clientId));
    }

    public List<UserResponse> usersInfo() {
        return userRepository.allUsers().stream().map(userMapper::mapFromUser).collect(Collectors.toList());

    }

}
