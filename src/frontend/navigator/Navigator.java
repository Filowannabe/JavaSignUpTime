package frontend.navigator;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyAdapter;
import java.awt.Font;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import backend.models.User;
import backend.services.UserService;
import frontend.views.pages.FindUserPage;
import frontend.views.pages.NotFound;
import frontend.views.pages.Register;
import frontend.views.pages.UserPage;
import frontend.views.utils.GeneralUtils;

public class Navigator extends JFrame {
    private JPanel body;
    private Toolkit screen = Toolkit.getDefaultToolkit();
    private Dimension sizeScreen = screen.getScreenSize();
    private GroupLayout bodyLayout;
    private JScrollPane scrollBar;
    private GeneralUtils generalUtils;
    private JPanel navBar;
    private JButton registerBtn;
    private JButton listAllUsersBtn;
    private JTextField findTextField;
    private UserService userService;
    private Timer findFieldTimer = new Timer();
    private TimerTask timerTask;
    private String findTextValue;

    public Navigator() {
        body = new JPanel();
        initBody(body, getBodyHeight());
        add(scrollBar);
    }

    private JPanel initNavBar() {
        generalUtils = new GeneralUtils();
        navBar = new JPanel();

        registerBtn = new JButton();
        registerBtn.setBounds(10, 10, 120, 30);
        generalUtils.buttonChangeColorOrForeground(registerBtn, 255, 255, 255, false);
        generalUtils.buttonChangeColorOrForeground(registerBtn, 70, 70, 70, true);
        generalUtils.changeFontAndText(registerBtn, true, "Tahoma", 15, "Register");
        generalUtils.customizeButton(registerBtn, false);
        goRegisterPageAction(registerBtn);

        listAllUsersBtn = new JButton();
        listAllUsersBtn.setBounds(140, 10, 120, 30);
        generalUtils.buttonChangeColorOrForeground(listAllUsersBtn, 255, 255, 255, false);
        generalUtils.buttonChangeColorOrForeground(listAllUsersBtn, 70, 70, 70, true);
        generalUtils.changeFontAndText(listAllUsersBtn, true, "Tahoma", 15, "List");
        generalUtils.customizeButton(listAllUsersBtn, false);
        goUserPageAction(listAllUsersBtn);

        findTextField = new JTextField();
        findTextField.setBounds((getBodyWidth() / 2) - 200, 10, 400, 30);
        generalUtils.textChangeColorOrForeground(findTextField, 0, 0, 0, false);
        findTextField.setFont(new Font("Tahoma", Font.BOLD, 15));
        findTextValue = "";
        findTextField.addKeyListener(new KeyAdapter() {

            @Override
            public void keyPressed(KeyEvent e) {
                cancelTimer();
            }

            @Override
            public void keyReleased(KeyEvent e) {
                findTextValue = findTextField.getText();
                if (!findTextField.getText().equals("") && !findTextValue.equals("")) {
                    startFindFieldTimer(findTextValue);
                }
            }

        });
        navBar.setBackground(new Color(0, 0, 0));
        navBar.add(registerBtn);
        navBar.add(listAllUsersBtn);
        navBar.add(findTextField);

        return navBar;
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
        bodyAddComponent(initNavBar(), 0, 0, getBodyWidth(), 50);
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
        bodyAddComponent(initNavBar(), 0, 0, getBodyWidth(), 50);
        repaintAndRevalidate();
        userService = new UserService();
        ArrayList<User> users = userService.getAllUsers();
        UserPage userPage = new UserPage(this, users);
        userPage.setBounds(x, y, width, height);
        userPage.setLayout(null);
        body.add(userPage);
        repaintAndRevalidate();
    }

    public void goNotFoundedPage(int x, int y, int width, int height) {
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        bodyAddComponent(initNavBar(), 0, 0, getBodyWidth(), 50);
        repaintAndRevalidate();
        NotFound notFound = new NotFound(this);
        notFound.setBounds(x, y, width, height);
        notFound.setLayout(null);
        body.add(notFound);
        repaintAndRevalidate();
    }

    public void goFindedUserPage(int x, int y, int width, int height, String username) {
        cancelTimer();
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        body.removeAll();
        setBodyLayoutGroup(height);
        bodyAddComponent(initNavBar(), 0, 0, getBodyWidth(), 50);
        repaintAndRevalidate();

        userService = new UserService();
        User user = userService.getUserByUsername(username);

        if (user == null) {
            goNotFoundedPage(0, 50, getBodyWidth(), getBodyHeight());
        } else {
            FindUserPage findUserPage = new FindUserPage(this, user);
            findUserPage.setBounds(x, y, width, height);
            findUserPage.setLayout(null);
            body.add(findUserPage);
        }
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

    private void goUserPageAction(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                goUserPage(0, 50, getBodyWidth(), getBodyHeight());
            }
        });
    }

    private void goRegisterPageAction(JButton btn) {
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goRegisterPage(0, 50, getBodyWidth(), getBodyHeight());
            }
        });
    }

    private void startFindFieldTimer(String text) {
        cancelTimer();
        timerTask = new TimerTask() {
            @Override
            public void run() {
                goFindedUserPage(0, 50, getBodyWidth(), getBodyHeight(), text);
                findTextField.setText("");
                findTextValue = "";
            }
        };
        findFieldTimer.schedule(timerTask, 1000, 1000);
    }

    private void cancelTimer() {
        try {
            timerTask.cancel();
        } catch (Exception e) {

        }
    }
}