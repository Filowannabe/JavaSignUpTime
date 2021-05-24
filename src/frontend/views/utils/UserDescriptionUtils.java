package frontend.views.utils;

import java.awt.Color;
import javax.swing.GroupLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import backend.models.User;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Cursor;
import frontend.navigator.Navigator;

public class UserDescriptionUtils {

        private GeneralUtils generalUtils;
        private GroupLayout bodyLayout;

        public UserDescriptionUtils() {
                generalUtils = new GeneralUtils();

        }

        public JPanel listAllUsers(Navigator parent, JPanel grid, int width, int height, int itemsNumber,
                        ArrayList<User> users) {

                grid.setLayout(new GridLayout(4, 10, 20, 20));
                grid.setBackground(new Color(36, 36, 36));

                JPanel[] body, bodyContent;
                body = new JPanel[itemsNumber];
                bodyContent = new JPanel[itemsNumber];

                JLabel[] lblUsername, lblPassword, lblPhone, lblMail, usernameValue, passwordValue, phoneValue,
                                mailValue;

                lblUsername = new JLabel[itemsNumber];
                lblPassword = new JLabel[itemsNumber];
                lblPhone = new JLabel[itemsNumber];
                lblMail = new JLabel[itemsNumber];

                usernameValue = new JLabel[itemsNumber];
                passwordValue = new JLabel[itemsNumber];
                phoneValue = new JLabel[itemsNumber];
                mailValue = new JLabel[itemsNumber];

                for (int i = 0; i < itemsNumber; i++) {
                        body[i] = new JPanel();
                        bodyContent[i] = new JPanel();
                        lblUsername[i] = new JLabel();
                        lblPassword[i] = new JLabel();
                        lblPhone[i] = new JLabel();
                        lblMail[i] = new JLabel();

                        usernameValue[i] = new JLabel();
                        passwordValue[i] = new JLabel();
                        phoneValue[i] = new JLabel();
                        mailValue[i] = new JLabel();

                        usernameValue[i].setHorizontalAlignment(SwingConstants.RIGHT);
                        passwordValue[i].setHorizontalAlignment(SwingConstants.RIGHT);
                        phoneValue[i].setHorizontalAlignment(SwingConstants.RIGHT);
                        mailValue[i].setHorizontalAlignment(SwingConstants.RIGHT);

                        bodyContent[i].setBackground(Color.BLACK);
                        bodyContent[i].setLayout(null);

                        generalUtils.changeFontAndText(lblUsername[i], true, "Tahoma", 20, "USERNAME:");
                        generalUtils.changeFontAndText(usernameValue[i], true, "Tahoma", 20,
                                        users.get(i).getUsername().toString());
                        generalUtils.labelChangeColorOrForeground(lblUsername[i], 255, 255, 255, false);
                        generalUtils.labelChangeColorOrForeground(usernameValue[i], 30, 140, 30, false);
                        lblUsername[i].setBounds(20, 10, 130, 20);
                        usernameValue[i].setBounds(200, 10, 100, 20);
                        bodyContent[i].add(lblUsername[i]);
                        bodyContent[i].add(usernameValue[i]);

                        generalUtils.changeFontAndText(lblPassword[i], true, "Tahoma", 20, "PASSWORD:");
                        generalUtils.changeFontAndText(passwordValue[i], true, "Tahoma", 20,
                                        users.get(i).getPassword());
                        generalUtils.labelChangeColorOrForeground(lblPassword[i], 255, 255, 255, false);
                        generalUtils.labelChangeColorOrForeground(passwordValue[i], 30, 140, 30, false);
                        lblPassword[i].setBounds(20, 45, 130, 20);
                        passwordValue[i].setBounds(200, 40, 100, 20);
                        bodyContent[i].add(lblPassword[i]);
                        bodyContent[i].add(passwordValue[i]);

                        generalUtils.changeFontAndText(lblPhone[i], true, "Tahoma", 20, "PHONE:");
                        generalUtils.changeFontAndText(phoneValue[i], true, "Tahoma", 20, users.get(i).getPhone());
                        generalUtils.labelChangeColorOrForeground(lblPhone[i], 255, 255, 255, false);
                        generalUtils.labelChangeColorOrForeground(phoneValue[i], 30, 140, 30, false);
                        lblPhone[i].setBounds(20, 80, 80, 20);
                        phoneValue[i].setBounds(200, 80, 100, 20);
                        bodyContent[i].add(lblPhone[i]);
                        bodyContent[i].add(phoneValue[i]);

                        generalUtils.changeFontAndText(lblMail[i], true, "Tahoma", 20, "MAIL:");
                        generalUtils.changeFontAndText(mailValue[i], true, "Tahoma", 20, users.get(i).getMail());
                        generalUtils.labelChangeColorOrForeground(lblMail[i], 255, 255, 255, false);
                        generalUtils.labelChangeColorOrForeground(mailValue[i], 30, 140, 30, false);
                        lblMail[i].setBounds(20, 120, 80, 20);
                        mailValue[i].setBounds(200, 120, 100, 20);
                        bodyContent[i].add(lblMail[i]);
                        bodyContent[i].add(mailValue[i]);

                        goFindUser(bodyContent, i, parent, users);

                        if (users.size() < 5) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() - 50, 400);
                        } else if (users.size() < 9) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 2, 400);
                        } else if (users.size() < 13) {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 3, 400);
                        } else {
                                initBody(body[i], bodyContent[i], parent.getBodyWidth() / 4, 400);
                        }

                        grid.add(body[i]);

                }
                return grid;
        }

        public void goFindUser(JPanel[] panel, int i, Navigator parent, ArrayList<User> users) {
                panel[i].addMouseListener(new MouseAdapter() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                                parent.goFindedUserPage(0, 50, parent.getBodyWidth(), parent.getBodyHeight(),
                                                users.get(i).getUsername());
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
                body.setBackground(new Color(36, 36, 36));
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
