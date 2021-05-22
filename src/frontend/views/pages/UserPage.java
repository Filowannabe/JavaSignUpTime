package frontend.views.pages;

import javax.swing.JPanel;
import java.util.ArrayList;
import backend.models.User;
import frontend.navigator.Navigator;
import frontend.views.widget.UserDescription;

public class UserPage extends JPanel {
    private UserDescription userDescription;

    public UserPage(Navigator parent, ArrayList<User> users) {

        userDescription = new UserDescription(parent, users);
        userDescription.setLayout(null);
        userDescription.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyWidth());

        add(userDescription);
    }
}
