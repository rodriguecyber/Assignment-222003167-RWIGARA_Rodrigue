import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dashboard extends JFrame {
    TextField Name1, College, RegNo, IdNo, Campus, Depart;
    Label name1, college, idno, campus, depart, regno,head;
    Button b1;

    public Dashboard(String studentName, String regNo, String id,String Dep,String Coll,String Camp) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 600);
        setLayout(null);
        setVisible(true);
        setTitle("  HOME");
        setLocationRelativeTo(null);

        name1 = new Label("Student Names:");
        idno = new Label("National Identity:");
        college = new Label("College:");
        campus = new Label("Campus:");
        depart = new Label("Department:");
        regno = new Label("RegNo:");
        head = new Label("WELCOME BACK!");

        add(name1);
        add(idno);
        add(college);
        add(campus);
        add(depart);
        add(regno);
        add(head);

        Name1 = new TextField(" "+studentName);
        College = new TextField(" "+Coll);
        IdNo = new TextField(" "+id);
        RegNo = new TextField(" "+regNo);
        Campus = new TextField(" "+Camp);
        Depart = new TextField(" "+Dep);

        add(Name1);
        add(College);
        add(IdNo);
        add(RegNo);
        add(Campus);
        add(Depart);

        head.setBounds(60,40,180,30);
        name1.setBounds(30, 105, 90, 30);
        college.setBounds(30, 145, 80, 30);
        idno.setBounds(30, 185, 100, 30);
        regno.setBounds(30, 225, 80, 30);
        campus.setBounds(30, 265, 80, 30);
        depart.setBounds(30, 305, 80, 30);

        Name1.setBounds(160, 105, 150, 30);
        College.setBounds(160, 145, 150, 30);
        IdNo.setBounds(160, 185, 150, 30);
        RegNo.setBounds(160, 225, 150, 30);
        Campus.setBounds(160, 265, 150, 30);
        Depart.setBounds(160, 305, 150, 30);

        b1 = new Button("Logout");
        add(b1);
        b1.setBounds(120, 360, 100, 30);
        customizeButton(b1); // Customizing the logout button

        // ActionListener for logout button
        b1.addActionListener(new ActionListener() {
           // @Override
            public void actionPerformed(ActionEvent e) {
                // Implement logout functionality here
                dispose();
               new  Login(); // Close the Dashboard window on logout
            }
        });
    }

    // Method to customize buttons
    private void customizeButton(Button button) {
        button.setFont(new Font("Arial", Font.BOLD, 14));
        button.setBackground(Color.RED);
        button.setForeground(Color.WHITE);
        //button.setFocusPainted(false); // Remove focus border
    }
}
