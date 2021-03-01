package application;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main implements ActionListener {

    private static JLabel userLabel;
    private static JTextField userText;
    private static JPasswordField passwordText;
    private static JLabel passwordLabel;
    private static JButton button1;
    private static JLabel success;

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        frame.setSize(350, 200);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        JPanel panel = new JPanel();
        panel.setLayout(null);


        userLabel = new JLabel("User");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);

        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        passwordLabel = new JLabel("Password");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);

        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        button1 = new JButton("login");
        button1.setBounds(100, 80, 165, 25);
        button1.addActionListener(new Main());
        panel.add(button1);


        success = new JLabel("");
        success.setBounds(10, 110, 300, 25);
        panel.add(success);


        frame.add(panel);
        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String user = userText.getText();
        String password = passwordText.getText();
        System.out.println(user + ", " + password);

        if (user.equals("Marat") && password.equals("eklmn-eprst")) {
            success.setText("login correct");

        } else {
            success.setText("login incorrect");
        }
    }
}
