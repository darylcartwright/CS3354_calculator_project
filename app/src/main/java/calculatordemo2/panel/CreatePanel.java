package calculatordemo2.panel;

import javax.swing.JPanel;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import calculatordemo2.button.*;

public class CreatePanel {
    public static final String[] digitValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static CreateButton[] digitButtons = new CreateButton[10];
    public static CreateButton one, two, three, four, five, six, seven, eight, nine, zero;
    public static CreateButton add, sub, mult, div, equal;
    public static CreateButton sin, cos, tan, arcsin, arccos, arctan;
    public static CreateButton sqrRt, sqr, inverse;
    public static CreateButton cancel;

    public static JPanel createDigitPanel() {
        JPanel digitPanel = new JPanel(new GridLayout(4, 3));

        for (int i = 0; i < 10; i++) {
            digitButtons[i] = new CreateButton(digitValue[i]);
            digitPanel.add(digitButtons[i]);
        }

        return digitPanel;
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
        JPanel trigPanel = new JPanel(new GridLayout(2, 3));

        sin = new CreateButton("sin");
        cos = new CreateButton("cos");
        tan = new CreateButton("tan");
        arcsin = new CreateButton("sin^-1");
        arccos = new CreateButton("cos^-1");
        arctan = new CreateButton("tan^-1");

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
