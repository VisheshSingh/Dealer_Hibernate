package dealership;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Loginservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("u");
		String uname = u.getUsername();
		String pwd = u.getPassword();

		UserDAO ud = new UserDAO();
		if (ud.checkDetails(uname, pwd)) {
			System.out.println("login success!");
			response.sendRedirect("success.jsp");
		} else {
			System.out.println("login failed!");
			response.sendRedirect("index.html");
		}
	}

}
