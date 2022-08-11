
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;


/**
 * @Description Patient Information Form for register and update
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class PatientInfoForm extends JFrame {
  
  /**
   * @description Create the register patient form based on JFrame
   * @param Integer id
   */
  public PatientInfoForm(Integer id) {
    
    // set the basic layout, panel, background, border for the register window
    this.setLayout(new BorderLayout(10, 10));
    this.setLocationRelativeTo(null); // display in the center
    JPanel centerPanel = new JPanel();
    centerPanel.setLayout(new BorderLayout());
    centerPanel.setBorder(new EmptyBorder(30, 30, 30, 30));
    
    JPanel formPanel = new JPanel();
    formPanel.setLayout(new BorderLayout());
    JLabel title = new JLabel("Register Patient", JLabel.CENTER);
    title.setOpaque(true);
    title.setBackground(Color.LIGHT_GRAY);
    formPanel.add(title, BorderLayout.NORTH);
    
    JPanel formItemPanel = new JPanel();
    // set label and textbox in the left
    formItemPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
    
    // Panel1 for the first line of the form, including labels and input boxes (Name, Gender, Age)
    JPanel panel1 = new JPanel();
    panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel1.add(new JLabel("Name:")); // Name
    JTextField nameTextField = new JTextField(10);
    panel1.add(nameTextField);
    panel1.add(new JLabel("Gender:")); // Gender
    JTextField genderTextField = new JTextField(10);
    panel1.add(genderTextField);
    panel1.add(new JLabel("Age:"));  // Age
    JTextField ageTextField = new JTextField(10);
    panel1.add(ageTextField);
    Box vbox = Box.createVerticalBox();
    vbox.add(panel1);
    vbox.add(Box.createVerticalGlue());
    
    // Panel2 for the second line of the form, including labels and input boxes (Address, Email)
    JPanel panel2 = new JPanel();
    panel2.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel2.add(new JLabel("Address:")); // Address
    JTextField addressTextField = new JTextField(20);
    panel2.add(addressTextField);
    panel2.add(new JLabel("Email:")); // Email
    JTextField emailTextField = new JTextField(20);
    panel2.add(emailTextField);
    vbox.add(panel2);
    
    // Panel3 for the third line of the form, including labels and input boxes (Phone, SSN)
    JPanel panel3 = new JPanel();
    panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel3.add(new JLabel("Phone:")); // Phone
    JTextField phoneTextField = new JTextField(20);
    panel3.add(phoneTextField);
    panel3.add(new JLabel("SSN:"));  // SSN
    JTextField ssnTextField = new JTextField(20);
    panel3.add(ssnTextField);
    vbox.add(panel3);
    
    // Panel4 for the forth line of the form,
    // including labels and input boxes (Date of Hospitalization)
    JPanel panel4 = new JPanel();
    panel4.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel4.add(new JLabel("Date of Hospitalization:"));
    JTextField yearTextField = new JTextField(10); // Year
    panel4.add(yearTextField);
    JTextField monthTextField = new JTextField(10); // Month
    panel4.add(monthTextField);
    JTextField dateTextField = new JTextField(10); // Date
    panel4.add(dateTextField);
    vbox.add(panel4);
    
    // Panel5 for the fifth line of the form, including labels and input boxes (Illness)
    JPanel panel5 = new JPanel();
    panel5.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel5.add(new JLabel("Illness:"));
    JTextField illnessTextField = new JTextField(20);
    panel5.add(illnessTextField);
    vbox.add(panel5);
    
    // Panel6 for the sixth line of the form, including labels and input boxes (Treatment)
    JPanel panel6 = new JPanel();
    panel6.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel6.add(new JLabel("Treatment:"));
    JTextField treatmentTextField = new JTextField(20);
    panel6.add(treatmentTextField);
    vbox.add(panel6);
    
    // Panel7 for the seventh line of the form, including labels and input boxes (Date of Recovery)
    JPanel panel7 = new JPanel();
    panel7.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel7.add(new JLabel("Date of Recovery(Year/Month/Day):"));
    JTextField yearTextField1 = new JTextField(10);  // Year
    panel7.add(yearTextField1);
    JTextField monthTextField1 = new JTextField(10); // Month
    panel7.add(monthTextField1);
    JTextField dateTextField1 = new JTextField(10);  // Date
    panel7.add(dateTextField1);
    vbox.add(panel7);
    
    // Panel8 for the eighth line of the form, including labels and input boxes (After Treatment)
    JPanel panel8 = new JPanel();
    panel8.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel8.add(new JLabel("After Treatment:"));
    JTextField afTextField = new JTextField(20);
    panel8.add(afTextField);
    vbox.add(panel8);
    
    // Panel9 for the ninth line of the form, including labels and input boxes (Attending Physician)
    JPanel panel9 = new JPanel();
    panel9.setLayout(new FlowLayout(FlowLayout.LEFT));
    panel9.add(new JLabel("Attending Physician:"));
    JTextField apTextField = new JTextField(20);
    panel9.add(apTextField);
    vbox.add(panel9);
    
    // Form in the center of the page
    formItemPanel.add(vbox);
    formPanel.add(formItemPanel, BorderLayout.CENTER);
    
    // Submit and Reset buttons
    JPanel southPanel = new JPanel();
    // set the button in the right of southPanel
    southPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
    JButton submit = new JButton("SUBMIT");  // SUBMIT
    southPanel.add(submit);
    JButton reset = new JButton("RESET");  // RESET
    southPanel.add(reset);
    
    formPanel.add(southPanel, BorderLayout.SOUTH);
    
    centerPanel.add(formPanel, BorderLayout.CENTER);
    
    // Action Listener
    this.add(centerPanel, BorderLayout.CENTER);
    this.setLocationRelativeTo(null);
    this.setVisible(true);
    this.pack();
    submit.addActionListener(new ActionListener() {
      
      @Override
      public void actionPerformed(ActionEvent e) {
        Patient patient = new Patient();
        patient.setName(nameTextField.getText());
        patient.setAge(Integer.parseInt(ageTextField.getText()));
        patient.setGender(genderTextField.getText());
        patient.setAddress(addressTextField.getText());
        patient.setPhone(phoneTextField.getText());
        patient.setEmail(emailTextField.getText());
        patient.setSsn(ssnTextField.getText());
        patient.setSymptom(illnessTextField.getText());
        // add the "/" to separate the date input
        patient.setHospitalizationDate(monthTextField.getText()
                                         + "/" + dateTextField.getText()
                                         +  "/" + yearTextField.getText());
        patient.setTreatment(treatmentTextField.getText());
        // add the "/" to separate the date input
        patient.setRecoveryDate(monthTextField1.getText() + "/"
                                  + dateTextField1.getText()
                                  + "/"  + yearTextField1.getText());
        patient.setAfterTreatment(afTextField.getText());
        patient.setAttendingPhysician(apTextField.getText());
        
        // judge which operation, insert or update
        // insert: id is NULL,update: id is NOT NULL
        if (id == null) {
          new PatientService().insert(patient);
        } else {
          patient.setId(id);
          new PatientService().update(patient);
        }
        
        JOptionPane.showMessageDialog(null, "SUCCESS");
      }
    });
    
    // reset the form
    reset.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        resetValueActionPerformed(0);
      }
      
      private void resetValueActionPerformed(int i) {
        new PatientInfoForm(0);
      }
    });
    
    // for the update operation
    if (id != null) {
      Patient patient = new PatientService().search(id);
      nameTextField.setText(patient.getName());
      patient.setName(nameTextField.getText());
      ageTextField.setText(patient.getAge() + "");
      genderTextField.setText(patient.getGender());
      addressTextField.setText(patient.getAddress());
      phoneTextField.setText(patient.getPhone());
      emailTextField.setText(patient.getEmail());
      ssnTextField.setText(patient.getSsn());
      
      String[] token = patient.getHospitalizationDate().split("/");
      yearTextField.setText(token[2]);
      monthTextField.setText(token[1]);
      dateTextField.setText(token[0]);
      treatmentTextField.setText(patient.getTreatment());
      
      token = patient.getRecoveryDate().split("/");
      yearTextField1.setText(token[0]);
      monthTextField1.setText(token[1]);
      dateTextField1.setText(token[2]);
      illnessTextField.setText(patient.getSymptom());
      afTextField.setText(patient.getAfterTreatment());
      apTextField.setText(patient.getAttendingPhysician());
    }
    
    // close window button
    this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
  }
}

