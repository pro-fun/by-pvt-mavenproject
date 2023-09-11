package by.academypvt.repository.jdbc;

import by.academypvt.api.dto.order.State;
import by.academypvt.connection.ProjectConnection;
import by.academypvt.domain.Order;
import by.academypvt.repository.OrderRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class OrderRepositoryJdbc implements OrderRepository {
    private final String FIND_BY_ID = "select * from shop.order o where o.id=?";
    private final String FIND_BY_USERID = "select * from shop.order o where o.userid=?";
    private final String FIND_BY_USERID_AND_STATE = "select * from shop.order o where o.userid=? and o.state=?";
    private final String ADD_ORDER = "insert into shop.order (id, userid, cost, state) values (?,?,?,?)";
    private final String MAX_ID = "select max(id) from shop.order";
    private final String DELETE_ORDER = "delete from shop.order o where o.id=?";
    private final String TO_CHANGE_ORDER_STATE = "update shop.order set state=? where id=?";
    private final String TO_FIND_PRODUCT_PRICE = "SELECT * from shop.good where id=?";

    private final String TO_CHANGE_ORDER_COST = "update shop.order set cost=? where id=?";
    private final String FIND_BY_BASKETID = "select * from shop.order o join shop.basket b on b.orderid=o.id where b.id=? ";
    private ProjectConnection postgresConnection;


    public OrderRepositoryJdbc(ProjectConnection postgresConnection) {
        this.postgresConnection = postgresConnection;

    }

    @Override
    public List<Order> allOrders() {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from shop.order");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Long userId = Long.valueOf(resultSet.getString(2));
                Double cost = Double.valueOf(resultSet.getString(3));
                State state = State.valueOf(resultSet.getString(4));
                Order order = new Order(id, userId, cost, state);
                orders.add(order);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return orders;
    }

    @Override
    public Order addOrder(String state, Long userId) {
        Order order;
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementMax = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = statementMax.executeQuery();
            resultSet.next();
            var maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_ORDER);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setLong(2, userId);
            preparedStatement.setDouble(3, 0);
            preparedStatement.setString(4, state);
            preparedStatement.execute();
            order = new Order(maxId, userId, 0D, State.valueOf(state));
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return order;
    }

    @Override
    public void deleteOrder(Long id) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER);
            preparedStatement.setLong(1, id);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findOrdersForUser(Long userId) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERID);
            preparedStatement.setLong(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Double cost = Double.valueOf(resultSet.getString(3));
                State state = State.valueOf(resultSet.getString(4));
                Order order = new Order(id, userId, cost, state);
                orders.add(order);
            }
            return orders;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Order findOrderById(Long id) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            Order order = null;
            while (resultSet.next()) {
                Long orderId = Long.valueOf(resultSet.getString(1));
                Long userId = Long.valueOf(resultSet.getString(2));
                Double cost = Double.valueOf(resultSet.getString(3));
                State state = State.valueOf(resultSet.getString(4));
                order = new Order(orderId, userId, cost, state);
            }
            return order;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void toChangeOrderState(Long orderId, State state) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TO_CHANGE_ORDER_STATE);
            preparedStatement.setString(1, String.valueOf(state));
            preparedStatement.setLong(2, orderId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Order> findOrdersForBasketId(Long basketId) {
        List<Order> orders = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_BASKETID);
            preparedStatement.setLong(1, basketId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Long userId = Long.valueOf(resultSet.getString(2));
                Double cost = Double.valueOf(resultSet.getString(3));
                State state = State.valueOf(resultSet.getString(4));
                Order order = new Order(id, userId, cost, state);
                orders.add(order);
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long findOrderNumber(Long userid, String state) {
        Long orderId = null;
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_USERID_AND_STATE);
            preparedStatement.setLong(1, userid);
            preparedStatement.setString(2, state);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                orderId = Long.valueOf(resultSet.getString(1));
            }
            return orderId;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void addCostToOrder(Long orderId, Long quantity, Long goodId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(TO_FIND_PRODUCT_PRICE);
            preparedStatement.setLong(1, goodId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            Long price = resultSet.getLong(5);
            Long cost = price * quantity;
            PreparedStatement preparedStatementCost = connection.prepareStatement(TO_CHANGE_ORDER_COST);
            preparedStatementCost.setLong(1, cost);
            preparedStatementCost.setLong(2, orderId);
            preparedStatementCost.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
