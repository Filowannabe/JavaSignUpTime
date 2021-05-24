package frontend.views.pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.util.Timer;
import backend.models.User;
import backend.services.UserService;
import frontend.navigator.Navigator;
import frontend.views.utils.EncryptUtils;
import frontend.views.utils.GeneralUtils;

public class Register extends JPanel {
    private Timer alertTimer = new Timer();
    private TimerTask timerTask;
    private GeneralUtils generalUtils;
    private EncryptUtils encryptUtils;
    private JTextField usernameText;
    private JPasswordField passwordText;
    private JTextField phoneText;
    private JTextField mailText;
    private char passwordChar;
    private JButton submit;
    private JLabel alert;
    private JLabel username;
    private JLabel password;
    private JLabel phone;
    private JLabel mail;
    private JLabel lblIcon;
    private Navigator parent;
    private UserService userService = new UserService();

    public Register(Navigator parent) {
        this.parent = parent;
        JPanel panel = new JPanel();
        generalUtils = new GeneralUtils();
        encryptUtils= new EncryptUtils();
        panel.setLayout(null);
        panel.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
        panel.setBackground(new Color(36, 36, 36));

        username = new JLabel();
        password = new JLabel();
        phone = new JLabel();
        mail = new JLabel();
        alert = new JLabel();

        mail.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3), 100, 40);
        phone.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3) + 40, 100, 40);
        password.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3) - 40, 160, 40);
        username.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3) - 80, 160, 40);

        phone.setForeground(new Color(255, 255, 255));
        mail.setForeground(new Color(255, 255, 255));
        password.setForeground(new Color(255, 255, 255));
        username.setForeground(new Color(255, 255, 255));

        usernameText = new JTextField();
        passwordText = new JPasswordField();
        passwordChar = passwordText.getEchoChar();
        phoneText = new JTextField();
        mailText = new JTextField();

        generalUtils.changeFontAndText(username, true, "Tahoma", 30, "username");
        generalUtils.changeFontAndText(phone, true, "Tahoma", 30, "phone");
        generalUtils.changeFontAndText(password, true, "Tahoma", 30, "password");
        generalUtils.changeFontAndText(mail, true, "Tahoma", 30, "mail");

        generalUtils.textChangeColorOrForeground(usernameText, 30, 140, 30, false);
        generalUtils.changeFontAndText(usernameText, true, "Tahoma", 20, "");

        generalUtils.textChangeColorOrForeground(passwordText, 30, 140, 30, false);
        generalUtils.changeFontAndText(passwordText, true, "Tahoma", 20, "");
        passwordText.setEchoChar(passwordChar);

        generalUtils.textChangeColorOrForeground(phoneText, 30, 140, 30, false);
        generalUtils.changeFontAndText(phoneText, true, "Tahoma", 20, "");

        generalUtils.textChangeColorOrForeground(mailText, 30, 140, 30, false);
        generalUtils.changeFontAndText(mailText, true, "Tahoma", 20, "");

        mailText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) + 50, 160, 25);
        phoneText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) + 10, 160, 25);
        passwordText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) - 30, 160, 25);
        usernameText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) - 70, 160, 25);

        alert.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3) + 200, 400, 20);
        alert.setVisible(false);

        submit = new JButton("submit");
        submit.setBounds((parent.getBodyWidth() / 2) - 120, (parent.getBodyHeight() / 3) + 120, 150, 35);
        generalUtils.buttonChangeColorOrForeground(submit, 30, 140, 30, true);
        generalUtils.buttonChangeColorOrForeground(submit, 255, 255, 255, false);
        generalUtils.customizeButton(submit, false);
        registerUser(submit);

        lblIcon = new JLabel();
        lblIcon.setBounds(40, (parent.getBodyHeight() / 6) - 180, 700, 500);
        generalUtils.changeFontAndText(lblIcon, true, "MesloLGL Nerd Font", 450, "");
        generalUtils.labelChangeColorOrForeground(lblIcon, 207, 0, 16, false);

        panel.add(lblIcon);
        panel.add(username);
        panel.add(password);
        panel.add(phone);
        panel.add(mail);
        panel.add(alert);
        panel.add(usernameText);
        panel.add(passwordText);
        panel.add(phoneText);
        panel.add(mailText);
        panel.add(submit);

        add(panel);
        setVisible(true);

        setBounds(0, 0, 600, 400);

    }

    private void registerUser(JButton btn) {

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (alertEmptyFields()) {
                    User user = new User(usernameText.getText(), encryptUtils.cryptPassword(passwordText.getText()), phoneText.getText(),
                            mailText.getText());
                    try {
                        userService.createUser(user);
                        cleanText();
                        generalUtils.changeFontAndText(alert, true, "Tahoma", 20, "USER IS SAVED.");
                        alert.setForeground(new Color(30, 140, 30));
                        alert.setVisible(true);
                        startTimer();
                    } catch (SQLException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    alert.setText("There are empty fields");
                    alert.setForeground(new Color(254, 0, 0));
                    alert.setVisible(true);
                    startTimer();
                }

            }
        });
    }

    private boolean alertEmptyFields() {
        if (usernameText.getText().equals("") || passwordText.getText().equals("") || phoneText.getText().equals("")
                || mailText.getText().equals("")) {
            return false;
        }
        return true;
    }

    private void cleanText() {
        usernameText.setText("");
        passwordText.setText("");
        phoneText.setText("");
        mailText.setText("");
    }

    private void startTimer() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                alert.setVisible(false);
                cancelTimer();
            }
        };
        alertTimer.schedule(timerTask, 2000, 2000);
    }

    private void cancelTimer() {
        try {
            timerTask.cancel();
        } catch (Exception e) {
        }
    }

}
