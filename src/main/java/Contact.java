

import java.util.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Contact
 */
public class Contact extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Contact() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		DbManager db=new DbManager();
		java.sql.Connection con=db.getConnection();
		
		String name=request.getParameter("uName");
		String number=request.getParameter("pNumber");
		String email = request.getParameter("email");
		String comment = request.getParameter("comment");
		//Long num=Long.
		try {
			
			PreparedStatement st = con.prepareStatement("insert into contact(uName,pNumber,email,cmnt)values('"+name+"','"+Long.valueOf(number)+"','"+email+"','"+comment+"')");
			
			response.sendRedirect("index.jsp");
			st.executeUpdate();
		}catch(Exception e)
		{
			e.printStackTrace();
			
		}
		//response.sendRedirect("index.jsp");
		//doGet(request, response);
	}

}
