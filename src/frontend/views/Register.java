package frontend.views;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.TimerTask;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.Timer;
import backend.models.User;
import backend.services.UserService;
import frontend.utils.GeneralUtils;

public class Register extends JFrame {
    private Timer timerCarousel = new Timer();
    private TimerTask recorrerCarousel;
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
    private UserService userService = new UserService();

    public Register() {
        JPanel panel = new JPanel();
        generalUtils = new GeneralUtils();
        panel.setLayout(null);
        panel.setBounds(0, 0, 600, 400);
        panel.setBackground(new Color(36, 36, 36));

        id = new JLabel();
        name = new JLabel();
        phone = new JLabel();
        mail = new JLabel();
        alert = new JLabel();

        mail.setBounds(250 - 40, (500 / 3) - 20, 40, 20);
        phone.setBounds(250 - 40, (500 / 3) - 40, 60, 20);
        name.setBounds(250 - 40, (500 / 3) - 60, 40, 20);
        id.setBounds(250 - 40, (500 / 3) - 80, 40, 20);

        phone.setForeground(new Color(255, 255, 255));
        mail.setForeground(new Color(255, 255, 255));
        name.setForeground(new Color(255, 255, 255));
        id.setForeground(new Color(255, 255, 255));

        idText = new JTextField();
        nameText = new JTextField();
        phoneText = new JTextField();
        mailText = new JTextField();

        generalUtils.changeFontAndText(id, true, "Tahoma", 15, "id");
        generalUtils.changeFontAndText(phone, true, "Tahoma", 15, "phone");
        generalUtils.changeFontAndText(name, true, "Tahoma", 15, "name");
        generalUtils.changeFontAndText(mail, true, "Tahoma", 15, "mail");

        mailText.setBounds(250 + 80, (500 / 3) - 20, 100, 20);
        phoneText.setBounds(250 + 80, (500 / 3) - 40, 100, 20);
        nameText.setBounds(250 + 80, (500 / 3) - 60, 100, 20);
        idText.setBounds(250 + 80, (500 / 3) - 80, 100, 20);

        alert.setBounds(250 - 40, (500 / 3) + 60, 200, 20);
        generalUtils.changeFontAndText(alert, true, "Tahoma", 15, "USER IS SAVED.");
        alert.setForeground(new Color(30, 140, 30));
        alert.setVisible(false);

        submit = new JButton("submit");
        submit.setBounds(250 - 40, (500 / 3) + 20, 100, 20);
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(0, 0, 600, 400);
        setResizable(false);
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
        recorrerCarousel = new TimerTask() {
            @Override
            public void run() {
                alert.setVisible(false);
                cancelTimer();
            }
        };
        timerCarousel.schedule(recorrerCarousel, 2000, 2000);
    }

    private void cancelTimer() {
        try {
            recorrerCarousel.cancel();
        } catch (Exception e) {
        }
    }

}
