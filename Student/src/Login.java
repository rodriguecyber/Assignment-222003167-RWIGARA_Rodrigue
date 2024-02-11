import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {

    int REG;
    String NAME1, NAME2;
    public String NAME,id,college,campus,depart;
    public String reg;
    String PASSWORD;
    int state;

    JTextField regTextField;
    JPasswordField pwField;
    JButton logButton,signupButton;

    public Login() {
        setSize(400, 200);
        setTitle("Login Form");
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create and customize JLabels
        JLabel regLabel = new JLabel("Enter Your RegNo:");
        JLabel pwLabel = new JLabel("Enter Your Password:");
        regLabel.setBounds(30, 40, 120, 30);
        pwLabel.setBounds(30, 80, 150, 30);
        customizeLabel(regLabel);
        customizeLabel(pwLabel);
        add(regLabel);
        add(pwLabel);
        JLabel create=new JLabel("OR ");
        create.setBounds(180,110,50,50);
        add(create);
        customizeLabel(create);

        // Create and customize text fields
        regTextField = new JTextField();
        pwField = new JPasswordField();
        regTextField.setBounds(200, 40, 120, 30);
        pwField.setBounds(200, 80, 120, 30);
        customizeTextField(regTextField);
        customizeTextField(pwField);
        add(regTextField);
        add(pwField);

        // Create and customize  buttons
        logButton = new JButton("Login");
        logButton.setBounds(50, 120, 80, 30);

        customizeButton(logButton);
        add(logButton);
        signupButton = new JButton(" Register");
        signupButton.setBounds(250,120,100,30);
        customizeButton(signupButton);
        add(signupButton);

        // Add action listener to the login button
        logButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                login();
            }
        });
        signupButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                new signup();
                dispose();
            }
        });

        // Set JFrame visibility
        setVisible(true);
    }

    // Method to customize JLabels
    private void customizeLabel(JLabel label) {
        label.setFont(new Font("Arial", Font.PLAIN, 14));
        label.setForeground(Color.BLUE);
    }

    // Method to customize text fields
    private void customizeTextField(JTextField textField) {
        textField.setFont(new Font("Arial", Font.PLAIN, 14));
        textField.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }

    // Method to customize buttons
    private void customizeButton(JButton button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.BLUE);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false); // Remove focus border
    }

    void login() {
        REG = Integer.parseInt(regTextField.getText());
        PASSWORD = new String(pwField.getPassword());

        try (Connection connection = DbConnector.connect1();
             PreparedStatement statement = connection.prepareStatement("SELECT * FROM student");
             ResultSet result = statement.executeQuery()) {

            while (result.next()) {
                if (REG == result.getInt(3) && PASSWORD.equals(result.getString(8))) {
                    // Handle successful login
                    JOptionPane.showMessageDialog(this, "Login Successfully ", "Success",JOptionPane.INFORMATION_MESSAGE);
                    state = 1;
                    NAME1 = result.getString(1);
                    NAME2 = result.getString(2);
                    reg=result.getString(3);
                    NAME=NAME1+" "+NAME2;
                    id=result.getString(4);
                    campus= result.getString(5);
                    depart = result.getString(6);
                    college =  result.getString(7);

                    openDashboard();

                    return;
                }
            }

            // Handle unsuccessful login
            JOptionPane.showMessageDialog(this, "Incorrect username or password " , "Error.", JOptionPane.ERROR_MESSAGE);

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this,"You are not connected" , "Error.", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Close the connection in a final block

        }
    }

    private void openDashboard() {
        // Close the current window
        dispose();

        // Create and display the Dashboard
        new Dashboard(NAME,reg,id,depart,college,campus);
    }

    public static void main(String[] args) {


                new Login();
            }
        }


