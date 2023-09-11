package by.academypvt.repository.jdbc;

import by.academypvt.connection.ProjectConnection;
import by.academypvt.domain.Basket;
import by.academypvt.repository.BasketRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class BasketRepositoryJdbc implements BasketRepository {
    private final String MAX_ID = "select max(id) from shop.basket";
    private final String FIND_BY_ORDERID = "select * from shop.basket where orderid=?";
    private final String ADD_BASKET = "insert into shop.basket (id, productid, orderid, count) values (?,?,?,?)";
    private final String FIND_BASKET_BY_BASKETID = "select * from shop.basket where id=?";
    private final String DELETE_BASKET = "delete from shop.basket where id=?";
    private ProjectConnection postgresConnection;

    public BasketRepositoryJdbc(ProjectConnection postgresConnection) {
        this.postgresConnection = postgresConnection;
    }

    @Override
    public List<Basket> allBaskets() {
        List<Basket> baskets = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from shop.basket");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Long productId = Long.valueOf(resultSet.getString(2));
                Long orderId = Long.valueOf(resultSet.getString(3));
                Long count = Long.valueOf(resultSet.getString(4));
                Basket basket = new Basket(id, productId, orderId, count);
                baskets.add(basket);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return baskets;
    }


    @Override
    public void addGoodToBasket(Long productId, Long orderId, Long count) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementMax = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = statementMax.executeQuery();
            resultSet.next();
            var maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_BASKET);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setLong(2, productId);
            preparedStatement.setDouble(3, orderId);
            preparedStatement.setLong(4, count);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public Basket getBasketByBasketid(Long basketId) {
        try {
            Basket basket = new Basket();
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BASKET_BY_BASKETID);
            preparedStatement.setLong(1, basketId);
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Long productId = Long.valueOf(resultSet.getString(2));
                Long orderId = Long.valueOf(resultSet.getString(3));
                Long count = Long.valueOf(resultSet.getString(4));
                basket = new Basket(id, productId, orderId, count);
            }
            return basket;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public List<Basket> getBasketsByOrderId(Long orderId) {
        try {
            List<Basket> baskets = new ArrayList<>();
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ORDERID);
            preparedStatement.setLong(1, orderId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getLong(1));
                Long productId = Long.valueOf(resultSet.getLong(2));
                Long count = Long.valueOf(resultSet.getLong(4));
                Basket basket = new Basket(id, productId, orderId, count);
                baskets.add(basket);
            }
            return baskets;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteBasket(Long basketId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_BASKET);
            preparedStatement.setLong(1, basketId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

