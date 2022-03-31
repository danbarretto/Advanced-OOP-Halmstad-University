import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.*;

public class CircleIcon implements Icon {
    private int iconHeight = 10;
    private int iconWidth = 10;
    private Color color = Color.RED;

    public CircleIcon(){

    }

    public CircleIcon(int iconHeight, int iconWidth){
        this.iconHeight = iconHeight;
        this.iconWidth = iconWidth;
    }
    
    @Override
    public int getIconHeight() {
        return iconHeight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public int getIconWidth() {
        return iconWidth;
    }

    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        Graphics2D g2 = (Graphics2D) g;
        Ellipse2D.Double circle = new Ellipse2D.Double(0, 0, iconHeight, iconWidth);
        g2.setColor(color);
        g2.fill(circle);
    }

    
}
