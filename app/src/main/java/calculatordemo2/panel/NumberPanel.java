package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.*;

public class NumberPanel extends JPanel {
    public CreateButton one, two, three, four, five, six, seven, eight, nine, zero;

    public NumberPanel() {
        setLayout(new FlowLayout());

        one = new CreateButton("1");
        two = new CreateButton("2");
        three = new CreateButton("3");
        four = new CreateButton("4");
        five = new CreateButton("5");
        six = new CreateButton("6");
        seven = new CreateButton("7");
        eight = new CreateButton("8");
        nine = new CreateButton("9");
        zero = new CreateButton("0");

        add(one);
        add(two);
        add(three);
        add(four);
        add(five);
        add(six);
        add(seven);
        add(eight);
        add(nine);
        add(zero);

        
    }
    
}
