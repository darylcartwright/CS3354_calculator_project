package calculatordemo2.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import calculatordemo2.button.*;

public class CreatePanel {
    public static final String[] digitValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static JButton[] digitButtons = new JButton[10];

    public static JButton one, two, three, four, five, six, seven, eight, nine, zero;
    public static JButton add, sub, mult, div, equal;
    public static JButton sin, cos, tan, arcsin, arccos, arctan;
    public static JButton sqrRt, sqr, inverse;
    public static JButton cancel;

    public static JPanel createDigitPanel() {
        JPanel digitPanel = new JPanel(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new CreateButton(digitValue[i]);
            digitPanel.add(digitButtons[i]);
        }

        return digitPanel;
    }

    public static JPanel createPrimitiveOperationPanel() {
        JPanel primitiveOperationPanel = new JPanel(new GridLayout(5, 1));

        add = CreateButton.createOperationButton("+");
        sub = CreateButton.createOperationButton("-");
        mult = CreateButton.createOperationButton("*");
        div = CreateButton.createOperationButton("/");
        equal = CreateButton.createOperationButton("=");

        primitiveOperationPanel.add(add);
        primitiveOperationPanel.add(sub);
        primitiveOperationPanel.add(mult);
        primitiveOperationPanel.add(div);
        primitiveOperationPanel.add(equal);

        return primitiveOperationPanel;
    }

    public static JPanel createTrigPanel() {
        JPanel trigPanel = new JPanel(new GridLayout(2, 3));

        sin = CreateButton.createOperationButton("sin");
        cos = CreateButton.createOperationButton("cos");
        tan = CreateButton.createOperationButton("tan");
        arcsin = CreateButton.createOperationButton("sin^-1");
        arccos = CreateButton.createOperationButton("cos^-1");
        arctan = CreateButton.createOperationButton("tan^-1");

        trigPanel.add(sin);
        trigPanel.add(cos);
        trigPanel.add(tan);
        trigPanel.add(arcsin);
        trigPanel.add(arccos);
        trigPanel.add(arctan);

        return trigPanel;
    }

    public static JPanel createBasicFunctionPanel() {
        JPanel basicFunctionPanel = new JPanel(new FlowLayout());

        sqrRt = CreateButton.createOperationButton("√");
        sqr = CreateButton.createOperationButton("x*x");
        inverse = CreateButton.createOperationButton("1/x");

        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    public static JPanel createCancelPanel() {
        JPanel cancelPanel = new JPanel(new FlowLayout());

        cancel = CreateButton.createOperationButton("C");

        cancelPanel.add(cancel);

        return cancelPanel;
    }
    
}
