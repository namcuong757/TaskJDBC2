package CoreJava16;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
public class InsertTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Config config = new Config();
		Connection con = config.config();
		PreparedStatement preparedStatement = null;
		Scanner scanner = new Scanner(System.in);
		try
		{
			System.out.print("How many records do you want to insert: ");
			int records = scanner.nextInt();
			scanner.nextLine(); 
			
			for(int i = 0; i < records; i++)
			{
				String insertQuery = "INSERT INTO Product (Pid, Pname, Qty, Price) VALUES (?, ?, ?, ?)";
	            // Create a prepared statement
	            preparedStatement = con.prepareStatement(insertQuery);

	            
	            System.out.print("Enter Product id: ");
	            int pid = scanner.nextInt();
	            scanner.nextLine();
	            System.out.print("Enter Product name: ");
	            String pname = scanner.nextLine();
	            System.out.print("Enter Product qty: ");
	            int qty = scanner.nextInt();
	            scanner.nextLine();
	            
	            System.out.print("Enter Product Price: ");
	            float price= scanner.nextFloat();
	            scanner.nextLine();

	            // Set the values of the Java variables for each placeholder
	            preparedStatement.setInt(1, pid);
	            preparedStatement.setString(2, pname);
	            preparedStatement.setInt(3, qty);
	            preparedStatement.setFloat(4, price);

	            // Execute the prepared statement
	            int rowsAffected = preparedStatement.executeUpdate();
				if(rowsAffected > 0)
				{
					System.out.println("Successfully Insert data in");
				}
				else
				{
					System.out.println("Failed to insert");
				}
			}
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		finally
		{
			try {
                if (preparedStatement != null) {
                    preparedStatement.close();
                }
                if (con != null) {
                    con.close();
                }
            } catch (Exception e) {
                System.out.println("Failed to close connection");
            }
		}
	}

}
