package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.CreateButton;

public class PrimitiveOperationPanel extends JPanel {
    public CreateButton div, mult, sub, add, equal;

    public PrimitiveOperationPanel() {
        setLayout(new FlowLayout());

        div = new CreateButton("/");
        mult = new CreateButton("*");
        sub = new CreateButton("-");
        add = new CreateButton("+");
        equal = new CreateButton("=");

        add(div);
        add(mult);
        add(sub);
        add(add);
        add(equal);
    }
}