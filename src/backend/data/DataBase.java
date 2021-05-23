package backend.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBase {
    public Connection setConection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3307/store", "root", "root");
        return connection;
    }
}
