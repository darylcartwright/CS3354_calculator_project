package calculatordemo2.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import calculatordemo2.button.CreateButton;

public class CreatePanel {
    public static final String[] digitValue = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};

    public static JButton[] digitButtons = new JButton[10];

    public static JButton one, two, three, four, five, six, seven, eight, nine, zero;
    public static JButton add, sub, mult, div, equal;
    public static JButton sin, cos, tan, arcsin, arccos, arctan;
    public static JButton sqrRt, sqr, inverse;
    public static JButton cancel;
    public static JTextArea text;

    public static JPanel createDigitPanel() {
        JPanel digitPanel = new JPanel(new GridLayout(4, 3, 5, 5)); 
    
        for (int i = 1; i <= 9; i++) {
            digitButtons[i] = CreateButton.createDigitButton(digitValue[i]);
        }

        digitPanel.add(digitButtons[7]);
        digitPanel.add(digitButtons[8]);
        digitPanel.add(digitButtons[9]);
        digitPanel.add(digitButtons[4]);
        digitPanel.add(digitButtons[5]);
        digitPanel.add(digitButtons[6]);
        digitPanel.add(digitButtons[1]);
        digitPanel.add(digitButtons[2]);
        digitPanel.add(digitButtons[3]);
    
        JPanel zeroPanel = createZeroPanel();
        digitPanel.add(zeroPanel);


        JPanel cancelPanel = createCancelPanel();
        //cancel.setForeground(Color.BLACK);
        digitPanel.add(cancelPanel);
    
        return digitPanel;
    }

    public static JPanel createZeroPanel() {
        JPanel zeroPanel = new JPanel();
        zero = CreateButton.createZeroButton(digitValue[0]);
        digitButtons[0] = zero;
        zeroPanel.add(zero);
        return zeroPanel;
    }
    

    public static JPanel createPrimitiveOperationPanel() {
  
        JPanel primitiveOperationPanel = new JPanel(new GridLayout(5, 1, 5, 5)); 

        add = CreateButton.createPrimitiveOperationButton("+");
        sub = CreateButton.createPrimitiveOperationButton("-");
        mult = CreateButton.createPrimitiveOperationButton("*");
        div = CreateButton.createPrimitiveOperationButton("/");
        equal = CreateButton.createPrimitiveOperationButton("=");

        primitiveOperationPanel.add(add);
        primitiveOperationPanel.add(sub);
        primitiveOperationPanel.add(mult);
        primitiveOperationPanel.add(div);
        primitiveOperationPanel.add(equal);

        return primitiveOperationPanel;
    }

    public static JPanel createTrigPanel() {
        
        JPanel trigPanel = new JPanel(new GridLayout(2, 3, 5, 5)); 

        sin = CreateButton.createTrigButton("sin");
        cos = CreateButton.createTrigButton("cos");
        tan = CreateButton.createTrigButton("tan");
        arcsin = CreateButton.createTrigButton("sin^-1");
        arccos = CreateButton.createTrigButton("cos^-1");
        arctan = CreateButton.createTrigButton("tan^-1");

        trigPanel.add(sin);
        trigPanel.add(cos);
        trigPanel.add(tan);
        trigPanel.add(arcsin);
        trigPanel.add(arccos);
        trigPanel.add(arctan);

        return trigPanel;
    }

    public static JPanel createBasicFunctionPanel() {
            
        JPanel basicFunctionPanel = new JPanel(new GridLayout(3, 1, 5, 5)); 

        sqrRt = CreateButton.createBasicFunctionButton("√");
        sqr = CreateButton.createBasicFunctionButton("x*x");
        inverse = CreateButton.createBasicFunctionButton("1/x");


        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    public static JPanel createCancelPanel() {
        JPanel cancelPanel = new JPanel();

        cancel = CreateButton.createCancelButton("C");

        cancelPanel.add(cancel);

        return cancelPanel;
    }

    public static JPanel createButtonPanel() {
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        JPanel trigPanel = createTrigPanel();
        JPanel digitPanel = createDigitPanel();
        JPanel basicFunctionPanel = createBasicFunctionPanel();
        JPanel primitiveOperationPanel = createPrimitiveOperationPanel();

        buttonPanel.add(trigPanel, BorderLayout.NORTH);
        buttonPanel.add(digitPanel, BorderLayout.CENTER);
        buttonPanel.add(basicFunctionPanel, BorderLayout.WEST);
        buttonPanel.add(primitiveOperationPanel, BorderLayout.EAST);

        return buttonPanel;
    }

    public static JPanel createMainPanel() {
        text = new JTextArea();
        text.setPreferredSize(new Dimension(200, 50));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(text, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

}
