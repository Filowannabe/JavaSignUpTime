package frontend.views.utils;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import backend.models.User;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import frontend.navigator.Navigator;

public class UserDescriptionUtils {

        GeneralUtils generalUtils;
        GroupLayout bodyLayout;

        public UserDescriptionUtils() {
                generalUtils = new GeneralUtils();

        }

        public JPanel listAllUsers(Navigator parent, JPanel grid, int width, int height, int itemsNumber,
                        ArrayList<User> users) {

                grid.setLayout(new GridLayout(4, 10, 20, 20));
                grid.setBackground(Color.BLACK);

                JPanel[] body, bodyContent;
                body = new JPanel[itemsNumber];
                bodyContent = new JPanel[itemsNumber];

                JLabel[] lblId, lblName, lblPhone, lblMail, idValue, nameValue, phoneValue, mailValue;

                lblId = new JLabel[itemsNumber];
                lblName = new JLabel[itemsNumber];
                lblPhone = new JLabel[itemsNumber];
                lblMail = new JLabel[itemsNumber];

                idValue = new JLabel[itemsNumber];
                nameValue = new JLabel[itemsNumber];
                phoneValue = new JLabel[itemsNumber];
                mailValue = new JLabel[itemsNumber];

                for (int i = 0; i < itemsNumber; i++) {
                        body[i] = new JPanel();
                        bodyContent[i] = new JPanel();
                        lblId[i] = new JLabel();
                        lblName[i] = new JLabel();
                        lblPhone[i] = new JLabel();
                        lblMail[i] = new JLabel();

                        idValue[i] = new JLabel();
                        nameValue[i] = new JLabel();
                        phoneValue[i] = new JLabel();
                        mailValue[i] = new JLabel();

                        bodyContent[i].setBackground(new Color(255, 255, 255));
                        bodyContent[i].setLayout(null);

                        generalUtils.changeFontAndText(lblId[i], true, "Tahoma", 20, "ID:");
                        generalUtils.changeFontAndText(idValue[i], true, "Tahoma", 20, users.get(i).getId().toString());
                        lblId[i].setBounds(25, 10, 80, 20);
                        idValue[i].setBounds(250, 10, 80, 20);
                        bodyContent[i].add(lblId[i]);
                        bodyContent[i].add(idValue[i]);

                        generalUtils.changeFontAndText(lblName[i], true, "Tahoma", 20, "NAME:");
                        generalUtils.changeFontAndText(nameValue[i], true, "Tahoma", 20, users.get(i).getName());
                        lblName[i].setBounds(25, 40, 80, 20);
                        nameValue[i].setBounds(250, 40, 80, 20);
                        bodyContent[i].add(lblName[i]);
                        bodyContent[i].add(nameValue[i]);

                        generalUtils.changeFontAndText(lblPhone[i], true, "Tahoma", 20, "PHONE:");
                        generalUtils.changeFontAndText(phoneValue[i], true, "Tahoma", 20, users.get(i).getPhone());
                        lblPhone[i].setBounds(25, 80, 80, 20);
                        phoneValue[i].setBounds(250, 80, 80, 20);
                        bodyContent[i].add(lblPhone[i]);
                        bodyContent[i].add(phoneValue[i]);

                        generalUtils.changeFontAndText(lblMail[i], true, "Tahoma", 20, "MAIL:");
                        generalUtils.changeFontAndText(mailValue[i], true, "Tahoma", 20, users.get(i).getMail());
                        lblMail[i].setBounds(25, 120, 80, 20);
                        mailValue[i].setBounds(250, 120, 80, 20);
                        bodyContent[i].add(lblMail[i]);
                        bodyContent[i].add(mailValue[i]);

                        goRegisterPage(bodyContent, i, parent);

                        if (users.size() < 5) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() - 50, 400);
                        } else if (users.size() < 9) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 2, 400);
                        } else if (users.size() < 13) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 3, 400);
                        } else {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 5, 400);
                        }

                        grid.add(body[i]);

                }
                return grid;
        }

        public void goRegisterPage(JPanel[] panel, int i, Navigator parent) {
                panel[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                parent.goRegisterPage(0, 0, parent.getBodyWidth(), parent.getBodyHeight());
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                                panel[i].setCursor(new Cursor(Cursor.HAND_CURSOR));
                        }
                });
        }

        public void initBody(JPanel body, JPanel bodyContent, int width, int height) {
                bodyLayout = new GroupLayout(body);
                body.setLayout(bodyLayout);
                body.setBackground(new Color(23, 123, 23));
                setBodyLayoutGroup(body, bodyContent, width, height);
        }

        private void setBodyLayoutGroup(JPanel body, JPanel bodyContent, int width, int height) {

                body.setLayout(bodyLayout);
                bodyLayout.setHorizontalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                .addGroup(bodyLayout.createSequentialGroup().addComponent(bodyContent,
                                                GroupLayout.PREFERRED_SIZE, width, GroupLayout.PREFERRED_SIZE)
                                                .addGap(0, 0, 0)));
                bodyLayout.setVerticalGroup(bodyLayout.createParallelGroup(GroupLayout.Alignment.LEADING).addGroup(
                                GroupLayout.Alignment.TRAILING,
                                bodyLayout.createSequentialGroup().addGap(0, 0, 0).addComponent(bodyContent,
                                                GroupLayout.PREFERRED_SIZE, height, GroupLayout.PREFERRED_SIZE)));

        }

}