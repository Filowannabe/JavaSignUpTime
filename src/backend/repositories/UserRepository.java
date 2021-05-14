package backend.repositories;

import java.sql.PreparedStatement;
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
}
