package frontend.views.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
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
        } else {
            btn.setForeground(new Color(red, green, blue));
        }
    }

    public void labelChangeColorOrForeground(JLabel label, int red, int green, int blue, boolean background) {

        if (background) {
            label.setBackground(new Color(red, green, blue));
        } else {
            label.setForeground(new Color(red, green, blue));
        }
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

    public void changeFontAndText(JTextField field, boolean bold, String newFont, int size, String text) {
        field.setOpaque(false);
        field.setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(204, 204, 204)));
        if (bold) {
            field.setFont(new Font(newFont, Font.BOLD, size));
            field.setText(text);
        } else {
            field.setText(text);
            field.setFont(new Font(newFont, Font.ITALIC, size));
        }
    }

    public void textChangeColorOrForeground(JTextField field, int red, int green, int blue, boolean background) {

        if (background) {
            field.setBackground(new Color(red, green, blue));
        } else {
            field.setForeground(new Color(red, green, blue));
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