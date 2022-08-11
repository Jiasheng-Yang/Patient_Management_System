
/**
 * @Description Store patient information as private variables and create patient information
 * @Author ZENG YANG, JIASHENG YANG
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class Patient {
  private Integer id;
  private String name;
  private int age;
  private String gender;
  private String address;
  private String phone;
  private String email;
  private String ssn;
  private String hospitalizationDate;
  private String symptom;
  private String treatment;
  private String recoveryDate;
  private String afterTreatment;
  private String attendingPhysician;
  
  public Integer getId() {
    return id;
  }
  
  public void setId(Integer id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public int getAge() {
    return age;
  }
  
  public void setAge(int age) {
    this.age = age;
  }
  
  public String getGender() {
    return gender;
  }
  
  public void setGender(String gender) {
    this.gender = gender;
  }
  
  public String getAddress() {
    return address;
  }
  
  public void setAddress(String address) {
    this.address = address;
  }
  
  public String getPhone() {
    return phone;
  }
  
  public void setPhone(String phone) {
    this.phone = phone;
  }
  
  public String getEmail() {
    return email;
  }
  
  public void setEmail(String email) {
    this.email = email;
  }
  
  public String getSsn() {
    return ssn;
  }
  
  public void setSsn(String ssn0) {
    ssn = ssn0;
  }
  
  public String getHospitalizationDate() {
    return hospitalizationDate;
  }
  
  public void setHospitalizationDate(String hospitalizationDate) {
    this.hospitalizationDate = hospitalizationDate;
  }
  
  public String getSymptom() {
    return symptom;
  }
  
  public void setSymptom(String symptom) {
    this.symptom = symptom;
  }
  
  public String getTreatment() {
    return treatment;
  }
  
  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }
  
  public String getRecoveryDate() {
    return recoveryDate;
  }
  
  public void setRecoveryDate(String recoveryDate) {
    this.recoveryDate = recoveryDate;
  }
  
  public String getAfterTreatment() {
    return afterTreatment;
  }
  
  public void setAfterTreatment(String afterTreatment) {
    this.afterTreatment = afterTreatment;
  }
  
  public String getAttendingPhysician() {
    return attendingPhysician;
  }
  
  public void setAttendingPhysician(String attendingPhysician) {
    this.attendingPhysician = attendingPhysician;
  }
}

