package CoreJava16;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CreateTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection con = null;
		Statement statement = null;
		ResultSet resultSet = null;
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/testDB?useSSL=false";
			con = DriverManager.getConnection(url, "root", "password123");
			if(con == null)
			{
				System.out.println("Connection Failed");
			}
			else
			{
				System.out.println("Database MySQL connected");
			}
			statement = con.createStatement();
			//String query = "Select * from student;";
			String create_table_query = "CREATE TABLE IF NOT EXISTS Product(Pid int, Pname varchar(50), Qty int, Price float)";
			
			//resultSet = statement.executeQuery(query);
			boolean exe = statement.execute(create_table_query);
			if(!exe)
			{
				System.out.println("Succesfully create table");
			}
			else
			{
				System.out.println("Failed to create table");
			}
//			while (resultSet.next()) 
//			{
//				String name = resultSet.getString("Sname");
//				int sno = resultSet.getInt("SNO");
//				String course = resultSet.getString("Course");
//				// Perform desired operations with the retrieved data
//				System.out.println("==========================");
//				System.out.println("Name: " + name);
//				System.out.println("SNO: " + sno);
//				System.out.println("Course: " + course);
//				
//			}
			
		}catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				//resultSet.close();
				statement.close();
				con.close();
			}catch(Exception e)
			{
				System.out.println("Failed to close connection");
			}
		}
	}

}
