package backend.services;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import backend.models.User;
import backend.repositories.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void createUser(User user) throws SQLException {
        userRepository.createUser(user.getUsername(), user.getPassword(), user.getPhone(), user.getMail());
    }

    public ArrayList<User> getAllUsers() {
        try {
            ResultSet rs = userRepository.getAllUsers();
            ArrayList<User> users = new ArrayList<User>();
            while (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("phone"),
                        rs.getString("mail"));
                users.add(user);
            }
            return users;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public User getUserByUsername(String username) {
        try {
            ResultSet rs = userRepository.findUserById(username);
            if (rs.next()) {
                User user = new User(rs.getString("username"), rs.getString("password"), rs.getString("phone"),
                        rs.getString("mail"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUserByUsername(String username) {
        try {
            userRepository.deleteUserById(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUserByUsername(String id, String username, String password, String phone, String mail) {
        try {
            userRepository.updateUserById(id, username, password, phone, mail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
