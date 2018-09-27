package application;

import java.sql.*;

public class SqliteConnection
{
	public static Connection Connector(){
		try
		{
		Class.forName("org.sqlite.JDBC");
		Connection conn=DriverManager.getConnection("jdbc:sqlite:staticdb.sqlite");
		return conn;
		}
		catch (Exception e) {
			System.out.println(e);
			return null;
			// TODO: handle exception
		}
	}
	public static Connection connectDb()
	{
        try
        {
        	//Class.forName("com.mysql.jdbc.Driver");
        	Class.forName("org.sqlite.JDBC");
          	Connection connection=DriverManager.getConnection("jdbc:sqlite:data/"+UniversalSetting.sql_Db+".db");
          	
        	return connection;
        }
        catch(Exception exp)
        {
        	exp.printStackTrace();
        	return null;
        }
	}
}
