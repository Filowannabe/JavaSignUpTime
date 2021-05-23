package frontend.views.widget;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import frontend.navigator.Navigator;
import frontend.views.utils.UserDescriptionUtils;
import java.awt.Color;
import java.awt.FlowLayout;
import java.util.ArrayList;

import backend.models.User;

public class UserDescription extends JPanel {

    private UserDescriptionUtils userDescriptionUtils;
    private Navigator parent;

    public UserDescription(Navigator parent, ArrayList<User> users) {
        this.parent = parent;
        userDescriptionUtils = new UserDescriptionUtils();
        JPanel flowLayout = new JPanel();
        JPanel gridLayout = new JPanel();
        flowLayout.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 0));
        flowLayout.add(userDescriptionUtils.listAllUsers(parent, gridLayout, 300, 400, users.size(), users));
        flowLayout.setBackground(new Color(36, 36, 36));

        JScrollPane scrollBar = new JScrollPane();

        scrollBar.setViewportView(flowLayout);

        if (users.size() < 17) {
            scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        } else {
            scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
        }

        if (users.size() <= 2) {
            scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        } else {
            scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        }

        scrollBar.setBackground(Color.BLACK);
        scrollBar.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight() - 100);

        add(scrollBar);
        setBackground(Color.BLACK);
        setBackground(new Color(36, 36, 36));
    }
}
