import javax.swing.*;
import java.awt.*;
import java.io.File;  // Add this import statement

public class CalculatorGUI extends JFrame {

    private JTextField display;
    private JPanel buttonPanel;  // Declare buttonPanel as a class-level variable

    private String currentInput;
    private double result;
    private char operator;

    public CalculatorGUI() {
        super("Vue.js Style Calculator");

        currentInput = "";
        result = 0;
        operator = ' ';

        setLayout(new BorderLayout());
        getContentPane().setBackground(Color.decode("#282828")); // Set background color

        display = new JTextField();
        display.setEditable(false);
        display.setHorizontalAlignment(JTextField.RIGHT);
        try {
            // Load Bebas Neue font from the file
            Font bebasNeueFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/BebasNeue-Regular.ttf")).deriveFont(Font.PLAIN, 20);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(bebasNeueFont);
            display.setFont(bebasNeueFont);
        } catch (Exception e) {
            e.printStackTrace();
            // If loading the font fails, use a fallback font
            display.setFont(new Font("Arial", Font.PLAIN, 20));
        }
        add(display, BorderLayout.NORTH);

        buttonPanel = new JPanel(new GridLayout(5, 4, 5, 5)); // Add some padding
        buttonPanel.setBackground(Color.decode("#282828")); // Set button panel background color

        String[] buttonLabels = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "0", ".", "=", "+",
                "C" // Reset button
        };

        for (String label : buttonLabels) {
            JButton button = new JButton(label);
            button.addActionListener(new ButtonClickListener(this));
            button.setBackground(Color.decode("#222222")); // Set button background color
            try {
                // Load Bebas Neue font for buttons
                Font bebasNeueButtonFont = Font.createFont(Font.TRUETYPE_FONT, new File("font/BebasNeue-Regular.ttf")).deriveFont(Font.BOLD, 16);
                GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
                ge.registerFont(bebasNeueButtonFont);
                button.setFont(bebasNeueButtonFont);
            } catch (Exception e) {
                e.printStackTrace();
                // If loading the font fails, use a fallback font
                button.setFont(new Font("Arial", Font.BOLD, 16));
            }
            button.setBorder(BorderFactory.createLineBorder(Color.decode("#00bd7e"), 1)); // Add a white border
            button.setForeground(Color.decode("#00bd7e")); // Set text color to white
            buttonPanel.add(button);
        }

        add(buttonPanel, BorderLayout.CENTER);

        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);

        // Perform an initial calculation of 0 + 0
        simulateButtonClick("0");
        simulateButtonClick("+");
        simulateButtonClick("0");
        simulateButtonClick("=");
    }

    private void simulateButtonClick(String buttonText) {
        for (Component component : buttonPanel.getComponents()) {
            if (component instanceof JButton) {
                JButton button = (JButton) component;
                if (button.getText().equals(buttonText)) {
                    button.doClick();
                    return;
                }
            }
        }
    }

    public JTextField getDisplay() {
        return display;
    }

    public String getCurrentInput() {
        return currentInput;
    }

    public void setCurrentInput(String currentInput) {
        this.currentInput = currentInput;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public char getOperator() {
        return operator;
    }

    public void setOperator(char operator) {
        this.operator = operator;
    }

    public void resetCalculator() {
        currentInput = "";
        result = 0;
        operator = ' ';
        display.setText("");

        // Simulate button clicks for 0 + 0 after resetting
        simulateButtonClick("0");
        simulateButtonClick("+");
        simulateButtonClick("0");
        simulateButtonClick("=");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new CalculatorGUI());
    }
}
