

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DisplayMessages
 */
@WebServlet("/DisplayMessages")
public class DisplayMessages extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList DisplayMessages = new ArrayList();

       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayMessages() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
		String dbUSR = "NathanRobertson";
		String dbPWD = "ac31004";
		String dbUrl = "jdbc:mysql://arlia.computing.dundee.ac.uk/nathanrobertson";
		String dbClass = "com.mysql.jdbc.Driver";
		String query1 = "Select * FROM Following WHERE followerName ='Nathan'";
		String query2 = "Select * From messages WHERE name = 'Nathan'";
		
		//String MSG = request.getParameter("Email");
		//String PWD = request.getParameter("Password");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,dbUSR,dbPWD);
			Statement stmt = con.createStatement();
			
			
			ResultSet rs = stmt.executeQuery(query1);
			while (rs.next()) {
			
			
			query2 =query2.concat("OR name='"+ rs.getString(1)+ "'");	
			
			} 
			System.out.print(query2);
			
			
		
				con.close();
				getMessage(query2); 
				request.setAttribute("messageList", DisplayMessages);
				RequestDispatcher dispatcher = request.getRequestDispatcher("messages.jsp");

				  if (dispatcher != null){

				  dispatcher.forward(request, response);

				  }

				}

				catch(ClassNotFoundException e) {
				e.printStackTrace();
				}

				catch(SQLException e) {
				e.printStackTrace();
				}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void getMessage(String query2)
	{
		String dbUrl = "jdbc:mysql://localhost:3306/test";
		String dbClass = "com.mysql.jdbc.Driver";
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl);
			Statement MSGstmt = con.createStatement();
		
			ResultSet MSGrs = MSGstmt.executeQuery(query2);
			while(MSGrs.next())
			{
				DisplayMessages.add(MSGrs.getString(1));
				DisplayMessages.add(MSGrs.getString(2));
				DisplayMessages.add(MSGrs.getString(3));
			}
						con.close();

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
