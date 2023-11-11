package calculatordemo2.button;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.border.LineBorder;

public class CreateButton extends JButton {

    public CreateButton(String label) {
        super(label);
        setBorder(new LineBorder(Color.BLACK));     // black border around each individual button
    }

    private static JButton createStyledButton(String label, Color buttonColor, Color textColor, int width, int height) {
        JButton button = new CreateButton(label);

        button.setBackground(buttonColor);      // set color of button
        button.setForeground(textColor);        // set color of text on button
        button.setOpaque(true);
        button.setPreferredSize(new Dimension(width, height));  // size of button

        return button;
    }

    public static JButton createDigitButton(String label) {
        // Button color: dark gray, text color: black, size: 100 x 100
        return createStyledButton(label, new Color(153, 153, 153), Color.BLACK, 100, 100);
    }

    public static JButton createPrimitiveOperationButton(String label) {
        // Button color: white, text color: black: size: 100 x 80
        return createStyledButton(label, Color.WHITE, Color.BLACK, 100, 80);
    }

    public static JButton createTrigButton(String label) {
        // Button color: yellow, text color: black, size: 50 x 50
        return createStyledButton(label, new Color(255, 255, 153), Color.BLACK, 50, 50);
    }

    public static JButton createBasicFunctionButton(String label) {
        // Button color: light gray, text color: black, size: 100 x 100
        return createStyledButton(label, new Color(204, 204, 204), Color.BLACK, 100, 100);
    }

    public static JButton createZeroButton(String label) {
        // Button color: orange, text color: black, size: 200 x 100 (twice as wide as other digit buttons)
        return createStyledButton(label, new Color(255, 153, 0), Color.BLACK, 200, 100);
    }

    public static JButton createCancelButton(String label) {
        // Button color: yellow-orange, text color: white, size: 100 x 100
        return createStyledButton(label, new Color(255, 204, 0), Color.WHITE, 100, 100);
    }
}
