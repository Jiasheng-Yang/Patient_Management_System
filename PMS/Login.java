
/**
 * @Description Judge the valid username and password
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class Login {
  
  
  /**
   * @description Judge whether the username is valid or not
   * @description valid username: contains @
   * @param String username
   * @return boolean
   */
  public static boolean usernameIsValid(String username) {
    return username.contains("@");
  }
  
  
  /**
   * @description Utilize the regular expression to judge whether the password is valid or not
   * @description valid password: 8-20 characters,
   * @description                 at least one capital and lowercase letter, and one digit
   * @param String password
   * @return boolean
   */
  public static boolean passwordIsValid(String password) {
    
    // String array for regular expression
    String[] requirements = new String[3];
    requirements[0] = ".*[A-Z].*"; // at least one capital letter
    requirements[1] = ".*[a-z].*"; // at least one lowercase letter
    requirements[2] = ".*\\d.*"; // at least one digit
    
    // judge whether the length is valid
    boolean flagPassword = password.length() >= 8 && password.length() <= 20;
    
    // judge whether the password matches or not
    for (int i = 0; i < 3; i++) {
      if (!password.matches(requirements[i])) {
        flagPassword = false;
        break;
      }
    }
    
    return flagPassword;
  }
}
