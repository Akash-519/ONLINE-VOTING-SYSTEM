

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class VoterLogin
 */
public class VoterLogin extends HttpServlet {
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
		
		String Vnumber=request.getParameter("voterNumber");
		
		try
		{
			PreparedStatement st1=con.prepareStatement("select vNumber from temp_vc_number where vNumber='"+Vnumber+"'");
			ResultSet rs1=st1.executeQuery("select vNumber from temp_vc_number where vNumber='"+Vnumber+"'");
			if(rs1.next()) {
				response.sendRedirect("voted.jsp");
			}
			else
			{
				PreparedStatement st2=con.prepareStatement("select vNumber from voters where vNumber='"+Vnumber+"'");
				ResultSet rs2=st2.executeQuery("select vNumber from voters where vNumber='"+Vnumber+"'");
				if(rs2.next()) {
					response.sendRedirect("voterWelcome.jsp");
				}
				else
				{
				response.sendRedirect("invalid.jsp");
				}
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

		
	}

}
