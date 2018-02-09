package dealership;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Frontservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// HIBERNATE CODE
		HttpSession session = request.getSession();
		User u = (User) session.getAttribute("user");
		String uname = u.getUsername();
		String pwd = u.getPassword();
		try {
			UserDAO userDAO = new UserDAO();
			userDAO.addUserDetails(uname, pwd);
			response.sendRedirect("new.jsp");
		} catch (Exception e) {

			e.printStackTrace();
		}
	}

}
