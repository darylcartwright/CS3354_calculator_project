package calculatordemo2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;

import calculatordemo2.panel.CreatePanel;


/**
 * CalculatorUI class that creates and adds buttons, event handling for the buttons, and calls calculator
 * methods and functions for logic when necessary
 * 
 * This class implements the ActionListener interface to handle button click events.
 * 
 * @author Soria, Steckler, Tesic, Metsis
 */

public class CalculatorUI implements ActionListener {
	private final JFrame frame;
    private final JPanel mainPanel;
    private final Calculator calc;
	private final int FRAME_WIDTH;
	private final int FRAME_HEIGHT;
	private static final int NUM_DIGITS = 10;
	final JTextArea text;

	/**
	 * The main top level GUI of the calculator and it's frame, button, and text area for # display
	 */
	public CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setResizable(true);
		mainPanel = CreatePanel.createMainPanel();
		calc = new Calculator();
		text = CreatePanel.text;
		FRAME_WIDTH = 500;
		FRAME_HEIGHT = 625;

	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method of the UI class.
	 */
	public void init() {
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
        addDigitButtonListeners();
        addActionListenersForOperators();

		frame.add(mainPanel);
		frame.setVisible(true);

	}

	/**
	 * Adds action listeners for digit buttons
	 */
	private void addDigitButtonListeners() {
		for (int i = 0; i < NUM_DIGITS; i++) {
			JButton digitButton = CreatePanel.digitButtons[i];
			digitButton.addActionListener(this);
		}
	}

	/**
	 * Adds action listeners for operator buttons
	 */
	private void addActionListenersForOperators() {
		JButton[] operationButtons = {CreatePanel.add, CreatePanel.sub, CreatePanel.mult, CreatePanel.div, CreatePanel.equal, 
										CreatePanel.sqr, CreatePanel.sqrRt, CreatePanel.inverse,
										CreatePanel.cos, CreatePanel.sin, CreatePanel.tan, 
										CreatePanel.arcsin, CreatePanel.arccos, CreatePanel.arctan,
										CreatePanel.cancel};

		for (JButton button : operationButtons) {
			button.addActionListener(this);
		}
	}

	/**
	 * Event handling implementation for Calculator button pressing
	 * @param e ActionEvent triggered by button click.
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();

    	// Handle digit buttons (buttons 0 to 9)
    	for (int i = 0; i < 10; i++) {
        	JButton digitButton = CreatePanel.digitButtons[i];
        	if (source == digitButton) {
            	handleDigitButtonClick(digitButton);
            	return; // Exit the method after handling the button click
        	}
    	}
	
    	// Handle other buttons
    	if (source instanceof JButton) {
			JButton button = (JButton) source;

        	if (button == CreatePanel.add || button == CreatePanel.sub || button == CreatePanel.mult || button == CreatePanel.div) {
				handleOperatorButtonClick(button);
			} else if (button == CreatePanel.sqr || button == CreatePanel.sqrRt || button == CreatePanel.inverse ||
					   button == CreatePanel.cos || button == CreatePanel.sin || button == CreatePanel.tan ||
					   button == CreatePanel.arccos || button == CreatePanel.arcsin || button == CreatePanel.arctan) {
	 			handleScienceButtonClick(button);
 			} else if (button == CreatePanel.equal) {
            	handleEqualButtonClick();
        	} else if (button == CreatePanel.cancel) {
            	handleCancelButtonClick();
        	}
    	}

    	// For easy continued calculations/copy
    	text.selectAll();
	}
	
	// Helper method for handling digit buttons
	private void handleDigitButtonClick(JButton button) {
    	String digitValue = button.getText();
    	String currentText = text.getText();
    	text.setText(currentText + digitValue);
	}
	
	// Helper method for handling operator buttons
	private void handleOperatorButtonClick(JButton button) {
		// Get the operator type from the button and current text value
		Calculator.twoOperator operator = getOperatorTypeFromButton(button);
		Double value = reader();

		// Perform the two-operator calculation, update the display, and clear the text field
		writer(calc.twoOpCaller(operator, value));
		text.setText("");
	}
	
	// Helper method for handling science buttons
	private void handleScienceButtonClick(JButton button) {
		// Get the science type from the button and current text value
		Calculator.singleOperator operator = getScienceTypeFromButton(button);
		Double value = reader();

		// Perform the scientific calculation, update the display, and clear the text field
		writer(calc.calcScience(operator, value));
	}

	// Helper method for handling equal button
	private void handleEqualButtonClick() {
		// Calculate the result for the current expression and update the display
		writer(calc.calculateEqual(reader()));
	}
	
	// Helper method for handling cancel button
	private void handleCancelButtonClick() {
		// Reset the calculator and update the display
		writer(calc.reset());
	}

	// Helper method to determine the two-operator type based on the button source
	private Calculator.twoOperator getOperatorTypeFromButton(Object source) {
		if (source == CreatePanel.add) {
			return Calculator.twoOperator.add;
		} else if (source == CreatePanel.sub) {
			return Calculator.twoOperator.subtract;
		} else if (source == CreatePanel.mult) {
			return Calculator.twoOperator.multiply;
		} else if (source == CreatePanel.div) {
			return Calculator.twoOperator.divide;
		} else {
			throw new IllegalArgumentException("Invalid operator button: " + source);
		}
	}

	// Helper method to determine the scientific operator type based on the button source
	private Calculator.singleOperator getScienceTypeFromButton(Object source) {
		if (source == CreatePanel.sqr) {
			return Calculator.singleOperator.square;
		} else if (source == CreatePanel.sqrRt) {
			return Calculator.singleOperator.squareRoot;
		} else if (source == CreatePanel.inverse) {
			return Calculator.singleOperator.oneDividedBy;
		} else if (source == CreatePanel.cos) {
			return Calculator.singleOperator.cos;
		} else if (source == CreatePanel.sin) {
			return Calculator.singleOperator.sin;
		} else if (source == CreatePanel.tan) {
			return Calculator.singleOperator.tan;
		} else if (source == CreatePanel.arccos) {
			return Calculator.singleOperator.arccos;
		} else if (source == CreatePanel.arcsin) {
			return Calculator.singleOperator.arcsin;
		} else if (source == CreatePanel.arctan) {
			return Calculator.singleOperator.arctan;
		} else {
			throw new IllegalArgumentException("Invalid science button: " + source);
		}
	}
	

	/**
	 * Helper function that gets the text field area and updates the number input
	 * 
	 * @return the updated number
	 */
	public Double reader() {
		Double num;
		String str;
		str = text.getText();
		num = Double.valueOf(str);

		return num;
	}

	/**
	 * Helper function that sets the textfield with the number, and avoids NaN issues
	 * @param num the number to be displayed
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText(""); // Clear the text field if the result is NaN
		} else {
			text.setText(Double.toString(num)); // Set the text field with the number
		}
	}
}
