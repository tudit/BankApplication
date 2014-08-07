package mvc;

import java.io.IOException;
import java.sql.SQLException;
import java.io.*;
import java.sql.*;
import java.util.Random;
//import java.io.PrintWriter;
//import java.sql.*;

import javax.servlet.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmpServlet
 */
public class RegisterationServlet extends HttpServlet {
	private Connection conn;
	private DAO dao;
	private static final long serialVersionUID = 1L;
   // private ServletContext cntx;   
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterationServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 service method
	 */
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
	String ac_name=req.getParameter("name");
	String houseno=req.getParameter("houseNo");
	String street=req.getParameter("street");
	String city=req.getParameter("city");
	String state=req.getParameter("state");
	String country=req.getParameter("country");
	String dob=req.getParameter("dob");
	String email=req.getParameter("email");
	String phno=req.getParameter("phoneNo");
	
	PreparedStatement pst=null;
		try {
		pst = conn.prepareStatement("insert into Account (ac_name,houseno,street,city,state,country,dob,email,phno) values(?,?,?,?,?,?,?,?,?);");
		pst.setString(1,ac_name);
		pst.setString(2,houseno);
		pst.setString(3,street);
		pst.setString(4,city);
		pst.setString(5,state);
		pst.setString(6,country);
		pst.setDate(7,Date.valueOf(dob));
		pst.setString(8,email);
		pst.setString(9,phno);
		int rows=pst.executeUpdate();
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery("select max(ac_no) from account");
		int ac_no=0;
		if(rs.next())
			ac_no = rs.getInt(1);
		pst = conn.prepareStatement("insert into login values(?,?)");		
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
        StringBuilder sb = new StringBuilder( 10 );
		   for( int i = 0; i < 10; i++ ) 
		      sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		pst.setInt(1,ac_no);
		pst.setString(2, sb.toString());
		pst.executeUpdate();
		req.setAttribute("rowsInserted", rows);
		req.setAttribute("accountID",ac_no);
		req.setAttribute("password",sb.toString());
		conn.close();
	
		/*PrintWriter pw=res.getWriter();
		pw.println("Rows Inserted Sucessfully: "+rows);
		wait(2000);
		RequestDispatcher rd = req.getRequestDispatcher("Home.html");
		rd.forward(req,res);*/
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
		req.setAttribute("rowsInserted", -1);
		
	} 
	finally
	{
		RequestDispatcher rd = req.getRequestDispatcher("RegistrationMessage.jsp");
		rd.forward(req,res);
	}
}
	
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
