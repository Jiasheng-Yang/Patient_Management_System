

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description Manage the database, including insert, delete, update, query
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class PatientService {
  
  /**
   * @description insert patient information
   * @param Object patient
   */
  public void insert(Patient patient) {
    String sqlInsert = String.format("INSERT INTO `Patients`(`Patient_Name`,`Age`,"
                                       + "`Gender`,`Address`,`Phone`,`Email`,`SSN`,"
                                       + "`Hospitalization_Date`,`Symptom`,`Treatment`,"
                                       + "`Recovery_Date`,`After_Treatment`,`Attending_Physician`)"
                                       + "values ('%s',%d,'%s','%s','%s','%s','%s','%s',"
                                       + "'%s','%s','%s','%s','%s')",
                                     patient.getName(), patient.getAge(),
                                     patient.getGender(), patient.getAddress(),
                                     patient.getPhone(), patient.getEmail(),
                                     patient.getSsn(), patient.getHospitalizationDate(),
                                     patient.getSymptom(), patient.getTreatment(),
                                     patient.getRecoveryDate(), patient.getAfterTreatment(),
                                     patient.getAttendingPhysician());
    
    System.out.println(sqlInsert);
    try {
      Database.getConnection().createStatement().executeUpdate(sqlInsert);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  
  /**
   * @description delete patient information
   * @param Integer id
   */
  public void delete(Integer id) {
    String sqlDelete = "delete from Patients where Patient_ID = " + id;
    try {
      Database.getConnection().createStatement().executeUpdate(sqlDelete);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  
  /**
   * @description update patient information according to the patient id
   * @param Object patient
   */
  public void update(Patient patient) {
    String sqlUpdate = String.format("update Patients SET `Patient_Name` "
                                       + "= '%s',`Age` = %d,`Gender` = '%s',"
                                       + "`Address` = '%s',`Phone` = '%s',"
                                       + "`Email` = '%s',`SSN` = '%s'"
                                       + ",`Hospitalization_Date` = '%s',"
                                       + "`Symptom` = '%s',`Treatment` = '%s',"
                                       + "`Recovery_Date` = '%s',`After_Treatment` = '%s',"
                                       + "`Attending_Physician` = '%s' WHERE `Patient_ID` = %d",
                                     patient.getName(), patient.getAge(), patient.getGender(),
                                     patient.getAddress(), patient.getPhone(), patient.getEmail(),
                                     patient.getSsn(), patient.getHospitalizationDate(),
                                     patient.getSymptom(), patient.getTreatment(),
                                     patient.getRecoveryDate(), patient.getAfterTreatment(),
                                     patient.getAttendingPhysician(), patient.getId()
                                    );
    
    System.out.println(sqlUpdate);
    try {
      Database.getConnection().createStatement().executeUpdate(sqlUpdate);
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  
  /**
   * @description search patient information according to the patient id
   * @param String name
   * @return List patient
   */
  public List<Patient> search(String name) {
    String sqlSearchName =
        String.format("select * from Patients where Patient_Name like '%%%s%%'", name);
    List<Patient> patients = new ArrayList<Patient>();
    
    // get the result form the search result
    try {
      ResultSet resultName =
          Database.getConnection().prepareStatement(sqlSearchName).executeQuery();
      while (resultName.next()) {
        Patient patientName = new Patient();
        patientName.setId(resultName.getInt("Patient_ID"));
        patientName.setName(resultName.getString("Patient_Name"));
        patientName.setAge(resultName.getInt("Age"));
        patientName.setGender(resultName.getString("Gender"));
        patientName.setAddress(resultName.getString("Address"));
        patientName.setPhone(resultName.getString("Phone"));
        patientName.setEmail(resultName.getString("Email"));
        patientName.setSsn(resultName.getString("SSN"));
        patientName.setHospitalizationDate(resultName.getString("Hospitalization_Date"));
        patientName.setSymptom(resultName.getString("Symptom"));
        patientName.setTreatment(resultName.getString("Treatment"));
        patientName.setRecoveryDate(resultName.getString("Recovery_Date"));
        patientName.setAfterTreatment(resultName.getString("After_Treatment"));
        patientName.setAttendingPhysician(resultName.getString("Attending_Physician"));
        patients.add(patientName);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    
    return patients;
  }
  
  
  /**
   * @description search patient information according to the patient id
   * @param Integer id
   * @return Object patient
   */
  public Patient search(Integer id) {
    String sqlSearchId = String.format("select * from Patients where Patient_ID = %d", id);
    
    Patient patient = new Patient();
    
    // get the result form the search result
    try {
      ResultSet resultId = Database.getConnection().prepareStatement(sqlSearchId).executeQuery();
      if (resultId.next()) {
        
        patient.setId(resultId.getInt("Patient_ID"));
        patient.setName(resultId.getString("Patient_Name"));
        patient.setAge(resultId.getInt("Age"));
        patient.setGender(resultId.getString("Gender"));
        patient.setAddress(resultId.getString("Address"));
        patient.setPhone(resultId.getString("Phone"));
        patient.setEmail(resultId.getString("Email"));
        patient.setSsn(resultId.getString("SSN"));
        patient.setHospitalizationDate(resultId.getString("Hospitalization_Date"));
        patient.setSymptom(resultId.getString("Symptom"));
        patient.setTreatment(resultId.getString("Treatment"));
        patient.setRecoveryDate(resultId.getString("Recovery_Date"));
        patient.setAfterTreatment(resultId.getString("After_Treatment"));
        patient.setAttendingPhysician(resultId.getString("Attending_Physician"));
        
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return patient;
    
  }
}

