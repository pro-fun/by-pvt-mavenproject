package by.academypvt.repository.jdbc;

import by.academypvt.api.dto.user.Role;
import by.academypvt.connection.ProjectConnection;
import by.academypvt.domain.User;
import by.academypvt.repository.UserRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryJdbc implements UserRepository {
    private final String FIND_BY_ID = "select * from shop.user u where u.id=?";
    private final String ADD_USER = "insert into shop.user (id, name, surname, login, password, role) values (?,?,?,?,?,?)";
    private final String MAX_ID = "select max(id) from shop.user";
    private final String DELETE_USER = "delete from shop.user u where u.id=?";
    private final String FIND_BY_LOGIN = "select * from shop.user u where u.login=?";


    private ProjectConnection postgresConnection;

    public UserRepositoryJdbc(ProjectConnection postgresConnection) {
        this.postgresConnection = postgresConnection;
    }

    @Override
    public List<User> allUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from shop.user");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                Role role = Role.valueOf(resultSet.getString(6));
                User user = new User(id, name, surname, login, password, role);
                users.add(user);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return users;
    }

    @Override
    public User getUserById(long clientId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, clientId);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = Integer.valueOf(resultSet.getString(1));
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                Role role = Role.valueOf(resultSet.getString(6));
                user = new User(id, name, surname, login, password, role);
            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public User addUser(User user) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementMax = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = statementMax.executeQuery();
            resultSet.next();
            var maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setString(2, user.getName());
            preparedStatement.setString(3, user.getSurname());
            preparedStatement.setString(4, user.getLogin());
            preparedStatement.setString(5, user.getPassword());
            preparedStatement.setString(6, String.valueOf(user.getRole()));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return user;
    }

    @Override
    public void deleteUser(Long userId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER);
            preparedStatement.setLong(1, userId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public User findByLogin(String userLogin) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_LOGIN);
            preparedStatement.setString(1, userLogin);
            ResultSet resultSet = preparedStatement.executeQuery();
            User user = null;
            while (resultSet.next()) {
                int id = Integer.valueOf(resultSet.getString(1));
                String name = resultSet.getString(2);
                String surname = resultSet.getString(3);
                String login = resultSet.getString(4);
                String password = resultSet.getString(5);
                Role role = Role.valueOf(resultSet.getString(6));
                user = new User(id, name, surname, login, password, role);
                            }
            return user;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
