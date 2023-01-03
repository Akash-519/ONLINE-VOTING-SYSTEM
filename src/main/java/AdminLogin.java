
import java.util.*;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

/**
 * Servlet implementation class AdminLogin
 */
public class AdminLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		DbManager db=new DbManager();
		java.sql.Connection con=db.getConnection();
		
		String name=request.getParameter("adminName");
		String pass=request.getParameter("adminPassword");
		
		try {
			PreparedStatement st=con.prepareStatement("select * from admin where aName='"+name+"' and aPassword='"+pass+"'");
			ResultSet rs=((java.sql.Statement)st).executeQuery("select * from admin where aName='"+name+"' and aPassword='"+pass+"'");
			if(rs.next()) {
				HttpSession session = request.getSession();
				session.setAttribute("aName",name);
				response.sendRedirect("adminWelcome.jsp");
			}
			else
			{
				response.sendRedirect("invalid.jsp");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}

}
