package calculatordemo2;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

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
	private final JTextArea text;

	/**
	 * The main top level GUI of the calculator and it's frame, button, and text area for # display
	 */
	public CalculatorUI() {
		frame = new JFrame("Calculator");
		frame.setResizable(true);
		text = new JTextArea(2, 25);

		mainPanel = new JPanel(new FlowLayout());
		calc = new Calculator();

	}

		// JPanel numberPanel = CreatePanel.createNumberPanel();
		// numberPanel.setLayout(new GridLayout(4, 3));
		// JPanel primitiveOperationsPanel = CreatePanel.createPrimitiveOperationPanel();
		// JPanel trigPanel = CreatePanel.createTrigPanel();
		// JPanel basicFunctionPanel = CreatePanel.createBasicFunctionPanel();
		// JPanel cancelPanel = CreatePanel.createCancelPanel();

		//mainPanel = new JPanel(new FlowLayout());
		// mainPanel.add(text);

		// mainPanel.add(numberPanel);
		// mainPanel.add(primitiveOperationsPanel);
		// mainPanel.add(trigPanel);
		// mainPanel.add(basicFunctionPanel);
		// mainPanel.add(cancelPanel);

		//calc = new Calculator();
	}

	/**
	 * Initializes and sets the frame size, buttons, panels. The main runner method of the UI class.
	 */
	public void init() {
		frame.setSize(300, 340);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		//frame.add(mainPanel);

		addComponentsToMainPanel();
        addNumberButtonListeners();
        addActionListenersForOperators();
        addActionListenerForEqual();
        addActionListenerForCancel();

		frame.add(mainPanel);
		frame.setVisible(true);

	}

	private void addComponentsToMainPanel() {
		JPanel numberPanel = CreatePanel.createNumberPanel();
        numberPanel.setLayout(new GridLayout(4, 3));
        JPanel primitiveOperationsPanel = CreatePanel.createPrimitiveOperationPanel();
        JPanel trigPanel = CreatePanel.createTrigPanel();
        JPanel basicFunctionPanel = CreatePanel.createBasicFunctionPanel();
        JPanel cancelPanel = CreatePanel.createCancelPanel();

        mainPanel.add(text);
        mainPanel.add(numberPanel);
        mainPanel.add(primitiveOperationsPanel);
        mainPanel.add(trigPanel);
        mainPanel.add(basicFunctionPanel);
        mainPanel.add(cancelPanel);
    }

	private void addNumberButtonListeners() {
		for (int i = 0; i < 10; i++) {
            CreatePanel.jButtons[i].addActionListener(this);
        }
	}

        CreatePanel.add.addActionListener(this);
        CreatePanel.sub.addActionListener(this);
        CreatePanel.mult.addActionListener(this);
        CreatePanel.div.addActionListener(this);
        CreatePanel.sqr.addActionListener(this);
        CreatePanel.sqrRt.addActionListener(this);
        CreatePanel.inverse.addActionListener(this);
        CreatePanel.cos.addActionListener(this);
        CreatePanel.sin.addActionListener(this);
        CreatePanel.tan.addActionListener(this);
        CreatePanel.equal.addActionListener(this);
        CreatePanel.cancel.addActionListener(this);


		frame.setVisible(true);
	}

	/**
	 * Event handling implementation for Calculator button pressing
	 * @param e
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		final Object source = e.getSource();
		// check 0-9 and update textfield

		 for (int i = 0; i < 10; i++) {
			if (source == CreatePanel.jButtons[i]) {
                text.replaceSelection(CreatePanel.buttonValue[i]);
                return;
            }
        }
		if (source == CreatePanel.add) {
			writer(calc.twoOpCaller(Calculator.twoOperator.add, reader()));
		}
		if (source == CreatePanel.sub) {
			writer(calc.twoOpCaller(Calculator.twoOperator.subtract, reader()));
		}
		if (source == CreatePanel.mult) {
			writer(calc.twoOpCaller(Calculator.twoOperator.multiply,
					reader()));
		}
		if (source == CreatePanel.div) {
			writer(calc.twoOpCaller(Calculator.twoOperator.divide, reader()));
		}
		if (source == CreatePanel.sqr) {
			writer(calc.calcScience(Calculator.singleOperator.square,
					reader()));
		}
		if (source == CreatePanel.sqrRt) {
			writer(calc.calcScience(Calculator.singleOperator.squareRoot,
					reader()));
		}
		if (source == CreatePanel.inverse) {
			writer(calc.calcScience(
					Calculator.singleOperator.oneDevidedBy, reader()));
		}
		if (source == CreatePanel.cos) {
			writer(calc.calcScience(Calculator.singleOperator.cos,
					reader()));
		}
		if (source == CreatePanel.sin) {
			writer(calc.calcScience(Calculator.singleOperator.sin,
					reader()));
		}

		if (source == CreatePanel.tan) {
			writer(calc.calcScience(Calculator.singleOperator.tan,
					reader()));
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
			text.setText("");
		} else {
			text.setText(Double.toString(num));
		}
	}
}
