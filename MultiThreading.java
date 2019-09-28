import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.locks.ReentrantLock;

public class MultiThreading {
   public static void main(String args[])throws Exception {
   Connection con = null;
   ReentrantLock lock = new ReentrantLock();
   lock.lock(); //putting the lock
   try {
	  final String driver = "oracle.jdbc.driver.OracleDriver";
	  Class.forName(driver); //Loading the oracle driver
      String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
      con = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
      //Making the connection
      System.out.println("Connection established.!");
      //Inserting values to a table
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter Full Name: ");
      String FullName = sc.nextLine();
      System.out.println("Enter a unique username: ");
      String User_Name = sc.nextLine();
      System.out.println("Enter Mobile: ");
      String mobile = sc.nextLine();
      System.out.println("Enter Email: ");
      String email = sc.nextLine();
      System.out.println("Enter Password: ");
      String password = sc.nextLine();
      System.out.println("Enter DOB: ");
      String DOB = sc.nextLine();
      System.out.println("Enter Gender: ");
      String gender = sc.nextLine();
      System.out.println("Enter City: ");
      String city = sc.nextLine();

      String query = "INSERT INTO REGISTRATION(FullName, User_Name, mobile, email, password, DOB, gender, city, date_time)VALUES (?,?,?,?,?,?,?,?, CURRENT_TIMESTAMP)";
      //Query to insert into the table
      PreparedStatement pstmt = con.prepareStatement(query);
      pstmt.setString(1, FullName);
      pstmt.setString(2, User_Name);
      pstmt.setString(3, mobile);
      pstmt.setString(4, email);
      pstmt.setString(5, password);
      pstmt.setString(6, DOB);
      pstmt.setString(7, gender);
      pstmt.setString(8, city);
      
      pstmt.execute();//Executing the statement
      System.out.println();
      System.out.println("Registration done successfully.!");
      sc.close();
   }
   catch(ClassNotFoundException e){
	    System.out.println("Driver class not found!! Exception Occured");
  }
  catch(SQLException sqle){
	    sqle.printStackTrace();
  }

   finally {
	        lock.unlock(); //unlocking the lock
        	try{
		          con.close();
	           }
	catch(SQLException sqle){
		System.out.println("Exception occured while closing the connection");
	    }
	    }
   }
}