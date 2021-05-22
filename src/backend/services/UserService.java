package backend.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.models.User;
import backend.repositories.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void createUser(User user) throws SQLException {
        userRepository.createUser(user.getId(), user.getName(), user.getPhone(), user.getMail());
    }

    public ArrayList<User> getAllUsers() {
        try {
            ResultSet rs = userRepository.getAllUsers();
            ArrayList<User> users = new ArrayList<User>();

            while (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("phone"),
                        rs.getString("mail"));
                users.add(user);
            }

            return users;

        } catch (SQLException e) {

        }
        return null;
    }
}
