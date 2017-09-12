package pl.imsi;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{	    

		     LoginBean user = new LoginBean();
		     user.setLogin(request.getParameter("user"));
		     user.setPassword(request.getParameter("password"));
		     
		     Connect con = new Connect();
			   		    
		     if (con.UserCheck(user.getLogin(), user.getPassword()))
		     {
			        
		          HttpSession session = request.getSession(true);	    
		          session.setAttribute("currentSessionUser",user); 
		          session.setAttribute("currentUserId",con.GetCurrentUserId(user.getLogin()));
		          response.sendRedirect("Test1.jsp"); //logged-in page      		
		     }
			        
		     else 
		     {
		    	 con.FailedLogIn(user.getLogin(), "Niepoprawne logowanie.");
		    	 response.sendRedirect("sesja.jsp"); //error page 
		     }
		          
		} 
				
				
		catch (Throwable theException) 	    
		{
		     System.out.println(theException); 
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
