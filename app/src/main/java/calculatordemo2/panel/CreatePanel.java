package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.*;

public class CreatePanel {
    public static JPanel createNumberPanel() {
        JPanel numberPanel = new JPanel(new FlowLayout());
        CreateButton one, two, three, four, five, six, seven, eight, nine, zero;

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

        numberPanel.add(one);
        numberPanel.add(two);
        numberPanel.add(three);
        numberPanel.add(four);
        numberPanel.add(five);
        numberPanel.add(six);
        numberPanel.add(seven);
        numberPanel.add(eight);
        numberPanel.add(nine);
        numberPanel.add(zero);

        return numberPanel;    
    }

    public static JPanel createPrimitiveOperationPanel() {
        JPanel primitiveOperationPanel = new JPanel(new FlowLayout());
        CreateButton add, sub, mult, div, equal;

        add = new CreateButton("+");
        sub = new CreateButton("-");
        mult = new CreateButton("*");
        div = new CreateButton("/");
        equal = new CreateButton("=");

        primitiveOperationPanel.add(add);
        primitiveOperationPanel.add(sub);
        primitiveOperationPanel.add(mult);
        primitiveOperationPanel.add(div);
        primitiveOperationPanel.add(equal);

        return primitiveOperationPanel;
    }

    public static JPanel createTrigPanel() {
        JPanel trigPanel = new JPanel(new FlowLayout());
        CreateButton sin, cos, tan;

        sin = new CreateButton("Sin");
        cos = new CreateButton("Cos");
        tan = new CreateButton("Tan");

        trigPanel.add(sin);
        trigPanel.add(cos);
        trigPanel.add(tan);

        return trigPanel;
    }

    public static JPanel createBasicFunctionPanel() {
        JPanel basicFunctionPanel = new JPanel(new FlowLayout());
        CreateButton sqrRt, sqr, inverse;

        sqrRt = new CreateButton("√");
        sqr = new CreateButton("x*x");
        inverse = new CreateButton("1/x");

        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }
    
}
