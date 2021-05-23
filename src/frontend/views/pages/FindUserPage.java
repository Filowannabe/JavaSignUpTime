package frontend.views.pages;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import backend.models.User;
import backend.services.UserService;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import frontend.navigator.Navigator;
import frontend.views.utils.GeneralUtils;

public class FindUserPage extends JPanel {
    private Navigator parent;
    private JLabel lblId, lblName, lblPhone, lblMail;
    private JTextField idValue, nameValue, phoneValue, mailValue;
    private GeneralUtils generalUtils;
    private JCheckBox enableFieldsBtn;
    JButton deleteBtn, editBtn;
    private UserService userService;
    private User user;

    public FindUserPage(Navigator parent, User user) {
        generalUtils = new GeneralUtils();
        userService = new UserService();
        this.parent = parent;
        this.user = user;

        lblId = new JLabel();
        lblName = new JLabel();
        lblPhone = new JLabel();
        lblMail = new JLabel();

        idValue = new JTextField();
        nameValue = new JTextField();
        phoneValue = new JTextField();
        mailValue = new JTextField();
        disableTextFields();

        deleteBtn = new JButton();
        deleteBtn.setBounds((parent.getBodyHeight() / 2) - 10, (parent.getBodyHeight() / 3) + 80, 100, 40);
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
        enableFieldsBtn.setBounds((parent.getBodyHeight() / 2) + 100, (parent.getBodyHeight() / 3) - 120, 50, 30);
        addCheckBoxEvent(enableFieldsBtn);
        add(enableFieldsBtn);

        generalUtils.changeFontAndText(lblId, true, "Tahoma", 20, "ID:");
        generalUtils.labelChangeColorOrForeground(lblId, 255, 255, 255, false);
        lblId.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) - 80, 80, 20);
        idValue.setBounds((parent.getBodyHeight() / 2) - 10, (parent.getBodyHeight() / 3) - 80, 100, 20);
        generalUtils.changeFontAndText(idValue, true, "Tahoma", 20, user.getId());
        generalUtils.textChangeColorOrForeground(idValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(idValue, 0, 0, 0, true);
        add(lblId);
        add(idValue);

        generalUtils.changeFontAndText(lblName, true, "Tahoma", 20, "NAME:");
        generalUtils.labelChangeColorOrForeground(lblName, 255, 255, 255, false);
        lblName.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) - 40, 80, 20);
        nameValue.setBounds((parent.getBodyHeight() / 2) - 10, (parent.getBodyHeight() / 3) - 40, 100, 20);
        generalUtils.changeFontAndText(nameValue, true, "Tahoma", 20, user.getName());
        generalUtils.textChangeColorOrForeground(nameValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(nameValue, 0, 0, 0, true);
        add(lblName);
        add(nameValue);

        generalUtils.changeFontAndText(lblPhone, true, "Tahoma", 20, "PHONE:");
        generalUtils.labelChangeColorOrForeground(lblPhone, 255, 255, 255, false);
        lblPhone.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3), 80, 20);
        phoneValue.setBounds((parent.getBodyHeight() / 2) - 10, (parent.getBodyHeight() / 3), 100, 20);
        generalUtils.changeFontAndText(phoneValue, true, "Tahoma", 20, user.getPhone());
        generalUtils.textChangeColorOrForeground(phoneValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(phoneValue, 0, 0, 0, true);
        add(lblPhone);
        add(phoneValue);

        generalUtils.changeFontAndText(lblMail, true, "Tahoma", 20, "MAIL:");
        generalUtils.labelChangeColorOrForeground(lblMail, 255, 255, 255, false);
        lblMail.setBounds((parent.getBodyHeight() / 2) - 120, (parent.getBodyHeight() / 3) + 40, 80, 20);
        mailValue.setBounds((parent.getBodyHeight() / 2) - 10, (parent.getBodyHeight() / 3) + 40, 100, 20);
        generalUtils.changeFontAndText(mailValue, true, "Tahoma", 20, user.getMail());
        generalUtils.textChangeColorOrForeground(mailValue, 30, 140, 30, false);
        generalUtils.textChangeColorOrForeground(mailValue, 0, 0, 0, true);
        add(lblMail);
        add(mailValue);
        setBackground(new Color(36, 36, 36));
    }

    private void disableTextFields() {
        idValue.setEnabled(false);
        nameValue.setEnabled(false);
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
            idValue.setEnabled(true);
            nameValue.setEnabled(true);
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
                userService.deleteUserById(user.getName());
                parent.goRegisterPage(0, 50, parent.getBodyWidth(), parent.getBodyHeight());
            }
        });
    }

    private void editButtonAction(JButton btn) {
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                userService.editUserById(user.getName(), nameValue.getText(), phoneValue.getText(),
                        mailValue.getText());
                parent.goRegisterPage(0, 50, parent.getBodyWidth(), parent.getBodyHeight());
            }

        });
    }
}
