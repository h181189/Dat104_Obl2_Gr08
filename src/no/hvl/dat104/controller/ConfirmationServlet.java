package no.hvl.dat104.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.model.Participant;

/**
 * Servlet implementation class ConfirmationServlet
 */
@WebServlet("/confirmation")
public class ConfirmationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("login");
			return;
		}
		
		Participant p = (Participant) session.getAttribute("participant");
		String sex = p.isSex() ? "mann" : "kvinne";
		
		request.setAttribute("participant", p);
		request.setAttribute("sex", sex);
		session.setAttribute("phone", p.getPhone());
		
		request.getRequestDispatcher("confirmation.jsp").forward(request, response);
	}

}
