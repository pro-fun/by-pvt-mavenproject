package by.academypvt.repository;

import by.academypvt.domain.User;

import java.sql.SQLException;
import java.util.List;

public interface UserRepository {
    List<User> allUsers() throws SQLException;
    User getUserById(long clientId);
    User addUser(User user);
     void deleteUser(Long userId);
    User findByLogin(String userLogin);
}
