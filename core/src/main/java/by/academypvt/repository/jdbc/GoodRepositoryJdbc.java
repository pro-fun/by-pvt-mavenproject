package by.academypvt.repository.jdbc;

import by.academypvt.api.dto.good.Type;
import by.academypvt.connection.ProjectConnection;
import by.academypvt.domain.Good;
import by.academypvt.repository.GoodRepository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GoodRepositoryJdbc implements GoodRepository {
    private final String FIND_BY_ID = "select * from shop.good g where g.id=?";
    private final String FIND_BY_CODE = "select * from shop.good g where g.code=?";
    private final String ADD_GOOD = "insert into shop.good (id, type, name, code, price, quantity) values (?,?,?,?,?,?)";
    private final String MAX_ID = "select max(id) from shop.good";
    private final String DELETE_GOOD = "delete from shop.good g where g.id=?";


    private ProjectConnection postgresConnection;

    public GoodRepositoryJdbc(ProjectConnection postgresConnection) {
        this.postgresConnection = postgresConnection;
    }

    @Override
    public List<Good> allGoods() {
        List<Good> goods = new ArrayList<>();
        try {
            Connection connection = postgresConnection.getConnection();
            Statement statement = connection.createStatement();
            statement.executeQuery("select * from shop.good");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Type type = Type.valueOf(resultSet.getString(2));
                String name = resultSet.getString(3);
                Long code = Long.valueOf(resultSet.getString(4));
                Long price = Long.valueOf(resultSet.getString(5));
                Integer quantity = Integer.valueOf(resultSet.getString(6));
                Good good = new Good(id, type, name, code, price, quantity);
                goods.add(good);
            }
        } catch (
                SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return goods;
    }

    @Override
    public Good addGood(Good good) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementMax = connection.prepareStatement(MAX_ID);
            ResultSet resultSet = statementMax.executeQuery();
            resultSet.next();
            var maxId = resultSet.getLong(1);
            PreparedStatement preparedStatement = connection.prepareStatement(ADD_GOOD);
            preparedStatement.setLong(1, ++maxId);
            preparedStatement.setString(2, String.valueOf(good.getType()));
            preparedStatement.setString(3, good.getName());
            preparedStatement.setLong(4, good.getCode());
            preparedStatement.setLong(5, good.getPrice());
            preparedStatement.setInt(6, good.getQuantity());
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e.getMessage());
        }
        return good;
    }

    @Override
    public void deleteGood(Long goodId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(DELETE_GOOD);
            preparedStatement.setLong(1, goodId);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @Override
    public Good findGoodById(Long goodId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setLong(1, goodId);
            ResultSet resultSet = preparedStatement.executeQuery();
            Good good = null;
            if (resultSet == null) {
                return new Good();
            }

            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Type type = Type.valueOf(resultSet.getString(2));
                String name = resultSet.getString(3);
                Long code = Long.valueOf(resultSet.getString(4));
                Long price = Long.valueOf(resultSet.getString(5));
                Integer quantity = Integer.valueOf(resultSet.getString(6));
                good = new Good(id, type, name, code, price, quantity);
            }
            return good;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Good findGoodByCode(Long code) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_CODE);
            preparedStatement.setLong(1, code);
            ResultSet resultSet = preparedStatement.executeQuery();
            Good good = null;
            if (resultSet == null) {
                return new Good();
            }

            while (resultSet.next()) {
                Long id = Long.valueOf(resultSet.getString(1));
                Type type = Type.valueOf(resultSet.getString(2));
                String name = resultSet.getString(3);
                Long price = Long.valueOf(resultSet.getString(5));
                Integer quantity = Integer.valueOf(resultSet.getString(6));
                good = new Good(id, type, name, code, price, quantity);
            }
            return good;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Long findGoodsQuantity(Long goodId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementQuantity = connection.prepareStatement("select * from shop.good where id=?");
            statementQuantity.setLong(1, goodId);
            ResultSet resultSet = statementQuantity.executeQuery();
            resultSet.next();
            Long neededQuantity = resultSet.getLong(6);
            return neededQuantity;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void changeGoodsQuantity(Long quantity, Long goodId) {
        try {
            Connection connection = postgresConnection.getConnection();
            PreparedStatement statementQuantity = connection.prepareStatement("update shop.good set quantity=? where id=?");
            statementQuantity.setLong(1, quantity);
            statementQuantity.setLong(2, goodId);
            statementQuantity.execute();
            } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
