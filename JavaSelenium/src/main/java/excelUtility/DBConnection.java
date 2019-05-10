package excelUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

public class DBConnection {
	
	public Map<String, String> getDataFromDB(String query) 
	{
		Map<String, String> record = new HashMap<String, String>();
		try {
		
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		
			Connection con = DriverManager.getConnection(
								"jdbc:sqlserver://ggku2ser6;databaseName=eTAF_Test;integratedSecurity=true");
			        
		  Statement stmt = con.createStatement();
		// stmt.executeUpdate("create table Akhila_Admin(aname varchar(30) unique not null,apassword varchar(40))");
	      //stmt.executeUpdate("insert into Akhila_Admin values('Durga','d123')");
	        
			
		  String q = "select * from Akhila_Admin";
			
			ResultSet rs=stmt.executeQuery(query);
			while(rs.next())
			{
				ResultSetMetaData rsmd = rs.getMetaData();
			int column = rsmd.getColumnCount();
			for (int i = 1; i <= column; i++) {
				record.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
			}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}

		return null;
	}
}
