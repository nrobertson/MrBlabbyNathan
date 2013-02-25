

import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ArrayList listMessage = new ArrayList();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String message;
		String name;
		String time;
		String user;
		String email;
		String dbUSR = "NathanRobertson";
		String dbPWD = "ac31004";
		String dbUrl = "jdbc:mysql://arlia.computing.dundee.ac.uk/nathanrobertson";
		String dbClass = "com.mysql.jdbc.Driver";
		String MSGquery = "Select * FROM messages WHERE message like '%" + request.getParameter("Search") + "%'";
		String USRquery = "Select * FROM user WHERE Name like '%" + request.getParameter("Search") + "%'";
		//String MSG = request.getParameter("Email");
		//String PWD = request.getParameter("Password");
		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection (dbUrl,dbUSR,dbPWD);
			Statement stmt = con.createStatement();
			
			if(request.getParameter("searchType").equals("message"))
			{
			ResultSet rs = stmt.executeQuery(MSGquery);
			listMessage.clear();
			while (rs.next()) {
			listMessage.add(rs.getString(1));
			listMessage.add(rs.getString(2));
			listMessage.add(rs.getString(3));
			
						
			
			} 
			request.setAttribute("messageList", listMessage);
			//response.sendRedirect("messages.jsp");
			//Iterator it = listMessage.iterator();
			//while(it.hasNext())
			//{
			//System.out.print(it.next());
			//}
			RequestDispatcher dispatcher = request.getRequestDispatcher("MessageSearch.jsp");

			  if (dispatcher != null){

			  dispatcher.forward(request, response);

			}
			}
			  else
			  {
				  ResultSet USRrs = stmt.executeQuery(USRquery);
				  listMessage.clear();
					while (USRrs.next()) 
						{
						listMessage.add(USRrs.getString(1));
						listMessage.add(USRrs.getString(2));
			
						System.out.print(USRrs.getString(1)+ " " + USRrs.getString(2));
						
						} 
						request.setAttribute("messageList", listMessage);
						//response.sendRedirect("messages.jsp");
						//Iterator it = listMessage.iterator();
						//while(it.hasNext())
						//{
						//}
						 // RequestDispatcher dispatcher = request.getRequestDispatcher("messages.jsp");
						 // System.out.print("here!!");
						 // if (dispatcher != null){

						 // dispatcher.forward(request, response);
						RequestDispatcher dispatcher1 = request.getRequestDispatcher("UserSearch.jsp");

						  if (dispatcher1 != null){

						  dispatcher1.forward(request, response);


			  }
			
			  }
		
		  
			con.close();
			
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

}
