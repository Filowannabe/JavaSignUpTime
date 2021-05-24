package frontend.views.pages;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;

import frontend.navigator.Navigator;
import frontend.views.utils.GeneralUtils;

public class NotFound extends JPanel {

    private JLabel notFound;
    private GeneralUtils generalUtils;

    public NotFound(Navigator parent) {
        notFound = new JLabel();
        generalUtils = new GeneralUtils();
        notFound.setBounds((parent.getBodyHeight() / 2) + 40, (parent.getBodyHeight() / 6), 700, 400);
        generalUtils.changeFontAndText(notFound, true, "Tahoma", 90, "NOT FOUNDED");
        generalUtils.labelChangeColorOrForeground(notFound, 255, 255, 255, false);

        add(notFound);
        setBackground(new Color(36, 36, 36));
    }
}
