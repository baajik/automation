package gov.ebooks.selenium.shared.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.jar.*;
import java.sql.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class JDBCconnection 
{
		private static Connection conn = null; // Object of Connection from the Database
		private static Statement stmt = null; // Object of Statement. It is used to create a Statement to execute the query
		private static ResultSet resultSet = null; //Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		public static String username = null;

	 public static void DataBaseUsernameQuery(String email) throws Exception 
	 {
			 System.out.println("++++++++  " + "Connecting to Database  ++++++++" + "\n===========================================");
			
			 Class.forName("oracle.jdbc.driver.OracleDriver");  // Class.forName("com.mysql.jdbc.Driver");
			 conn = DriverManager.getConnection("jdbc:oracle:thin:@10.98.37.42:1521:ebooksqadb","review_qa","review_qa"); // Open a connection
			 Statement stmt = null; // Object of Statement. Statement to execute the query
			 ResultSet resultSet = null; //Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'

			 // Execute a query
			 stmt = conn.createStatement();
			 resultSet = stmt.executeQuery("Select * from SYSTEM_USER where EMAIL = '" + email + "'"); //Find the Username from email
			 if(resultSet.next())
			 {
			 	username = resultSet.getString(2);
			 	System.out.println("UserName to Login = " + username);
			 } 
			 
			 
	if (resultSet != null) 
	{
		try 
		{
		resultSet.close();
		} 
		catch (Exception e) 
		{
		}
	}
	 if (stmt != null)
	 {
		 try 
		 {
		 stmt.close();
		 } 
		 catch (Exception e) 
		 {
		 }
	 }
	if (conn != null) 
	{
		 try 
		 {
		 conn.close();
		 } 
		 catch (Exception e) 
		 {
		 }
	}
}
	
/*
//Moving Stage to In-Review	
	public static void DataBaseProposalStageMoveToInReview (String InReview) throws Exception
	{
		 	System.out.println("++++++++  " + "Connecting to Database  ++++++++" + "\n===========================================");
		
			Class.forName("oracle.jdbc.driver.OracleDriver");  // Class.forName("com.mysql.jdbc.Driver");
		 	conn = DriverManager.getConnection("jdbc:oracle:thin:@10.98.37.42:1521:ebooksqadb","review_qa","review_qa"); // Open a connection
		 	Statement stmt = null; // Object of Statement. Statement to execute the query
		 	ResultSet resultSet = null; //Object of ResultSet => 'It maintains a cursor that points to the current row in the result set'
		
		 // Execute a query
		 	stmt = conn.createStatement();
		 	resultSet = stmt.executeQuery("Select * from <--> where <--> = '" + <--> + "'");
		 	if(resultSet.next())
			{
			String ProposalNumber = "";
			int UserRoleId = resultSet.getInt("--");
			stmt.executeUpdate("Update FROM <--> TO <--> = " + UserRoleId);
		}
			
		if (resultSet != null) 
		{
			try 
			{
			resultSet.close();
			} 
			catch (Exception e) 
			{
		}
	}
	 if (stmt != null)
	 {
		 try 
		 {
		 stmt.close();
		 } 
		 catch (Exception e) 
		 {
		 }
	 }
	if (conn != null) 
	{
		 try 
		 {
		 conn.close();
		 } 
		 catch (Exception e) 
		 {
		 }
			}
	}
	
	
//Deleting the User from the Role	
	public static void deleteUserRoleFromProposal (String Role) 
	{
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("SELECT ProposalNumber FROM Table WHERE Role = '" + Role"'");
			if (rs.next()) 
				{
				int PanelMemberId = rs.getInt("--");
				int PanelOfficialId = rs.getInt("--");
				int ScribId = rs.getInt("--");
				int PanelProjectionId = rs.getInt("--");
				int LeadReviewerId = rs.getInt("--");
				int QualityControlId = rs.getInt("--");
				int PanelLeaId = rs.getInt("--");
				int ProgramManagerId = rs.getInt("--");
		
				stmt.executeUpdate("DELETE FROM -- <USER_ROLE> WHERE <ST_USER_ID> = " + PanelMemberId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + PanelOfficialId );
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + ScribId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + PanelProjectionId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + LeadReviewerId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + QualityControlId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + LeadReviewerId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + PanelLeaId);
				stmt.executeUpdate("DELETE FROM <---> WHERE <---> = " + ProgramManagerId);
				}
		} 
		catch (SQLException e) 
			{
			e.printStackTrace();
			} 
		finally 
			{
			closeResultSet();
			closeStatement();
			}
	}	
	
//Remove Scoring from Proposal
 
 
	
	
 */
		 

}