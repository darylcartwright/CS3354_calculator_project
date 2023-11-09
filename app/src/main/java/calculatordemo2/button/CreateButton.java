package calculatordemo2.button;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;

public class CreateButton extends JButton {

    public CreateButton(String label) {
        super(label);
    }

    public static JButton createDigitButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(153, 153, 153));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 100));
        return button;
    }

    public static JButton createPrimitiveOperationButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(Color.WHITE);
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 100));
        
        return button;
    }

    public static JButton createTrigButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 255, 153));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(50, 50));
        return button;
    }

    public static JButton createBasicFunctionButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(204, 204, 204));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(100, 100));
        return button;
    }

    public static JButton createZeroButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 153, 0));
        button.setForeground(Color.BLACK);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(200, 100));
        return button;
    }

    public static JButton createCancelButton(String label) {
        JButton button = new CreateButton(label);
        button.setBackground(new Color(255, 204, 0));
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(200, 100));
        return button;
    }
}
