
import com.mysql.cj.x.protobuf.MysqlxCrud;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 * @Description Create the search frame (Query search name and Delete search id)
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class PatientSearchFrame extends JFrame {
  
  /**
   * @description set the basic search window, including button, size, border, panel, textbox
   * @description create a table to show the searching patient information
   */
  public PatientSearchFrame() {
    this.setLocationRelativeTo(null);
    this.setSize(1600, 500);
    this.getContentPane().setLayout(new BorderLayout());
    JPanel northPanel = new JPanel();
    JTextField nameTextField = new JTextField(10);
    northPanel.add(nameTextField);
    JButton search = new JButton("SEARCH"); // SEARCH button
    northPanel.add(search);
    JButton delete = new JButton("DELETE"); // DELETE button
    northPanel.add(delete);
    this.getContentPane().add(northPanel, BorderLayout.NORTH);
    JScrollPane pane = new JScrollPane();
    this.setLocationRelativeTo(null); // display in the center
    
    Object[][] data = init(""); // 2D Object array to store all patient information
    
    // patient information table
    String[] column = {"id", "Name", "Gender", "Age", "Address", "Phone",
      "SSN", "Hospitalization_Date", "Symptom", "Treatment", "Recovery_Date",
      "After_Treatment", "Attending_Physician"};
    JTable table = new JTable(data, column);
    pane.setViewportView(table);
    this.getContentPane().add(pane, BorderLayout.CENTER);
    this.setVisible(true);
    
    // query operation according to the input patient name
    search.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        DefaultTableModel dtm = 
            new DefaultTableModel(init(nameTextField.getText()), column);
        table.setModel(dtm);
      }
    });
    
    // delete operation according to the input patient id
    delete.addActionListener(new ActionListener() {
      
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
    
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  
  
  /**
   * @description Store the patient information into the list
   * @param String patient name
   * @return Object[][]
   */
  public static Object[][] init(String name) {
    List<Patient> patientList = new PatientService().search(name);
    
    Object[][] patientInfo = new Object[patientList.size()][];
    for (int i = 0; i < patientList.size(); i++) {
      patientInfo[i] = new Object[13];
      patientInfo[i][0] = patientList.get(i).getId();
      patientInfo[i][1] = patientList.get(i).getName();
      patientInfo[i][2] = patientList.get(i).getGender();
      patientInfo[i][3] = patientList.get(i).getAge();
      patientInfo[i][4] = patientList.get(i).getAddress();
      patientInfo[i][5] = patientList.get(i).getPhone();
      patientInfo[i][6] = patientList.get(i).getSsn();
      patientInfo[i][7] = patientList.get(i).getHospitalizationDate();
      patientInfo[i][8] = patientList.get(i).getSymptom();
      patientInfo[i][9] = patientList.get(i).getTreatment();
      patientInfo[i][10] = patientList.get(i).getRecoveryDate();
      patientInfo[i][11] = patientList.get(i).getAfterTreatment();
      patientInfo[i][12] = patientList.get(i).getAttendingPhysician();
    }
    
    return patientInfo;
  }
}


