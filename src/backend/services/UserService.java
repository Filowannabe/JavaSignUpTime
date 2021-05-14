package backend.services;

import java.sql.SQLException;

import backend.models.User;
import backend.repositories.UserRepository;

public class UserService {

    UserRepository userRepository = new UserRepository();

    public void createUser(User user) throws SQLException {
        userRepository.createUser(user.getId(), user.getName(), user.getPhone(), user.getMail());
    }
}
