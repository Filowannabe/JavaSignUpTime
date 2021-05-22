package frontend.navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import backend.models.User;
import backend.services.UserService;
import frontend.views.pages.Register;
import frontend.views.pages.UserPage;

public class Navigator extends JFrame {
    private JPanel body;
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private Dimension sizeScreen = screen.getScreenSize();
    private GroupLayout bodyLayout;
    private JScrollPane scrollBar;

    public Navigator() {
        body = new JPanel();
        initBody(body, getBodyHeight());
        add(scrollBar);
    }

    public void bodyAddComponent(JPanel panel, int x, int y, int width, int height) {
        panel.setBounds(x, y, width, height);
        panel.setLayout(null);
        body.add(panel);
    }

    public void goRegisterPage(int x, int y, int width, int height) {
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        repaintAndRevalidate();
        Register register = new Register(this);
        register.setBounds(x, y, width, height);
        register.setLayout(null);
        body.add(register);
        repaintAndRevalidate();
    }

    public void goUserPage(int x, int y, int width, int height) {
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        repaintAndRevalidate();
        UserService userService = new UserService();
        ArrayList<User> users = userService.getAllUsers();
        UserPage userPage = new UserPage(this, users);
        userPage.setBounds(x, y, width, height);
        userPage.setLayout(null);
        body.add(userPage);
        repaintAndRevalidate();
    }

    public int getBodyHeight() {
        int height = sizeScreen.height;
        return height;
    }

    public int getBodyWidth() {
        int width = sizeScreen.width;
        return width;
    }

    public void bodyReAdd(JPanel panel, int x, int y, int width, int height) {
        body.removeAll();
        repaintAndRevalidate();

        panel.setBounds(x, y, width, height);
        panel.setLayout(null);

        body.add(panel);
        repaintAndRevalidate();
    }

    public void repaintAndRevalidate() {
        body.repaint();
        body.revalidate();
    }

    public void initComponents() {
        setVisible(true);
        setBounds(0, 0, getBodyWidth(), getBodyHeight());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    public void initBody(JPanel body, int height) {
        bodyLayout = new GroupLayout(body);
        body.setLayout(bodyLayout);
        setBodyLayoutGroup(height);
        scrollBar = new JScrollPane();
        scrollBar.setViewportView(body);
        scrollBar.setBackground(Color.BLUE);
        scrollBar.setBounds(0, 0, getBodyWidth(), getBodyHeight());
    }

    public void setBodyLayoutGroup(int height) {
        bodyLayout.setHorizontalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, 0, Short.MAX_VALUE));
        bodyLayout.setVerticalGroup(
                bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGap(0, height, Short.MAX_VALUE));
    }

}