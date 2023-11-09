package calculatordemo2.button;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class CreateButton extends JButton {

    public CreateButton(String label) {
        super(label);
        setBorder(new LineBorder(Color.BLACK));
    }

    public static JButton createDigitButton(String label) {
        JButton button = new CreateButton(label);

        button.setBackground(new Color(153, 153, 153));     // button color: dark gray
        button.setForeground(Color.BLACK);      // text color: black
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(100, 100)); // button size: 100 x 100
        return button;
    }

    public static JButton createPrimitiveOperationButton(String label) {
        JButton button = new CreateButton(label);

        button.setBackground(Color.WHITE);      // button color: white
        button.setForeground(Color.BLACK);      // text color: black
        button.setOpaque(true);
        //button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 80)); // button size: 100 x 80
        
        return button;
    }

    public static JButton createTrigButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 255, 153));     // button color: yellow
        button.setForeground(Color.BLACK);      // text color: black
        button.setOpaque(true);
        //button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(50, 50));     // button size: 50 x 50
        
        return button;
    }

    public static JButton createBasicFunctionButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(204, 204, 204));     // button color: light gray
        button.setForeground(Color.BLACK);      // text color: black
        button.setOpaque(true);
        //button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 100));   // button size: 100 x 100
        
        return button;
    }

    public static JButton createZeroButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 153, 0));       // button color: orange
        button.setForeground(Color.BLACK);      // text color: black
        button.setOpaque(true);
        //button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(200, 100));   // button size: 200 x 100 (twice as wide as other digits)
        
        return button;
    }

    public static JButton createCancelButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 204, 0));       // button color: yellow-orange 
        button.setForeground(Color.WHITE);      // text color: white
        button.setOpaque(true);
        //button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 100));   // button size: 100 x 100
        
        return button;
    }
}
