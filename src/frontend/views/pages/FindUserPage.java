package frontend.views.pages;

import javax.swing.JLabel;
import javax.swing.JPanel;

import backend.models.User;

import java.awt.Color;
import java.util.ArrayList;

import frontend.navigator.Navigator;
import frontend.views.utils.GeneralUtils;

public class FindUserPage extends JPanel {
    private Navigator parent;
    private JLabel lblId, lblName, lblPhone, lblMail, idValue, nameValue, phoneValue, mailValue;
    private GeneralUtils generalUtils;

    public FindUserPage(Navigator parent, User user) {
        generalUtils = new GeneralUtils();
        this.parent = parent;

        lblId = new JLabel();
        lblName = new JLabel();
        lblPhone = new JLabel();
        lblMail = new JLabel();

        idValue = new JLabel();
        nameValue = new JLabel();
        phoneValue = new JLabel();
        mailValue = new JLabel();

        generalUtils.changeFontAndText(lblId, true, "Tahoma", 20, "ID:");
        generalUtils.changeFontAndText(idValue, true, "Tahoma", 20, user.getId());
        generalUtils.labelChangeColorOrForeground(lblId, 255, 255, 255, false);
        generalUtils.labelChangeColorOrForeground(idValue, 30, 140, 30, false);
        lblId.setBounds(20, 10, 80, 20);
        idValue.setBounds(200, 10, 100, 20);
        add(lblId);
        add(idValue);

        generalUtils.changeFontAndText(lblName, true, "Tahoma", 20, "ID:");
        generalUtils.changeFontAndText(nameValue, true, "Tahoma", 20, user.getId());
        generalUtils.labelChangeColorOrForeground(lblName, 255, 255, 255, false);
        generalUtils.labelChangeColorOrForeground(nameValue, 30, 140, 30, false);
        lblName.setBounds(20, 40, 80, 20);
        nameValue.setBounds(200, 40, 100, 20);
        add(lblName);
        add(nameValue);

        generalUtils.changeFontAndText(lblPhone, true, "Tahoma", 20, "PHONE:");
        generalUtils.changeFontAndText(phoneValue, true, "Tahoma", 20, user.getPhone());
        generalUtils.labelChangeColorOrForeground(lblPhone, 255, 255, 255, false);
        generalUtils.labelChangeColorOrForeground(phoneValue, 30, 140, 30, false);
        lblPhone.setBounds(20, 80, 80, 20);
        phoneValue.setBounds(200, 80, 100, 20);
        add(lblPhone);
        add(phoneValue);

        generalUtils.changeFontAndText(lblMail, true, "Tahoma", 20, "MAIL:");
        generalUtils.changeFontAndText(mailValue, true, "Tahoma", 20, user.getMail());
        generalUtils.labelChangeColorOrForeground(lblMail, 255, 255, 255, false);
        generalUtils.labelChangeColorOrForeground(mailValue, 30, 140, 30, false);
        lblMail.setBounds(20, 120, 80, 20);
        mailValue.setBounds(200, 120, 100, 20);
        add(lblMail);
        add(mailValue);

        setBounds(0, 0, parent.getBodyWidth(), 800);
        setBackground(Color.BLACK);
    }

}
