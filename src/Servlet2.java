

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;

/**
 * Servlet implementation class Servlet2
 */
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList DisplayMessages = new ArrayList();

    /**
     * @see HttpServlet#HttpServlet()
     */
    public Servlet2() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name;
		String email;
		String password;
		String dbUSR = "NathanRobertson";
		String dbPWD = "ac31004";
		String dbUrl = "jdbc:mysql://arlia.computing.dundee.ac.uk/nathanrobertson";
		String dbClass = "com.mysql.jdbc.Driver";
		String query1 = "Select * FROM User";
		
		
		String EMAIL = request.getParameter("Email");
		String PWD = request.getParameter("Password");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,dbUSR,dbPWD);
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(query1);

			while (rs.next()) {
			name = rs.getString(1);
			email = rs.getString(2);
			password = rs.getString(3);
			if(email.equals(EMAIL) & password.equals(PWD))
			{
				//response.setContentType("text/html");
				//PrintWriter out=response.getWriter();
				HttpSession session = request.getSession(false);
				String Sname = name;
				String Semail = EMAIL;
				session.setAttribute("Sname", name);
				session.setAttribute("Semail",EMAIL);
				String query2 ="Select * FROM Following WHERE followerName ='" + name + "'";
				String query3 = "Select * From messages WHERE name ='" + name +"'";
				rs = stmt.executeQuery(query2);
				while (rs.next()) {
					
				
				query3 =query3.concat("OR name='"+ rs.getString(1)+ "'");	
				
				} 
				System.out.print(query3);
				rs = stmt.executeQuery(query3);
				while(rs.next())
				{
					DisplayMessages.add(rs.getString(1));
					DisplayMessages.add(rs.getString(2));
					DisplayMessages.add(rs.getString(3));
				}
			//response.sendRedirect("home.jsp");
				request.setAttribute("messageList", DisplayMessages);
				RequestDispatcher dispatcher = request.getRequestDispatcher("home.jsp");

				  if (dispatcher != null){

				  dispatcher.forward(request, response);
				  return;
			}
			}
			//if(email !=EMAIL || password != PWD)
			//{
			//	RequestDispatcher dispatcher = request.getRequestDispatcher("logIn.jsp");

			//	  if (dispatcher != null){

			//	  dispatcher.forward(request, response);
			//}
			//}
			
			} //end while

			con.close();
			response.sendRedirect("logIn.jsp");

			} //end try

		
			catch(ClassNotFoundException e) {
			e.printStackTrace();
			}

			catch(SQLException e) {
			e.printStackTrace();
			}
	}	
	

}
