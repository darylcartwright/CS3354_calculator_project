package calculatordemo2.panel;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
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
    public static JTextArea text;   // Text area for displaying input and output


    /**
     * Creates a panel containing digit buttons from 1 to 9 in a 3x3 grid.
     * @return The panel with digit buttons.
     */
    public static JPanel createOneToNinePanel() {
        JPanel oneToNinePanel = new JPanel(new GridLayout(3, 3, 0, 0));     
        
        // Creating digit buttons with number labels
        for (int i = 1; i <= 9; i++) {
            digitButtons[i] = CreateButton.createDigitButton(digitValue[i]);
        }

        // Add digit buttons to grid
        oneToNinePanel.add(digitButtons[7]);
        oneToNinePanel.add(digitButtons[8]);
        oneToNinePanel.add(digitButtons[9]);
        oneToNinePanel.add(digitButtons[4]);
        oneToNinePanel.add(digitButtons[5]);
        oneToNinePanel.add(digitButtons[6]);
        oneToNinePanel.add(digitButtons[1]);
        oneToNinePanel.add(digitButtons[2]);
        oneToNinePanel.add(digitButtons[3]);
    
        return oneToNinePanel;
    }

    /**
     * Creates a panel containing the zero and cancel buttons.
     * @return The panel with zero and cancel buttons.
     */
    public static JPanel createZeroCancelPanel() {
        JPanel zeroCancelPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        
        // Creating zero button and assigning it into the 0 index of the digitButtons array
        zero = CreateButton.createZeroButton(digitValue[0]);
        digitButtons[0] = zero;

        // Creating cancel button
        cancel = CreateButton.createCancelButton("C");

        // Adding the zero and cancel button to the panel
        zeroCancelPanel.add(zero);
        zeroCancelPanel.add(cancel);

        return zeroCancelPanel;
    }

    /**
     * Creates a panel containing all the digit buttons
     * Includes the 1 - 9 buttons and the 0 and C button
     * @return The panel with all digit buttons.
     */
    public static JPanel createDigitPanel() {
        JPanel digitPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        JPanel oneToNinePanel = createOneToNinePanel();
        JPanel zeroCancelPanel = createZeroCancelPanel();

        // Adding the grid 1 - 9 panel and the zeroCancel panel together
        digitPanel.add(oneToNinePanel);
        digitPanel.add(zeroCancelPanel);
    
        return digitPanel;
    }
    
    /**
     * Creates a panel containing primitive operation buttons (+, -, *, /, =).
     * @return The panel with primitive operation buttons.
     */
    public static JPanel createPrimitiveOperationPanel() {
        // Grid layout of 1 column 5 rows to create a vertical display of the buttons
        JPanel primitiveOperationPanel = new JPanel(new GridLayout(5, 1, 0, 0)); 

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

    /**
     * Creates a panel containing trigonometric function buttons (sin, cos, tan, arcsin, arccos, arctan).
     * @return The panel with trigonometric function buttons.
     */
    public static JPanel createTrigPanel() {
        // Grid layout of 2 rows and 3 columns
        JPanel trigPanel = new JPanel(new GridLayout(2, 3, 0, 0)); 

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

    /**
     * Creates a panel containing basic function buttons (√, x*x, 1/x).
     * @return The panel with basic function buttons.
     */
    public static JPanel createBasicFunctionPanel() {
        // Grid layout of 3 rows and 1 column for a vertical button display
        JPanel basicFunctionPanel = new JPanel(new GridLayout(3, 1, 0, 0)); 

        sqrRt = CreateButton.createBasicFunctionButton("√");
        sqr = CreateButton.createBasicFunctionButton("x*x");
        inverse = CreateButton.createBasicFunctionButton("1/x");


        basicFunctionPanel.add(sqrRt);
        basicFunctionPanel.add(sqr);
        basicFunctionPanel.add(inverse);

        return basicFunctionPanel;
    }

    /**
     * Creates the main button panel by combining trigonometric, digit, basic function, and primitive operation panels.
     * @return The main button panel.
     */
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

     /**
     * Creates the main panel by combining the text area and the button panel.
     * @return The main panel.
     */
    public static JPanel createMainPanel() {
        text = new JTextArea();
        text.setPreferredSize(new Dimension(200, 100));
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        JPanel buttonPanel = createButtonPanel();

        mainPanel.add(text, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        return mainPanel;
    }

}
