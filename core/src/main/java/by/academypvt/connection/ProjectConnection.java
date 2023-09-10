package by.academypvt.connection;
import java.sql.Connection;
import java.sql.SQLException;
public interface ProjectConnection {
    Connection getConnection() throws SQLException;
}
