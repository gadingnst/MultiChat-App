package MultiChatApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ListRenderer extends JLabel implements ListCellRenderer<String> {
    private void validateUsername(String username) {
        String s = username.trim().toLowerCase();
    }

    private Image resizeImage(ImageIcon icon){
        Image initImage = icon.getImage();
        return initImage.getScaledInstance(40,40,Image.SCALE_SMOOTH);
    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon= null;

        String cloud = "https://itpolsri.org/ftpclients/cb2016/icons";
        String local = "http://127.0.0.1/assets/icons/";

        try {

            URL u = new URL(local+value+".jpeg");
            HttpURLConnection http = (HttpURLConnection) u.openConnection();
            imageIcon = new ImageIcon(u);
            imageIcon.setImage(resizeImage(imageIcon));
            int responseCode = http.getResponseCode();
            switch (responseCode) {
                case HttpURLConnection.HTTP_NOT_FOUND:
                    URL sUrl = new URL(local+"placeholder.jpeg");
                    imageIcon = new ImageIcon(sUrl);
                    imageIcon.setImage(resizeImage(imageIcon));
                    break;
            }
        } catch (IOException e) {
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
