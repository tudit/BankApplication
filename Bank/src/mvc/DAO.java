package mvc;

import java.sql.*;
import java.io.*;


public class DAO {

	private String driverName;
	private String URL;
	private String userName;
	private String pwd;
	private Connection conn;
	
	public void connect() throws ClassNotFoundException, SQLException, IOException
	{
		
		FileReader reader=new FileReader("C:\\Users\\LAHPI01\\Documents\\ConnectionDetails.txt");
		BufferedReader bfr=new BufferedReader(reader);
		
		
			driverName=bfr.readLine();
			URL=bfr.readLine();
			userName=bfr.readLine();
			pwd=bfr.readLine();
						
		Class.forName(driverName);//"com.mysql.jdbc.Driver"
		conn= DriverManager.getConnection(URL,userName,pwd);//"jdbc:mysql://localhost/trng","root","tidu@114"
		
		bfr.close();
	}

	public void finalize()
	{
		try 
		{
			conn.close();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}
	
	public String getDriverName() 
	{
		return driverName;
	}

	public void setDriverName(String driverName) 
	{
		this.driverName = driverName;
	}

	public String getURL() 
	{
		return URL;
	}

	public void setURL(String uRL) 
	{
		URL = uRL;
	}

	public String getUserName() 
	{
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public void closeConnection() throws SQLException{
		if(conn!=null)
		conn.close();
	}
	

	public boolean deleteEmp(int id) throws SQLException{
		PreparedStatement pst=conn.prepareStatement("delete from Employee where empId=?");
		pst.setInt(1,id);
		
		return pst.execute();
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}
	
}


