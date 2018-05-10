package multiChatApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.MalformedURLException;
import java.net.URL;

public class ChatCellRenderer extends JLabel implements ListCellRenderer<String> {
    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon = null  ;
        try {
            imageIcon = new ImageIcon(new URL("http://192.168.43.27/assets/icons/avatar1.png"));
            Image initImage = imageIcon.getImage();
            Image resizeImage = initImage.getScaledInstance(40,40,Image.SCALE_SMOOTH);
            imageIcon.setImage(resizeImage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        if(imageIcon != null) {
            setIcon(imageIcon);
        }
        setBorder(new EmptyBorder(0,5,5,0));
        setText(value);
        return this;
    }
}
