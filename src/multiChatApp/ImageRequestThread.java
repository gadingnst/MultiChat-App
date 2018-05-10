package multiChatApp;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Logger;

public class ImageRequestThread implements Runnable{
    private String username;
    private JLabel label;

    public ImageRequestThread(JLabel label , String username) {
        this.username = username;
        this.label = label;
    }

    @Override
    public void run() {
        Logger.getLogger(ImageRequestThread.class.getName()).info("run.....");

        ImageIcon imageIcon = null;
        try {
            URL u = new URL("https://itpolsri.org/ftpclients/cb2016/icons/"+username+".jpeg");
            imageIcon = new ImageIcon(u);
            HttpURLConnection http = (HttpURLConnection) u.openConnection();

            int responseCode = http.getResponseCode();
            switch (responseCode){
                case HttpURLConnection.HTTP_NOT_FOUND:
                    imageIcon = new ImageIcon(new URL("https://itpolsri.org/ftpclients/cb2016/icons/placeholder.jpeg"));
                    break;
            }
            Image gImage = imageIcon.getImage();
            Image rImage = gImage.getScaledInstance(40,40,Image.SCALE_SMOOTH);
            imageIcon.setImage(rImage);

            label.setBorder(new EmptyBorder(0,5,5,0));
            label.setText(username);
            label.setIcon(imageIcon);

            Logger.getLogger(ImageRequestThread.class.getName()).info("afterSetIcon.....");
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}
