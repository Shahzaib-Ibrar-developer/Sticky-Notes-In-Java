import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Task extends JFrame {
    JTextField textField;
    JLabel textJLabel;
    int count = 0;

    public void createWindow() {
        setSize(400, 400);
        setTitle("Task Manager");
        setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void creatingData() {
        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridLayout(10, 1));
        textField = new JTextField("Enter Your Task...");
        textField.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals("Enter Your Task...")) {
                    textField.setText("");
                }
            }
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText("Enter Your Task...");
                }
            }
        });
        
        textField.setAlignmentY(300);
        JButton submitButton = new JButton("Submit");
        textJLabel = new JLabel("No data available");
        submitButton.addActionListener(e -> {
            if (count == 0) {
                String data = textField.getText();
                textJLabel.setText(data);
                
                count = 1;

            }

            if (count == 1) {
                JLabel newText = new JLabel();
                String newData = textField.getText();
                newText.setText(newData);
                panel1.add(newText);
               
                count = 0;
            }
             textField.setText("Enter Your Task...");
        });

        panel1.add(textField);
        panel1.add(submitButton);
        panel1.add(textJLabel);
        add(panel1);
    }

    public static void main(String[] args) {
        Task t = new Task();
        t.createWindow();
        t.creatingData();

    }
}
