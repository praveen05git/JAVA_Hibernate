package hibernate_simple_example;

import java.sql.Connection;
import java.sql.DriverManager;

public class testing_jdbc_conn {

	public static void main(String[] args) {
		
		String jdbc_url="jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user="hbstudent";
		String pass="Hbstudent@123";
		
		try
		{
			System.out.println("Connecting.."+jdbc_url);
			
			Connection conn=DriverManager.getConnection(jdbc_url,user,pass);
			
			
			System.out.println("Success");
		}
		catch(Exception e)
		{
			
		}

	}

}
