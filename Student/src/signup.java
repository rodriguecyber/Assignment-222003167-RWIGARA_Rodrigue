import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class signup extends JFrame {
    private JTextField firstNameField, lastNameField, regNoField, nationalIdField, campusField, departmentField, collegeField;
    private JPasswordField pinField, reEnterPinField;
    JButton submitButton;

    public signup() {
        setTitle("Student Registration");
        setSize(400, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

         JLabel head=new JLabel("FILL THE FORM TO REGISTER");
         head.setForeground(Color.blue);
         head.setBounds(100,10,400,20);
        // Labels and Text Fields
        JLabel firstNameLabel = new JLabel("First Name:");
        firstNameLabel.setForeground(Color.BLUE);
        firstNameLabel.setBounds(30,50,200,30);
        firstNameField = new JTextField();
        firstNameField.setBounds(160,50,200,30);
        JLabel lastNameLabel = new JLabel("Last Name:");
        lastNameLabel.setForeground(Color.BLUE);
        lastNameLabel.setBounds(30,90,200,30);
        lastNameField = new JTextField();
        lastNameField.setBounds(160,90,200,30);
        JLabel regNoLabel = new JLabel("Reg No:");
        regNoLabel.setForeground(Color.BLUE);
        regNoLabel.setBounds(30,130,200,30);
        regNoField = new JTextField();
        regNoField.setBounds(160,130,200,30);
        JLabel nationalIdLabel = new JLabel("National ID:");
        nationalIdLabel.setForeground(Color.BLUE);
        nationalIdLabel.setBounds(30,170,200,30);
        nationalIdField = new JTextField();
        nationalIdField.setBounds(160,170,200,30);
        JLabel campusLabel = new JLabel("Campus:");
        campusLabel.setForeground(Color.BLUE);
        campusLabel.setBounds(30,210,200,30);
        campusField = new JTextField();
        campusField.setBounds(160,210,200,30);
        JLabel departmentLabel = new JLabel("Department:");
        departmentLabel.setForeground(Color.BLUE);
        departmentLabel.setBounds(30,250,200,30);
        departmentField = new JTextField();
        departmentField.setBounds(160,250,200,30);
        JLabel collegeLabel = new JLabel("College:");
        collegeLabel.setForeground(Color.BLUE);
        collegeLabel.setBounds(30,290,200,30);
        collegeField = new JTextField();
        collegeField.setBounds(160,290,200,30);
        JLabel pinLabel = new JLabel("Password:");
        pinLabel.setForeground(Color.BLUE);
        pinLabel.setBounds(30,330,200,30);
        pinField = new JPasswordField();
        pinField.setBounds(160,330,200,30);
        JLabel reEnterPinLabel = new JLabel("Re-Enter Password:");
        reEnterPinLabel.setForeground(Color.BLUE);
        reEnterPinLabel.setBounds(30,370,200,30);
        reEnterPinField = new JPasswordField();
        reEnterPinField.setBounds(160,370,200,30);
        // Submit Button
       submitButton = new JButton("Submit");
        submitButton.setBounds(200,410,80,30);
        submitButton.setBackground(Color.blue);
        submitButton.setForeground(Color.LIGHT_GRAY);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                insertData();
            }
        });

        // Add Components to JLabel
        add(firstNameLabel);
        add(firstNameField);
        add(lastNameLabel);
        add(lastNameField);
        add(regNoLabel);
        add(regNoField);
        add(nationalIdLabel);
        add(nationalIdField);
        add(campusLabel);
        add(campusField);
        add(departmentLabel);
        add(departmentField);
        add(collegeLabel);
        add(collegeField);
        add(pinLabel);
        add(pinField);
        add(reEnterPinLabel);
        add(reEnterPinField);
        add(submitButton);
        add(head);
        //add(panel);
        setVisible(true);
    }

    private void insertData() {
        // Get Text Field Values
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String regNo = regNoField.getText();
        String nationalId = nationalIdField.getText();
        String campus = campusField.getText();
        String department = departmentField.getText();
        String college = collegeField.getText();
        String pin = String.valueOf(pinField.getPassword());
        String reEnterPin = String.valueOf(reEnterPinField.getPassword());

        // Validate Text Field Inputs
        if (firstName.isEmpty() || lastName.isEmpty() || regNo.isEmpty() || nationalId.isEmpty() || campus.isEmpty() || department.isEmpty() || college.isEmpty() || pin.isEmpty() || reEnterPin.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Fill in all field!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!pin.equals(reEnterPin)) {
            JOptionPane.showMessageDialog(this, "Password do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "");
            String query = "INSERT INTO student (firstname, lastname, regno, Nationalid, Campus, Department, College, Pin) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, firstName);
            statement.setString(2, lastName);
            statement.setString(3, regNo);
            statement.setString(4, nationalId);
            statement.setString(5, campus);
            statement.setString(6, department);
            statement.setString(7, college);
            statement.setString(8, pin);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                JOptionPane.showMessageDialog(this, "You Now Registered!");
            } else {
                JOptionPane.showMessageDialog(this, "Failed to Register.", "Error", JOptionPane.ERROR_MESSAGE);
            }
            conn.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error.", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new signup());
    }
}
