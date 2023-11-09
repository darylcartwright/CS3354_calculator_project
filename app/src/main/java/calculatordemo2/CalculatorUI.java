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
 * @author Soria, Steckler, Tesic, Metsis
 */

public class CalculatorUI implements ActionListener {
	private final JFrame frame;
    private final JPanel mainPanel;
    private final Calculator calc;
	public final int FRAME_WIDTH;
	public final int FRAME_HEIGHT;
	// Added for testing purpose
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
		FRAME_HEIGHT = 700;
	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method of the UI class.
	 */
	public void init() {
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);

		//Added seperate action listener methods
		
        addDigitButtonListeners();
        addActionListenersForOperators();

		frame.add(mainPanel);
		frame.setVisible(true);

	}

	private void addDigitButtonListeners() {
		for (int i = 0; i < 10; i++) {
			JButton digitButton = CreatePanel.digitButtons[i];
			digitButton.addActionListener(this);
		}
	}

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
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object source = e.getSource();
		String currentText = text.getText();
	
		// Handle digit buttons (buttons 0 to 9)
		for (int i = 0; i < 10; i++) {
			JButton digitButton = CreatePanel.digitButtons[i];
			if (source == digitButton) {
				String digitValue = CreatePanel.digitValue[i];
				currentText = text.getText();
				text.setText(currentText + digitValue);
				return; // Exit the method after handling the button click
			}
		}

		// Some of the following operations have the text cleared afterwards to prevent accidental appending of digits.
		if (source == CreatePanel.add) {
			writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
			text.setText(""); 
		}
		if (source == CreatePanel.sub) {
			writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
			text.setText(""); 
		}
		if (source == CreatePanel.mult) {
			writer(calc.twoOpCaller(Calculator.twoOperator.multiply, reader()));
			text.setText("");
		}
		if (source == CreatePanel.div) {
			writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
			text.setText("");
		}
		if (source == CreatePanel.sqr) {
			writer(calc.calcScience(Calculator.singleOperator.square, reader()));
		}
		if (source == CreatePanel.sqrRt) {
			writer(calc.calcScience(Calculator.singleOperator.squareRoot, reader()));
		}
		if (source == CreatePanel.inverse) {
			writer(calc.calcScience(Calculator.singleOperator.oneDividedBy, reader()));
		}
		if (source == CreatePanel.cos) {
			writer(calc.calcScience(Calculator.singleOperator.cos, reader()));
		}
		if (source == CreatePanel.sin) {
			writer(calc.calcScience(Calculator.singleOperator.sin, reader()));
		}
		if (source == CreatePanel.tan) {
			writer(calc.calcScience(Calculator.singleOperator.tan, reader()));
		}
		if (source == CreatePanel.arccos) {
			writer(calc.calcScience(Calculator.singleOperator.arccos, reader()));
		}
		if (source == CreatePanel.arcsin) {
			writer(calc.calcScience(Calculator.singleOperator.arcsin, reader()));
		}
		if (source == CreatePanel.arctan) {
			writer(calc.calcScience(Calculator.singleOperator.arctan, reader()));
		}
		if (source == CreatePanel.equal) {
			writer(calc.calculateEqual(reader()));
		}
		if (source == CreatePanel.cancel) {
			writer(calc.reset());
		}

		// for easy continued calculations/copy
		text.selectAll();

	}

	/**
	 * Helper function that gets the texfield area and updates the number input
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
	 * @param num
	 */
	public void writer(final Double num) {
		if (Double.isNaN(num)) {
			text.setText(""); // Clear the text field if the result is NaN
		} else {
			text.setText(Double.toString(num)); // Set the text field with the number
		}
	}
}
