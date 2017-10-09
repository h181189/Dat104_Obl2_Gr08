package no.hvl.dat104.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class AdminServlet
 */
@WebServlet(name = "AdminServlet", urlPatterns = "/administratorlogin")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private String password;

	public void init() throws ServletException {
		password = getInitParameter("password");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String error = "";
		if (request.getParameter("error") != null) {
			error = "Feil passord";
		} else if (request.getParameter("timeout") != null) {
			error = "Du er blitt logget av for inaktivitet";
		} else if (request.getParameter("notAdmin") != null) {
			error = "Du har ikke tilgang til denne siden";
		}

		request.setAttribute("error", error);
		request.getRequestDispatcher("WEB-INF/adminlogin.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String inputPassword = request.getParameter("password");

		if (inputPassword.equals(password)) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}

			session = request.getSession(true);
			Integer sessionTimeout = Integer.valueOf(getInitParameter("session-timeout"));

			boolean admin = true;
			session.setMaxInactiveInterval(sessionTimeout);
			session.setAttribute("password", password);
			session.setAttribute("admin", admin);

			response.sendRedirect("payoverview");

		} else {
			response.sendRedirect("administratorlogin?" + "error");
		}
	}

}
