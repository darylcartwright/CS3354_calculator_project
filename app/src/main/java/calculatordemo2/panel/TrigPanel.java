package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.CreateButton;

public class TrigPanel extends JPanel {
    public CreateButton sin, cos, tan;

    public TrigPanel() {
        setLayout(new FlowLayout());

        sin = new CreateButton("sin");
        cos = new CreateButton("cos");
        tan = new CreateButton("tan");

        add(sin);
        add(cos);
        add(tan);
    }
}