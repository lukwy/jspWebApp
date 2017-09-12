package pl.imsi;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ChangePass
 */
@WebServlet("/ChangePass")
public class ChangePass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangePass() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String newPass = request.getParameter("newPass");
		String oldPass = request.getParameter("oldPass");
		LoginBean lb = (LoginBean) request.getSession().getAttribute("currentSessionUser");
		
		String lb1 = (String) request.getSession().getAttribute("currentSessionUser.login");
		
		Connect con = new Connect();

		if(oldPass.equals(lb.getPassword()))
		{
			con.PassChange(lb.getLogin(), newPass);
			con.FailedLogIn(lb.getLogin(), "Zmiana has³a.");
		}
		else
		{
			con.FailedLogIn(lb.getLogin(), "Niepoprawna zmiana has³a.");
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
