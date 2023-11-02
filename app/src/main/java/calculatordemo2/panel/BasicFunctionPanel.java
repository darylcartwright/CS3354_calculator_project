package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.CreateButton;

public class BasicFunctionPanel extends JPanel {
    public CreateButton sqrRt, sqr, inverse;

    public BasicFunctionPanel() {
        setLayout(new FlowLayout());

        sqrRt = new CreateButton("√");
        sqr = new CreateButton("x*x");
        inverse = new CreateButton("1/x");

        add(sqrRt);
        add(sqr);
        add(inverse);
    }
}