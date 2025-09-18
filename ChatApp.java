package chatapppoe;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/*
 * ChatApp.java
 *
 * A self-contained Java chat application with GUI.
 * - Start a server (listening on a port) from the GUI.
 * - Start one or more clients (in separate program windows) and connect to the server.
 * - Server broadcasts messages to all connected clients.
 *
 * How to use:
 * 1. Save as ChatApp.java
 * 2. Compile:
 *      javac ChatApp.java
 * 3. Run:
 *      java ChatApp
 *
 * Then use the GUI:
 * - To host: click "Start Server" (choose port). The server runs inside the same process but on a background thread.
 * - To join as a client: fill in "Display name", "Server host" (default localhost), "Port" and click "Connect".
 * - You can open multiple instances (run java ChatApp repeatedly) and connect them to the same server,
 *   or start server and then start clients in the same JVM UI by connecting from the same window.
 *
 * Network notes:
 * - Default port is 5000.
 * - It's a simple plaintext protocol: first line a join message "JOIN:<name>", messages are "MSG:<text>",
 *   disconnects are handled when socket closes.
 *
 * This program is meant as an educational local chat demo and is not intended for production use.
 */


import javax.swing.*;
import java.awt.*;
import java.util.regex.*;

class User {
    private final String username;
    private final String password;
    private final String phone;

    public User(String username, String password, String phone) {
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public String getPhone() { return phone; }
}

public class ChatApp {
    private static User registeredUser = null;

    public static void main(String[] args) {
        // Launch registration form
        SwingUtilities.invokeLater(ChatApp::createRegistrationForm);
    }

    // === Registration Form ===
    private static void createRegistrationForm() {
        JFrame frame = new JFrame("User Registration");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JLabel phoneLabel = new JLabel("Phone (+27...):");
        JTextField phoneField = new JTextField();

        JButton registerBtn = new JButton("Register");

        frame.add(userLabel); frame.add(userField);
        frame.add(passLabel); frame.add(passField);
        frame.add(phoneLabel); frame.add(phoneField);
        frame.add(new JLabel()); frame.add(registerBtn);

        registerBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());
            String phone = phoneField.getText();

            String validation = validateInput(username, password, phone);

            if (validation.equals("SUCCESS")) {
                registeredUser = new User(username, password, phone);
                JOptionPane.showMessageDialog(frame, "Registration Successful!");
                frame.dispose();
                createLoginForm();
            } else {
                JOptionPane.showMessageDialog(frame, validation, "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // === Login Form ===
    private static void createLoginForm() {
        JFrame frame = new JFrame("User Login");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel userLabel = new JLabel("Username:");
        JTextField userField = new JTextField();

        JLabel passLabel = new JLabel("Password:");
        JPasswordField passField = new JPasswordField();

        JButton loginBtn = new JButton("Login");

        frame.add(userLabel); frame.add(userField);
        frame.add(passLabel); frame.add(passField);
        frame.add(new JLabel()); frame.add(loginBtn);

        loginBtn.addActionListener(e -> {
            String username = userField.getText();
            String password = new String(passField.getPassword());

            if (registeredUser != null &&
                registeredUser.getUsername().equals(username) &&
                registeredUser.getPassword().equals(password)) {

                JOptionPane.showMessageDialog(frame, "Login Successful! Welcome, " + username);
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid username or password!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        frame.setVisible(true);
    }

    // === Validation Rules (Public so JUnit can test them) ===
    public static String validateInput(String username, String password, String phone) {
        if (!checkUsername(username)) {
            return "Error: Username must contain '_' and be at least 5 characters long.";
        }

        if (!checkPasswordComplexity(password)) {
            return "Error: Password must be at least 8 chars, contain uppercase, lowercase, number, and special char.";
        }

        if (!checkPhoneNumber(phone)) {
            return "Error: Phone number must start with +27 and be 10 digits long.";
        }

        return "SUCCESS";
    }

    public static boolean checkUsername(String username) {
        return username != null && username.contains("_") && username.length() >= 5;
    }

    public static boolean checkPasswordComplexity(String password) {
        return password != null &&
               password.length() >= 8 &&
               password.matches(".*[A-Z].*") &&   // uppercase
               password.matches(".*[a-z].*") &&   // lowercase
               password.matches(".*\\d.*") &&     // digit
               password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"); // special char
    }

    public static boolean checkPhoneNumber(String phone) {
        if (phone == null) return false;
        Pattern phonePattern = Pattern.compile("^\\+27\\d{8,9}$");
        return phonePattern.matcher(phone).matches();
    }
}


