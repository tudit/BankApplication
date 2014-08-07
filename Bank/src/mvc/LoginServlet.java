package mvc;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet 
{
	private Connection conn;
	private DAO dao;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException 
	{
		Statement st;
		int ac_no = Integer.parseInt(req.getParameter("acNo"));
		String passwd = req.getParameter("password");
		
		try {
		st = conn.createStatement();
		ResultSet rs = st.executeQuery("select * from login where ac_no = "+ac_no+" and passwd = '"+passwd+"'");
		if(rs.next())
		{
			PrintWriter pw=res.getWriter();
			pw.println("Login Successful");
		}
		else
		{
			PrintWriter pw=res.getWriter();
			pw.println("Login Unsuccessful");
		}
		/*RequestDispatcher rd = req.getRequestDispatcher("RegistrationMessage.jsp");
		rd.forward(req,res);*/
		st.close();
		rs.close();
		conn.close();
	} 
	catch (SQLException e) 
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	/*	req.setAttribute("rowsInserted", -1);
		RequestDispatcher rd = req.getRequestDispatcher("RegistrationMessage.jsp");
		rd.forward(req,res);*/
		
	} 
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void init(ServletConfig servConfig){
		//cntx=servConfig.getServletContext();	
		dao=new DAO();
		try {
			dao.connect();
			conn=dao.getConn();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
		}

	public DAO getDao() {
		return dao;
	}

	public void setDao(DAO dao) {
		this.dao = dao;
	}


}
