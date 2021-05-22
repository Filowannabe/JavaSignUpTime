package frontend.views.pages;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Timer;
import backend.models.User;
import backend.services.UserService;
import frontend.navigator.Navigator;
import frontend.views.utils.GeneralUtils;

public class Register extends JPanel {
    private Timer alertTimer = new Timer();
    private TimerTask timerTask;
    private GeneralUtils generalUtils;
    private JTextField idText;
    private JTextField nameText;
    private JTextField phoneText;
    private JTextField mailText;
    private JButton submit;
    private JLabel alert;
    private JLabel id;
    private JLabel name;
    private JLabel phone;
    private JLabel mail;
    private Navigator parent;
    private UserService userService = new UserService();

    public Register(Navigator parent) {
        this.parent = parent;
        JPanel panel = new JPanel();
        generalUtils = new GeneralUtils();
        panel.setLayout(null);
        panel.setBounds(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
        panel.setBackground(new Color(36, 36, 36));

        id = new JLabel();
        name = new JLabel();
        phone = new JLabel();
        mail = new JLabel();
        alert = new JLabel();

        mail.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3), 100, 40);
        phone.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3) + 40, 100, 40);
        name.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3) - 40, 100, 40);
        id.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3) - 80, 100, 40);

        phone.setForeground(new Color(255, 255, 255));
        mail.setForeground(new Color(255, 255, 255));
        name.setForeground(new Color(255, 255, 255));
        id.setForeground(new Color(255, 255, 255));

        idText = new JTextField();
        nameText = new JTextField();
        phoneText = new JTextField();
        mailText = new JTextField();

        generalUtils.changeFontAndText(id, true, "Tahoma", 30, "id");
        generalUtils.changeFontAndText(phone, true, "Tahoma", 30, "phone");
        generalUtils.changeFontAndText(name, true, "Tahoma", 30, "name");
        generalUtils.changeFontAndText(mail, true, "Tahoma", 30, "mail");

        mailText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) + 50, 100, 25);
        phoneText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) + 10, 100, 25);
        nameText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) - 30, 100, 25);
        idText.setBounds((parent.getBodyWidth() / 2) + 80, (parent.getBodyHeight() / 3) - 70, 100, 25);

        alert.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3) + 200, 200, 20);
        generalUtils.changeFontAndText(alert, true, "Tahoma", 20, "USER IS SAVED.");
        alert.setForeground(new Color(30, 140, 30));
        alert.setVisible(false);

        submit = new JButton("submit");
        submit.setBounds((parent.getBodyWidth() / 2) - 80, (parent.getBodyHeight() / 3) + 120, 150, 35);
        submit.setBackground(new Color(30, 140, 30));
        generalUtils.buttonChangeColorOrForeground(submit, 255, 255, 255, false);
        generalUtils.customizeButton(submit, false);
        registerUser(submit);

        panel.add(id);
        panel.add(name);
        panel.add(phone);
        panel.add(mail);
        panel.add(alert);
        panel.add(idText);
        panel.add(nameText);
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
                User user = new User(idText.getText(), nameText.getText(), phoneText.getText(), mailText.getText());

                try {
                    userService.createUser(user);
                    cleanText();
                    alert.setVisible(true);
                    startTimer();
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }

    private void cleanText() {
        idText.setText("");
        nameText.setText("");
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
