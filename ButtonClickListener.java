import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickListener implements ActionListener {

    private CalculatorGUI calculatorGUI;

    public ButtonClickListener(CalculatorGUI calculatorGUI) {
        this.calculatorGUI = calculatorGUI;
    }

    public void actionPerformed(ActionEvent event) {
        JButton source = (JButton) event.getSource();
        String buttonText = source.getText();

        if (Character.isDigit(buttonText.charAt(0)) || buttonText.equals(".")) {
            calculatorGUI.setCurrentInput(calculatorGUI.getCurrentInput() + buttonText);
            calculatorGUI.getDisplay().setText(calculatorGUI.getCurrentInput());
        } else if (buttonText.equals("=")) {
            calculateResult();
        } else if (buttonText.equals("C")) {
            calculatorGUI.resetCalculator();
        } else {
            if (!calculatorGUI.getCurrentInput().isEmpty()) {
                calculateResult();
            }
            calculatorGUI.setOperator(buttonText.charAt(0));
            calculatorGUI.setResult(Double.parseDouble(calculatorGUI.getCurrentInput()));
            calculatorGUI.setCurrentInput("");
        }
    }

    private void calculateResult() {
        if (!calculatorGUI.getCurrentInput().isEmpty()) {
            double input = Double.parseDouble(calculatorGUI.getCurrentInput());
            switch (calculatorGUI.getOperator()) {
                case '+':
                    calculatorGUI.setResult(calculatorGUI.getResult() + input);
                    break;
                case '-':
                    calculatorGUI.setResult(calculatorGUI.getResult() - input);
                    break;
                case '*':
                    calculatorGUI.setResult(calculatorGUI.getResult() * input);
                    break;
                case '/':
                    if (input != 0) {
                        calculatorGUI.setResult(calculatorGUI.getResult() / input);
                    } else {
                        JOptionPane.showMessageDialog(calculatorGUI, "Cannot divide by zero", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                    break;
            }
            calculatorGUI.getDisplay().setText(String.valueOf(calculatorGUI.getResult()));
            calculatorGUI.setCurrentInput("");
        }
    }
}
