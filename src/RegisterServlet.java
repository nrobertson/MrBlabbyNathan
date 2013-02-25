

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String NAME = request.getParameter("Name");
		String USR = request.getParameter("Email");
		String PWD = request.getParameter("Password");
		String dbUSR = "NathanRobertson";
		String dbPWD = "ac31004";
		String dbUrl = "jdbc:mysql://arlia.computing.dundee.ac.uk/nathanrobertson";
		
	
		
		
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,dbUSR,dbPWD);
			PreparedStatement stmt = con.prepareStatement("INSERT INTO User(Name,Email, Password) VALUES (?, ?, ?)");

			stmt.setString(1, NAME);
			stmt.setString(2, USR);
			stmt.setString(3, PWD);
			stmt.executeUpdate();
			
			

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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
