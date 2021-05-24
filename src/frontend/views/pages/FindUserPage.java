package frontend.views.pages;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import backend.models.User;
import backend.services.UserService;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import frontend.navigator.Navigator;
import frontend.views.utils.GeneralUtils;

public class FindUserPage extends JPanel {
    private Navigator parent;
    private JLabel lblUsername, lblPassword, lblPhone, lblMail, lblIcon, lblEditIcon;
    private JTextField usernameValue, phoneValue, mailValue;
    private JPasswordField passwordValue;
    private char passwordChar;
    private GeneralUtils generalUtils;
    private JCheckBox enableFieldsBtn;
    private JButton deleteBtn, editBtn;
    private UserService userService;
    private User user;

    public FindUserPage(Navigator parent, User user) {
        generalUtils = new GeneralUtils();
        userService = new UserService();
        this.parent = parent;
        this.user = user;

        lblUsername = new JLabel();
        lblPassword = new JLabel();
        lblPhone = new JLabel();
        lblMail = new JLabel();

        usernameValue = new JTextField();
        passwordValue = new JPasswordField();
        passwordChar = passwordValue.getEchoChar();
        passwordValue.setEchoChar(passwordChar);
        phoneValue = new JTextField();
        mailValue = new JTextField();
        disableTextFields();

        deleteBtn = new JButton();
        deleteBtn.setBounds((parent.getBodyHeight() / 2) + 20, (parent.getBodyHeight() / 3) + 80, 100, 40);
        generalUtils.customizeButton(deleteBtn, false);
        generalUtils.buttonChangeColorOrForeground(deleteBtn, 70, 70, 70, true);
        generalUtils.buttonChangeColorOrForeground(deleteBtn, 255, 255, 255, false);
        generalUtils.changeFontAndText(deleteBtn, true, "Tahoma", 15, "Delete");
        deleteButtonAction(deleteBtn);
        add(deleteBtn);

        editBtn = new JButton();
        editBtn.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) + 80, 100, 40);
        generalUtils.customizeButton(editBtn, false);
        generalUtils.buttonChangeColorOrForeground(editBtn, 70, 70, 70, true);
        generalUtils.buttonChangeColorOrForeground(editBtn, 255, 255, 255, false);
        generalUtils.changeFontAndText(editBtn, true, "Tahoma", 15, "Save");
        editButtonAction(editBtn);
        add(editBtn);

        enableFieldsBtn = new JCheckBox();
        enableFieldsBtn.setBackground(null);
        enableFieldsBtn.setBounds((parent.getBodyHeight() / 2) + 100, (parent.getBodyHeight() / 3) - 120, 20, 30);
        addCheckBoxEvent(enableFieldsBtn);
        add(enableFieldsBtn);

        generalUtils.changeFontAndText(lblUsername, true, "Tahoma", 20, "USERNAME:");
        generalUtils.labelChangeColorOrForeground(lblUsername, 255, 255, 255, false);
        lblUsername.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) - 80, 130, 20);
        usernameValue.setBounds((parent.getBodyHeight() / 2) + 20, (parent.getBodyHeight() / 3) - 80, 100, 20);
        generalUtils.changeFontAndText(usernameValue, true, "Tahoma", 20, user.getUsername());
        generalUtils.textChangeColorOrForeground(usernameValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(usernameValue, 0, 0, 0, true);
        add(lblUsername);
        add(usernameValue);

        generalUtils.changeFontAndText(lblPassword, true, "Tahoma", 20, "PASSWORD:");
        generalUtils.labelChangeColorOrForeground(lblPassword, 255, 255, 255, false);
        lblPassword.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) - 40, 130, 20);
        passwordValue.setBounds((parent.getBodyHeight() / 2) + 20, (parent.getBodyHeight() / 3) - 40, 100, 20);
        generalUtils.changeFontAndText(passwordValue, true, "Tahoma", 20, user.getPassword());
        generalUtils.textChangeColorOrForeground(passwordValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(passwordValue, 0, 0, 0, true);
        add(lblPassword);
        add(passwordValue);

        generalUtils.changeFontAndText(lblPhone, true, "Tahoma", 20, "PHONE:");
        generalUtils.labelChangeColorOrForeground(lblPhone, 255, 255, 255, false);
        lblPhone.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3), 80, 20);
        phoneValue.setBounds((parent.getBodyHeight() / 2) + 20, (parent.getBodyHeight() / 3), 100, 20);
        generalUtils.changeFontAndText(phoneValue, true, "Tahoma", 20, user.getPhone());
        generalUtils.textChangeColorOrForeground(phoneValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(phoneValue, 0, 0, 0, true);
        add(lblPhone);
        add(phoneValue);

        generalUtils.changeFontAndText(lblMail, true, "Tahoma", 20, "MAIL:");
        generalUtils.labelChangeColorOrForeground(lblMail, 255, 255, 255, false);
        lblMail.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) + 40, 80, 20);
        mailValue.setBounds((parent.getBodyHeight() / 2) + 20, (parent.getBodyHeight() / 3) + 40, 100, 20);
        generalUtils.changeFontAndText(mailValue, true, "Tahoma", 20, user.getMail());
        generalUtils.textChangeColorOrForeground(mailValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(mailValue, 0, 0, 0, true);

        lblIcon = new JLabel();
        lblIcon.setBounds((parent.getBodyHeight() / 2) + 550, (parent.getBodyHeight() / 6) - 80, 450, 450);
        lblIcon.setHorizontalAlignment(SwingConstants.CENTER);
        generalUtils.changeFontAndText(lblIcon, true, "MesloLGL Nerd Font", 450, "");
        generalUtils.labelChangeColorOrForeground(lblIcon, 0, 0, 0, false);

        lblEditIcon = new JLabel();
        lblEditIcon.setBounds((parent.getBodyHeight() / 2) + 100, (parent.getBodyHeight() / 3) - 140, 70, 70);
        lblEditIcon.setHorizontalAlignment(SwingConstants.CENTER);
        generalUtils.changeFontAndText(lblEditIcon, true, "MesloLGL Nerd Font", 25, "");
        generalUtils.labelChangeColorOrForeground(lblEditIcon, 0, 255, 20, false);

        add(lblIcon);
        add(lblEditIcon);
        add(lblMail);
        add(mailValue);
        setBackground(new Color(36, 36, 36));
    }

    private void disableTextFields() {
        usernameValue.setEnabled(false);
        passwordValue.setEnabled(false);
        phoneValue.setEnabled(false);
        mailValue.setEnabled(false);
    }

    private void addCheckBoxEvent(JCheckBox box) {
        box.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                EnableTextFields(enableFieldsBtn);
            }

        });
    }

    private void EnableTextFields(JCheckBox box) {
        if (box.isSelected()) {
            usernameValue.setEnabled(true);
            passwordValue.setEnabled(true);
            phoneValue.setEnabled(true);
            mailValue.setEnabled(true);
        } else {
            disableTextFields();
        }
    }

    private void deleteButtonAction(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userService.deleteUserByUsername(user.getUsername());
                parent.goRegisterPage(0, 50, parent.getBodyWidth(), parent.getBodyHeight());
            }
        });
    }

    private void editButtonAction(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userService.editUserByUsername(user.getUsername(), usernameValue.getText(), passwordValue.getText(),
                        phoneValue.getText(), mailValue.getText());
                parent.goRegisterPage(0, 50, parent.getBodyWidth(), parent.getBodyHeight());
            }
        });
    }
}
