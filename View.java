import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

public class View {
	public static void main(String[] args) {
		Connection cn = null;
		try{
			final String driver = "oracle.jdbc.driver.OracleDriver";
			Class.forName(driver);
		    String mysqlUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		    cn = DriverManager.getConnection(mysqlUrl, "THE_FLASH", "hellooracle");
			Statement smt=cn.createStatement();
			
			//query to display all records from table REGISTRATION
			Scanner sc= new Scanner(System.in);
			System.out.println("Enter the view statement you want to execute");
			String q=sc.nextLine();
			//Select * from registration ORDER BY date_time DESC
			//to execute query
			ResultSet rs=smt.executeQuery(q);
			
			//to print the ResultSet on console
			while(rs.next()){ 
				{
				System.out.println(" "+rs.getString(1)+" |"+rs.getString(2)+" |"
						+rs.getString(3)+" |"+rs.getString(4)+" |"+rs.getString(5)+" |"
						+rs.getString(6)+" |"+rs.getString(7)+" |"+rs.getString(8)+" |"
						+rs.getString(9)+" |");
				
				}
		
			sc.close();
		                    }
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

