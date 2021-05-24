package backend.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import backend.data.DataBase;

public class UserRepository {

    private PreparedStatement preparedStatement;
    private DataBase conection = new DataBase();

    public void createUser(String username, String password, String phone, String mail) throws SQLException {

        String query = "INSERT INTO users VALUES(?,?,?,?)";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, mail);

        preparedStatement.execute();
    }

    public ResultSet getAllUsers() throws SQLException {

        String query = "select username,password,phone,mail from users";
        preparedStatement = conection.setConection().prepareStatement(query);

        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public ResultSet findUserById(String username) throws SQLException {

        String query = "select username,password,phone,mail from users where username=?";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, username);
        ResultSet resultSet = preparedStatement.executeQuery();

        return resultSet;
    }

    public void deleteUserById(String username) throws SQLException {

        String query = "delete from users where username=?";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.execute();
    }

    public void updateUserById(String id, String username, String password, String phone, String mail)
            throws SQLException {
        String query = "update users set username=?,password=?,phone=?,mail=? where username= '" + id + "'";
        preparedStatement = conection.setConection().prepareStatement(query);
        preparedStatement.setString(1, username);
        preparedStatement.setString(2, password);
        preparedStatement.setString(3, phone);
        preparedStatement.setString(4, mail);
        preparedStatement.executeUpdate();
    }
}
