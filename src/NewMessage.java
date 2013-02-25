

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
/**
 * Servlet implementation class NewMessage
 */
@WebServlet("/NewMessage")
public class NewMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public NewMessage() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MSG = request.getParameter("newMessage");
		String NAME ="Nathan";
		Calendar cal = Calendar.getInstance();
	    String dbUSR = "NathanRobertson";
	    String dbPWD = "ac31004";
		String dbUrl = "jdbc:mysql://arlia.computing.dundee.ac.uk/nathanrobertson";
		
		
	
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,dbUSR,dbPWD);
			PreparedStatement stmt = con.prepareStatement("INSERT INTO messages(message,name,time) VALUES (?, ?, ?)");

			stmt.setString(1, MSG);
			stmt.setString(2, NAME);
			stmt.setDate(3,new java.sql.Date(cal.getTimeInMillis()));
			stmt.executeUpdate();
			
			
			

			con.close();
			
			RequestDispatcher rd = request.getRequestDispatcher("/home.jsp");
			rd.forward(request, response);
			} //end try

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

}
