package pl.imsi;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

public class Connect {
	
	public static Connection CreateConnection()
	{
		String server = "localhost\\sqlexpress";
        int port = 53528;
        String user = "172075"; // Sql server username
        String password = "172075";
        String database = "MyBase";
        
        try{
        	String jdbcUrl = "jdbc:sqlserver://"+server+":"+port+";user="+user+";password="+password+";databaseName="+database+"";
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            Connection con = DriverManager.getConnection(jdbcUrl);
            
            return con;
        }
        catch(Exception e){
        	return null;
        }
	}
	
	public static void test(){
		
		Connection con = CreateConnection();
		
		Statement stmt;
		try {
			stmt = con.createStatement();
			System.out.println("# - Statement Created");
		       
	        ResultSet rs = stmt.executeQuery("SELECT test FROM test;");
	        System.out.println("# - Query Executed");
	       
	        if(rs.next()) {
	                System.out.println("Product Count : "+rs.getString(1));
	        }
	       
	        rs.close();
	        stmt.close();
	        con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
	}
	
	public static void InsertUser(String login, String password, String name, String email)
	{
		String SPsql = "EXEC insertuser ?,?,?,?";
		Connection con = CreateConnection();   // java.sql.Connection
		try {
			PreparedStatement ps = con.prepareStatement(SPsql);
			ps.setEscapeProcessing(true);
			ps.setQueryTimeout(1000);
			ps.setString(1, name);
			ps.setString(2, login);
			ps.setString(3, email);
			ps.setString(4, password);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
        InsertUser("test11", "test11", "test11", "test11");
                
}

	public boolean UserCheck(String login, String pass) {
		String SPsql = "{ call checkIfUser(?, ?) }";
		Connection con = CreateConnection();   // java.sql.Connection
		try {
			int ret = 0;
			con.setAutoCommit(false);
			CallableStatement proc = con.prepareCall(SPsql);
			proc.setString(1, login);
			proc.setString(2, pass);
			ResultSet rs = proc.executeQuery();
			while (rs.next())
			{
			    ret = rs.getInt(1);
			}
			proc.close();
			
			return ret == 1 ? true : false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	
	public void FailedLogIn(String login, String desc) {
		Connection con = CreateConnection();
		
		CallableStatement proc;
		try {
			proc = con.prepareCall("{ call failedLogIn(?, ?, ?) }");
			proc.setString(1, login);
			try {
				proc.setString(2, InetAddress.getLocalHost().toString());
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			proc.setString(3, desc);
			proc.execute();
			proc.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	
	public void PassChange(String login, String pass)
	{
		Connection con = CreateConnection();
		
		CallableStatement proc;
		try {
			proc = con.prepareCall("{ call passChange(?, ?) }");
			proc.setString(1, login);
			proc.setString(2, pass);
			proc.execute();
			proc.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	
	}

	public String GetCurrentUserId(String login) {
		
		String SPsql = "{ call getUserId(?) }";
		Connection con = CreateConnection();   // java.sql.Connection
		try {
			int ret = 0;
			con.setAutoCommit(false);
			CallableStatement proc = con.prepareCall(SPsql);
			proc.setString(1, login);
			ResultSet rs = proc.executeQuery();
			while (rs.next())
			{
			    ret = rs.getInt(1);
			}
			proc.close();
			
			return Integer.toString(ret);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "";
		}
	}
}
