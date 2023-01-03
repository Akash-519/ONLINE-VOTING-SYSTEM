

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
 * Servlet implementation class Vote
 */
public class Vote extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	response.setContentType("text/html");
	PrintWriter out=response.getWriter();
	DbManager db=new DbManager();
	java.sql.Connection con=db.getConnection();
	
	String Vnumber=request.getParameter("voterNumber");
	String party=request.getParameter("partie");
	
	try
	{
		PreparedStatement st=con.prepareStatement("select * from voters where vNumber ='"+Vnumber+"'");
		ResultSet rs=((java.sql.Statement)st).executeQuery("select * from voters where vNumber ='"+Vnumber+"'");
		if(rs.next())
		{
			PreparedStatement st1=con.prepareStatement("insert into temp_vc_number(vNumber)values('"+Vnumber+"')");
			PreparedStatement st2=con.prepareStatement("insert into vote(vNumber,partie)values('"+Vnumber+"','"+party+"')");
			st1.executeUpdate();
			st2.executeUpdate();
			response.sendRedirect("index.jsp");
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
