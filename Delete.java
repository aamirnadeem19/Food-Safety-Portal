import java.sql.*;
import java.util.*;

public class Delete {
	public static void main(String[] args) {
		Connection cn = null;
		try{
			   final String driver = "oracle.jdbc.driver.OracleDriver";
			   Class.forName(driver);
		       String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		       cn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
			   Statement smt=cn.createStatement();
			   //query to update records from table REGISTRATION
			   //delete from REGISTRATION where U_ID = 102
			   Scanner sc = new Scanner(System.in);
			   System.out.println("Write the delete statement you wish to execute");
			   //delete from REGISTRATION where U_ID = 102
			   String q=sc.nextLine();
			   smt.executeUpdate(q);
               System.out.println("Record Deleted as per request");
			   sc.close();
		   }
		catch(ClassNotFoundException e){
			   System.out.println("Driver class not found!! Exception Occured");
		}
		catch(SQLException sqle){
			   sqle.printStackTrace();
		}
		
		finally {
			    try{
				      cn.close();
			       }
			    catch(SQLException sqle){
				      System.out.println("Exception occured while closing the connection");
			}
			}
	}

}

