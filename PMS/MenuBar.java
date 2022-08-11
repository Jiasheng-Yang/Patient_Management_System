
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @Description Create Menu Bar for the main window
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class MenuBar {
  
  // set the size of main window
  public static final int WIDTH = 1000;
  public static final int HEIGHT = 700;
  
  /**
   * @description Set the Menu Bar
   */
  public void  setMenu() {
    
    // set the main menu bar (Management)
    JFrame frame = new JFrame("Patient Management System");
    frame.setSize(WIDTH, HEIGHT);
    JMenuBar menuBar = new JMenuBar();
    frame.setJMenuBar(menuBar);
    JMenu managementMenu = new JMenu("Manage");
    menuBar.add(managementMenu);
    
    // set the Query operation (sub menu) of the manage menu
    JMenuItem queryItem = new JMenuItem("Query");
    managementMenu.add(queryItem);
    queryItem.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new PatientSearchFrame();
      }
    });
    
    // set the Update operation (sub menu) of the manage menu
    JMenuItem openItem = new JMenuItem("Update");
    managementMenu.add(openItem);
    openItem.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Please Input ID: "));
          new PatientInfoForm(id);
        } catch (Exception x) {
          JOptionPane.showMessageDialog(null, "No Found");
        }
      }
    });
    
    // set the Delete operation (sub menu) of the manage menu
    JMenuItem deleteItem = new JMenuItem("Delete");
    managementMenu.add(deleteItem);
    deleteItem.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        try {
          Integer id = Integer.parseInt(JOptionPane.showInputDialog(null, "Please input ID: "));
          new PatientService().delete(id);
          JOptionPane.showMessageDialog(null, "SUCCESS DELETE");
        } catch (Exception ee) {
          JOptionPane.showMessageDialog(null, "No Found");
        }
      }
    });
    
    // set the main menu bar (Print)
    JMenu printMenu = new JMenu("Print");
    printMenu.setMnemonic('P');
    menuBar.add(printMenu);
    JMenuItem print = new JMenuItem("Print");
    printMenu.add(print);
    print.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new PrintFrame();
      }
    });
    
    // set the main menu bar (Register)
    JMenu editMenu = new JMenu("Register");
    menuBar.add(editMenu);
    JMenuItem reg = new JMenuItem("Register");
    editMenu.add(reg);
    reg.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        new PatientInfoForm(null);
      }
    });
    
    // close button for the window
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);
  }
}
