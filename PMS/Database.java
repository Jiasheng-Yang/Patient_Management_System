
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * @Description Create the connection with the database
 * @Author Group 2, Yike Pan, Zeng Yang, Jiasheng Yang, Wenzhang Ge
 * @ProjectName Patient Management System
 * @Year 2022
 */
public class Database {
  /**
   * @description define JDBC information and get the connection with database
   */
  private static Connection conn;
  
  static {
    String driver = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://localhost:3306/patients";
    String user = "root";
    String password = "111";
    try {
      Class.forName(driver);
      conn = DriverManager.getConnection(url, user, password);
    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
  
  
  /**
   * @description get JDBC information
   * @return Connection conn
   */
  public static Connection getConnection() {
    return conn;
  }
}
