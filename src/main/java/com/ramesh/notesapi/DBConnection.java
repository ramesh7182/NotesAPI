package com.ramesh.notesapi;
import java.sql.*;
import java.util.HashMap; 
public class DBConnection {
	Connection con;
	public boolean openDBConnection(){ 
		
		try{  
				Class.forName("com.mysql.jdbc.Driver");  
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/myapp","root","root");   
			}catch(Exception e)
			{ 
				System.out.println("Error while establishing a connection to DB. "+e);
				return false;
			}
			return true;
		}
	
	public boolean closeDBConnection(){  
		try{  
			if(!con.isClosed())	
				con.close();  
			}catch(Exception e)
			{ 
				System.out.println("Error while closing the DB Connection."+e);
				return false;
			}
			return true;
		}
	
	public boolean insertDataInDB(String insertQuery, String tableName)
	{
		PreparedStatement ps = null;
		int updatedRowCount =0;
		try {
			ps = con.prepareStatement(insertQuery);
			updatedRowCount =ps.executeUpdate();
					
		} catch (Exception e) {
				System.out.println("Error while inserting the data.");
				e.printStackTrace();
			}  	
		if (updatedRowCount >0)
			return true;
		else
			return false;
	}
	
	public boolean updateDataInDB(String insertQuery, String tableName)
	{
		PreparedStatement ps = null;
		int updatedRowCount =0;
		try {
			ps = con.prepareStatement(insertQuery);
			updatedRowCount =ps.executeUpdate();
					
		} catch (Exception e) {
				System.out.println("Error while updating the data.");
				e.printStackTrace();
			}  	
		if (updatedRowCount >0)
			return true;
		else
			return false;
	}
	
	public ResultSet getDataFromDB(String query)
	{
		Statement stmt;
		ResultSet rs;
		try {
			stmt = con.createStatement();
			rs=stmt.executeQuery(query);
			} catch (Exception e) {
				System.out.println("Error while inserting the data.");
				e.printStackTrace();
				return null;
			}  	
		return rs;
	}
	
	}
