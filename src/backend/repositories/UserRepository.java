package backend.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import backend.data.DataBase;

public class UserRepository {

    private PreparedStatement preparedStatement;
    private DataBase conection = new DataBase();

    public void createUser(String id, String name, String phone, String mail) throws SQLException {

        String query = "INSERT INTO users VALUES(?,?,?,?)";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, id);
        preparedStatement.setString(2, name);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, mail);

        preparedStatement.execute();
    }

    public ResultSet getAllUsers() throws SQLException {

        String query = "select * from users";
        preparedStatement = conection.setConection().prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public ResultSet findUserById(String username) throws SQLException {

        String query = "select * from users where name=?";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }
}
