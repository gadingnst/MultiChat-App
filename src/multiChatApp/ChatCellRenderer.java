package multiChatApp;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.logging.Logger;

public class ChatCellRenderer extends JLabel implements ListCellRenderer<String> {


    private void validateUsername(String username) {
        String s = username.trim().toLowerCase();
    }

    private Image resizeImage(ImageIcon icon){
        Image initImage = icon.getImage();
        return initImage.getScaledInstance(40,40,Image.SCALE_SMOOTH);
    }

    private void doInSwingWorker(){

    }

    @Override
    public Component getListCellRendererComponent(JList<? extends String> list, String value, int index, boolean isSelected, boolean cellHasFocus) {
        ImageIcon imageIcon= null;

        String cloud = "https://itpolsri.org/ftpclients/cb2016/icons";
        String local = "http://192.168.43.27/assets/icons/";

        try {

            URL u = new URL(local+value+".jpeg");
            HttpURLConnection http = (HttpURLConnection) u.openConnection();
            imageIcon = new ImageIcon(u);
            imageIcon.setImage(resizeImage(imageIcon));


            int responseCode = http.getResponseCode();
            System.err.println("Response code:: " + responseCode);
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
        System.err.println("before return this ChatCellRenderer...");
        return this;
    }
}
