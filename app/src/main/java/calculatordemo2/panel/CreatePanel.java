package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import calculatordemo2.button.*;

public class CreatePanel {
    public static final String[] buttonValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static CreateButton[] jButtons = new CreateButton[10];
    public static CreateButton one, two, three, four, five, six, seven, eight, nine, zero;
    public static CreateButton add, sub, mult, div, equal;
    public static CreateButton sin, cos, tan;
    public static CreateButton sqrRt, sqr, inverse;
    public static CreateButton cancel;

    public static JPanel createNumberPanel() {
        JPanel numberPanel = new JPanel(new FlowLayout());

        one = new CreateButton(buttonValue[1]);
        two = new CreateButton(buttonValue[2]);
        three = new CreateButton(buttonValue[3]);
        four = new CreateButton(buttonValue[4]);
        five = new CreateButton(buttonValue[5]);
        six = new CreateButton(buttonValue[6]);
        seven = new CreateButton(buttonValue[7]);
        eight = new CreateButton(buttonValue[8]);
        nine = new CreateButton(buttonValue[9]);
        zero = new CreateButton(buttonValue[0]);

        jButtons[1] = one;
        jButtons[2] = two;
        jButtons[3] = three;
        jButtons[4] = four;
        jButtons[5] = five;
        jButtons[6] = six;
        jButtons[7] = seven;
        jButtons[8] = eight;
        jButtons[9] = nine;
        jButtons[0] = zero;

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

        sqrRt = new CreateButton("√");
        sqr = new CreateButton("x*x");
        inverse = new CreateButton("1/x");

        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    public static JPanel createCancelPanel() {
        JPanel cancelPanel = new JPanel(new FlowLayout());

        cancel = new CreateButton("C");

        cancelPanel.add(cancel);

        return cancelPanel;
    }
    
}
