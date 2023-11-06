package calculatordemo2.button;

import javax.swing.JButton;

public class CreateButton extends JButton {

    public CreateButton(String label) {
        super(label);
    }

    public static JButton createOperationButton(String label) {
        return new CreateButton(label);
    }

    public static JButton createDigitButton(String label) {
        return new CreateButton(label);
    }
}
