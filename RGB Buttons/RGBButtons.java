import java.awt.*;
import javax.swing.*;

public class RGBButtons {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setLayout(new FlowLayout());
        CircleIcon circle = new CircleIcon(50, 50);
        JLabel label = new JLabel(circle);
        
        JButton rButton = new JButton("Red");
        rButton.setBackground(Color.RED);
        rButton.addActionListener((e) -> {
            circle.setColor(Color.RED);
            label.repaint();
        });

        JButton gButton = new JButton("Green");
        gButton.setBackground(Color.GREEN);
        gButton.addActionListener((e) ->{
            circle.setColor(Color.GREEN);
            label.repaint();
            
        });

        JButton bButton = new JButton("Blue");
        bButton.setBackground(Color.BLUE);
        bButton.addActionListener((e) ->{
            circle.setColor(Color.BLUE);
            label.repaint();
        });

        frame.add(label);
        frame.add(rButton);
        frame.add(gButton);
        frame.add(bButton);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}