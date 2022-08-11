
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * @Description Set the login window and implement login functionality
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class LoginInterface {
  
  // construct all the components on the Login frame
  static JFrame frame = new JFrame("Login");
  static JTextField usernameField = new JTextField();
  static JPasswordField passwordField = new JPasswordField();
  static JLabel usernameLabel = new JLabel("Username:");
  static JLabel passwordLabel = new JLabel("Password:");
  static JButton button = new JButton("Login");
  
  /**
   * @description Set up the login window, including bound, layout, size, button, textbox
   */
  public static void prepareLoginFrame() {
    
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setLayout(null);
    frame.setSize(500, 500);
    
    usernameField.setBounds(50, 100, 200, 30);
    passwordField.setBounds(50, 200, 200, 30);
    
    usernameLabel.setBounds(50, 50, 200, 30);
    passwordLabel.setBounds(50, 150, 200, 30);
    
    button.setBounds(50, 270, 200, 30);
    
    frame.add(usernameField);
    frame.add(passwordField);
    frame.add(usernameLabel);
    frame.add(passwordLabel);
    frame.add(button);
  }
  
  
  /**
   * @description Set up the template for waring dialogue
   * @param String title
   * @param String warning
   */
  public static void warningDialogue(String title, String warning) {
    JDialog dialogue = new JDialog(frame, title);
    JLabel label = new JLabel(warning);
    dialogue.add(label);
    label.setHorizontalAlignment(SwingConstants.CENTER);
    dialogue.setSize(500, 300);
    dialogue.setVisible(true);
  }
  
  
  /**
   * @description Load the user information and judge the access of the login
   * @param String username
   * @param String password
   * @return boolean
   */
  public static boolean loginJudge(String username, String password) {
    boolean flagAccess = false; // set the initial boolean value for access
    try {
      // read the username and password from the "user.txt"
      BufferedReader userFile = new BufferedReader(new FileReader("user.txt"));
      String usersInfo; // store all the user information as string
      
      while ((usersInfo = userFile.readLine()) != null) {
        
        // store the user information as the string,
        // users[0] for username, users[1] for password
        String[] users = usersInfo.split(" ");
        
        // compare the input username and password
        // judge the main window if they are correct
        if (users[0].equals(username)) {
          if (users[1].equals(password)) {
            frame.setVisible(false);
            MenuBar setMenu =  new MenuBar();
            setMenu.setMenu();
          } else { // show the error message if wrong
            warningDialogue("Warning", "Password Incorrect!");
          }
          flagAccess = true;
        }
      }
    } catch (FileNotFoundException e) { // the warning message when file cannot find
      warningDialogue("Warning", "File Not Found!");
    } catch (IOException e) {
      warningDialogue("Warning", "IO Exception!");
    }
    return flagAccess;
  }
  
  
  public static void main(String[] args) {
    
    prepareLoginFrame();
    
    button.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        
        boolean access = true;
        
        String usernameText = usernameField.getText();
        String passwordText = passwordField.getText();
        
        if (!Login.usernameIsValid(usernameText)) {
          // show the error message if the username is invalid
          access = false;
          warningDialogue("Warning", "<html><body>Invalid username!<br><br>"
                            + "The username should be an email address!<html><body>");
        } else if (!Login.passwordIsValid(passwordText)) {
          // show the error message if the password is invalid
          access = false;
          warningDialogue("Warning", "<html><body>Invalid password!<br><br>"
                            + "The password should have 8-20 characters,"
                            + "<br>at least a capital letter, a lowercase"
                            + "letter, and a digit.<html><body>");
        }
        
        // show the error if the user is not register in the "user.txt" file
        if (access) {
          access = loginJudge(usernameText, passwordText);
          if (!access) {
            warningDialogue("Warning", "User not found!");
          }
        }
      }
    });
    
    frame.setVisible(true);
  }
}
