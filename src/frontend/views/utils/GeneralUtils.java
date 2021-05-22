package frontend.views.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Cursor;

public class GeneralUtils {

    public void customizeButton(JButton btn, boolean transparent) {

        if (transparent) {
            btn.setBorderPainted(false);
            btn.setContentAreaFilled(false);
        }
        btn.setBorder(null);
        btn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btn.setFocusPainted(false);
        btn.setHorizontalTextPosition(SwingConstants.CENTER);

    }

    public void buttonChangeColorOrForeground(JButton btn, int red, int green, int blue, boolean background) {

        if (background) {
            btn.setBackground(new Color(red, green, blue));
        }
        btn.setForeground(new Color(red, green, blue));
    }

    public void changeFontAndText(JLabel label, boolean bold, String newFont, int size, String text) {

        if (bold) {
            label.setFont(new Font(newFont, Font.BOLD, size));
            label.setText(text);
        } else {
            label.setText(text);
            label.setFont(new Font(newFont, Font.ITALIC, size));
        }
    }

    public void changeFontAndText(JButton btn, boolean bold, String newFont, int size, String text) {

        if (bold) {
            btn.setFont(new Font(newFont, Font.BOLD, size));
            btn.setText(text);
        } else {
            btn.setText(text);
            btn.setFont(new Font(newFont, Font.ITALIC, size));
        }
    }

    public ImageIcon scaleImageToLabel(String url, int width, int height) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource(url));
        Image image = imageIcon.getImage();
        Image scale = image.getScaledInstance(width, height, Image.SCALE_SMOOTH);
        ImageIcon scaledImage = new ImageIcon(scale);

        return scaledImage;
    }

}