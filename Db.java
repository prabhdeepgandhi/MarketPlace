package package1 ;

import java.sql.*;

public class Db 
{
	static Connection con;
	public static Connection getCon()
	{
		try
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "");
		}
		catch(Exception e)
		{
			
		}
		return con;
	}
}

