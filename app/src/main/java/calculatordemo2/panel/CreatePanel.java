package calculatordemo2.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JTextArea;
import calculatordemo2.button.*;

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

       for (int i = 0; i < 10; i++) {
        digitButtons[i] = new CreateButton(digitValue[i]);
        digitButtons[i].setBackground(new Color(153, 153, 153)); 
    }
        JPanel cancelPanel = createCancelPanel();

        // Custom JPanel for the '0' button to set its size
        JPanel zeroPanel = new JPanel(new BorderLayout());
        zero = new CreateButton(digitValue[0]);
        zero.setBackground(new Color(255, 153, 0)); //Orange background color
        zeroPanel.add(zero, BorderLayout.CENTER);
        zeroPanel.setPreferredSize(new Dimension(20, 30)); // To make it twice as wide


        digitPanel.add(digitButtons[7]);
        digitPanel.add(digitButtons[8]);
        digitPanel.add(digitButtons[9]);
        digitPanel.add(digitButtons[4]);
        digitPanel.add(digitButtons[5]);
        digitPanel.add(digitButtons[6]);
        digitPanel.add(digitButtons[1]);
        digitPanel.add(digitButtons[2]);
        digitPanel.add(digitButtons[3]);
        digitPanel.add(zero); 
        
       digitPanel.add(cancelPanel);

        return digitPanel;
    }

    public static JPanel createPrimitiveOperationPanel() {
  
        JPanel primitiveOperationPanel = new JPanel(new GridLayout(5, 1, 5, 5)); 

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
        
        JPanel trigPanel = new JPanel(new GridLayout(2, 3, 5, 5)); 

        // trig function custom color
        Color trigButtonColor = new Color(255, 255, 153);

        sin = createCustomButton("sin", trigButtonColor);
        cos = createCustomButton("cos", trigButtonColor);
        tan = createCustomButton("tan", trigButtonColor);
        arcsin = createCustomButton("sin^-1", trigButtonColor);
        arccos = createCustomButton("cos^-1", trigButtonColor);
        arctan = createCustomButton("tan^-1", trigButtonColor);

        trigPanel.add(sin);
        trigPanel.add(cos);
        trigPanel.add(tan);
        trigPanel.add(arcsin);
        trigPanel.add(arccos);
        trigPanel.add(arctan);

        return trigPanel;
    }

    public static JButton createCustomButton(String text, Color backgroundColor) {
        JButton button = new CreateButton(text);
        button.setBackground(backgroundColor); 
        button.setPreferredSize(new Dimension(100, 40)); 
        return button;
    }

    public static JPanel createBasicFunctionPanel() {
            
        JPanel basicFunctionPanel = new JPanel(new GridLayout(3, 1, 5, 5)); 

        //custom color for the common function buttons
        Color commonFunctionButtonColor = new Color(204, 204, 204);

        sqrRt = createCustomButtonFunc("√", commonFunctionButtonColor);
        sqr = createCustomButtonFunc("x*x", commonFunctionButtonColor);
        inverse = createCustomButtonFunc("1/x", commonFunctionButtonColor);


        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    public static JButton createCustomButtonFunc(String text, Color backgroundColor) {
        JButton button = new CreateButton(text);
        button.setBackground(backgroundColor); 
        button.setPreferredSize(new Dimension(60, 75)); 
        return button;
    }

    public static JPanel createCancelPanel() {
        JPanel cancelPanel = new JPanel();

        cancel = CreateButton.createOperationButton("C");

        // Separate color scheme for the "C" button
         cancel.setBackground(new Color(255, 204, 0)); // Orangish background
         cancel.setForeground(new Color(255, 255, 255)); // White text color

        // For adjusting the button size
        cancel.setPreferredSize(new Dimension(50,45));

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
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(text, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

}
