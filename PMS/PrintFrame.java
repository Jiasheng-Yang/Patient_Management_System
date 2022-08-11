
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;


/**
 * @Description Search and preview patient information and export as ".txt" file
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class PrintFrame extends JFrame {
  
  /**
   * Search and preview patient information and export as ".txt" file
   */
  public PrintFrame() {
    
    // set the Print window, including button, size, border, panel, textbox
    this.setLocationRelativeTo(null);
    this.setSize(600, 400);
    this.getContentPane().setLayout(new BorderLayout());
    this.setLocationRelativeTo(null); // display in the center
    
    JPanel northPanel = new JPanel();
    JTextField nameTextField = new JTextField(10);
    northPanel.add(nameTextField);
    JButton search = new JButton("SEARCH"); // "SEARCH" button
    northPanel.add(search);
    this.getContentPane().add(northPanel, BorderLayout.NORTH);
    JTextArea area = new JTextArea();
    this.getContentPane().add(area, BorderLayout.CENTER);
    JPanel southPanel = new JPanel();
    JButton reset = new JButton("RESET"); // "RESET" button
    southPanel.add(reset);
    JButton print = new JButton("PRINT"); // "PRINT" button
    southPanel.add(print);
    this.getContentPane().add(southPanel, BorderLayout.SOUTH);
    this.setVisible(true);
    area.setEditable(false);
    
    // search the input patient information and preview it
    search.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] nameInput = init(nameTextField.getText())[0];
        
        List<Patient> patientList = new PatientService().search(nameTextField.getText());
        Patient patient = patientList.get(0);
        String result = "";
        result += "Patient_ID:" + patient.getId() + "\n";
        result += "Patient_Name:" + patient.getName() + "\n";
        result += "Age:" + patient.getAge() + "\n";
        result += "Gender:" + patient.getGender() + "\n";
        result += "Address:" + patient.getAddress() + "\n";
        result += "Phone:" + patient.getPhone() + "\n";
        result += "Email:" + patient.getEmail() + "\n";
        result += "SSN:" + patient.getSsn() + "\n";
        result += "Hospitalization_Date:" + patient.getHospitalizationDate() + "\n";
        result += "Symptom:" + patient.getSymptom() + "\n";
        result += "Treatment:" + patient.getTreatment() + "\n";
        result += "Recovery_Date:" + patient.getRecoveryDate() + "\n";
        result += "After_Treatment:" + patient.getAfterTreatment() + "\n";
        result += "Attending_Physician:" + patient.getAttendingPhysician();
        
        // show the result information
        area.setText(result);
      }
    });
    
    // write the patient the information into the "Patient_Name.txt" file
    print.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        Object[] nameInput = init(nameTextField.getText())[0];
        
        List<Patient> patientList = new PatientService().search(nameTextField.getText());
        Patient patient = patientList.get(0);
        String result = "";
        result += "Patient_ID:" + patient.getId() + "\n";
        result += "Patient_Name:" + patient.getName() + "\n";
        result += "Age:" + patient.getAge() + "\n";
        result += "Gender:" + patient.getGender() + "\n";
        result += "Address:" + patient.getAddress() + "\n";
        result += "Phone:" + patient.getPhone() + "\n";
        result += "Email:" + patient.getEmail() + "\n";
        result += "SSN:" + patient.getSsn() + "\n";
        result += "Hospitalization_Date:" + patient.getHospitalizationDate() + "\n";
        result += "Symptom:" + patient.getSymptom() + "\n";
        result += "Treatment:" + patient.getTreatment() + "\n";
        result += "Recovery_Date:" + patient.getRecoveryDate() + "\n";
        result += "After_Treatment:" + patient.getAfterTreatment() + "\n";
        result += "Attending_Physician:" + patient.getAttendingPhysician();
        
        // write and export patient case
        try {
          // set the filename
          BufferedWriter caseReport = new
              BufferedWriter(new FileWriter("" + patient.getName() + ".txt"));
          // write the search result
          caseReport.write(result);
          caseReport.close();
        } catch (IOException e1) {
          e1.printStackTrace();
        }
      }
    });
    
    // reset button for starting a new print window
    reset.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        resetValueActionPerformed(0);
      }
      
      private void resetValueActionPerformed(int i) {
        new PrintFrame();
      }
    });
    // close window button
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
  
  /**
   * @description Store the patient information into the list
   * @param String patient name
   * @return Object[][]
   */
  public Object[][] init(String name) {
    return PatientSearchFrame.init(name);
  }
}