

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;


/**
 * Servlet implementation class RegisterVoter
 */
public class RegisterVoter extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		DbManager db=new DbManager();
		java.sql.Connection con=db.getConnection();
		
		String Name=request.getParameter("uName");
		String Pnumber=request.getParameter("pNumber");
		String Email = request.getParameter("email");
		String Address = request.getParameter("address");
		String Vnumber=request.getParameter("voterNumber");
		String Dob=request.getParameter("dob");
		
		try {
			PreparedStatement st = con.prepareStatement("insert into voters(uName,pNumber,email,address,vNumber,dob)values('"+Name+"','"+Pnumber+"','"+Email+"','"+Address+"','"+Vnumber+"','"+Dob+"')");
			st.executeUpdate();
			response.sendRedirect("adminWelcome.jsp");
		}
		catch(Exception e)
		{
		e.printStackTrace();
		}

		
	}

}
