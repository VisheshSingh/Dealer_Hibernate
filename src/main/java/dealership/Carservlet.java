package dealership;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Carservlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		UserDAO u = new UserDAO();
		ArrayList<Car> arrcar = u.getCars();

		request.setAttribute("carlist", arrcar);
		session.setAttribute("carlist", arrcar);
		RequestDispatcher RD = request.getRequestDispatcher("cars.jsp");
		RD.forward(request, response);
	}

}
