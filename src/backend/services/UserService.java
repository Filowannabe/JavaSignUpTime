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
            e.printStackTrace();
        }
        return null;
    }

    public User getUserById(String username) {
        try {
            ResultSet rs = userRepository.findUserById(username);
            if (rs.next()) {
                User user = new User(rs.getString("id"), rs.getString("name"), rs.getString("phone"),
                        rs.getString("mail"));
                return user;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteUserById(String username) {
        try {
            userRepository.deleteUserById(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void editUserById(String id,String username, String phone, String mail) {
        try {
            userRepository.updateUserById(id, username, phone, mail);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
