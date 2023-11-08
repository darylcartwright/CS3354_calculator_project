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
       // JPanel digitPanel = new JPanel(new GridLayout(4, 3));
       JPanel digitPanel = new JPanel(new GridLayout(4, 3, 5, 5)); // Adjust spacing

       for (int i = 0; i < 10; i++) {
        digitButtons[i] = new CreateButton(digitValue[i]);
        digitButtons[i].setBackground(new Color(153, 153, 153)); // Assign a background color
        //digitButtons[i].setFont(new Font("Arial", Font.PLAIN, 20)); // Adjust font size
    }
        JPanel cancelPanel = createCancelPanel();

        // for (int i = 0; i < 10; i++) {
        //     digitButtons[i] = new CreateButton(digitValue[i]);
        // }

        // Make the '0' button twice as wide
    //     zero = new CreateButton(digitValue[0]);
    //     zero.setBackground(new Color(255, 153, 0)); // Assign the same background color as other digits
    //    // zero.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjust font size
    //     zero.setPreferredSize(new Dimension(240, 110)); // Make it twice as wide

    // Create a custom JPanel for the '0' button to set its size
    JPanel zeroPanel = new JPanel(new BorderLayout());
    zero = new CreateButton(digitValue[0]);
    zero.setBackground(new Color(255, 153, 0)); // Assign the same background color as other digits
    //zero.setFont(new Font("Arial", Font.PLAIN, 20)); // Adjust font size
    zeroPanel.add(zero, BorderLayout.CENTER);
    zeroPanel.setPreferredSize(new Dimension(80, 40)); // Make it twice as wide


        digitPanel.add(digitButtons[7]);
        digitPanel.add(digitButtons[8]);
        digitPanel.add(digitButtons[9]);
        digitPanel.add(digitButtons[4]);
        digitPanel.add(digitButtons[5]);
        digitPanel.add(digitButtons[6]);
        digitPanel.add(digitButtons[1]);
        digitPanel.add(digitButtons[2]);
        digitPanel.add(digitButtons[3]);
        //digitPanel.add(digitButtons[0]);
        digitPanel.add(zero); // Add the '0' button
        
       digitPanel.add(cancelPanel);

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
        JPanel basicFunctionPanel = new JPanel(new GridLayout(3, 1));

        sqrRt = CreateButton.createOperationButton("√");
        sqr = CreateButton.createOperationButton("x*x");
        inverse = CreateButton.createOperationButton("1/x");

        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    public static JPanel createCancelPanel() {
        JPanel cancelPanel = new JPanel();

        cancel = CreateButton.createOperationButton("C");

         // Separate color scheme for the "C" button
         cancel.setBackground(new Color(255, 204, 0)); // Orangish background
         cancel.setForeground(new Color(255, 255, 255)); // White text color

          // For adjusting the button size
        cancel.setPreferredSize(new Dimension(160, 90));


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
