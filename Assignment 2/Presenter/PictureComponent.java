import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PictureComponent extends JPanel {

    private JLabel imageLabel;
    
    public PictureComponent(){
        imageLabel = new JLabel();
        add(imageLabel);
    }

    public void setImage(File imageFile){
        try {
            BufferedImage pic = ImageIO.read(imageFile);
            imageLabel.setIcon(new ImageIcon(pic));
            imageLabel.repaint();
        } catch (IOException e) {
            System.out.println("Error while setting image: "+e);
        }

    }

}
