package calculatordemo2;
/**
 * Main runner that initializes and runs the UI
 *
 * Special Notes:
 *
 * Pressing a single operator button will immediately display the result without pressing "="
 * After pressing an operand, sometimes the first button press immediately after will not register
 * By using a list/array button implementation generation, you limit the flexibility in positioning
 * the buttons
 *
 * @author Soria, Steckler, Tesic, Metsis
 */

import calculatordemo2.panel.CreatePanel;
public class CalculatorMain {

	public static void main(String[] args) {
		CalculatorUI uiCal = new CalculatorUI();
		uiCal.init();
/* 		for (int i = 0; i < 10; i++) {
			System.out.println(CreatePanel.digitValue[i]);
			System.out.println(CreatePanel.digitButtons[i].getText());
		} */
	}
}
