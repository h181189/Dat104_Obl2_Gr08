package no.hvl.dat104.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.handler.ParticipantHandler;
import no.hvl.dat104.model.Participant;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	@EJB
	private final ParticipantHandler handler = new ParticipantHandler();
	
	private String error = "";
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("error", error);
		error = "";
		request.getRequestDispatcher("WEB-INF/login.jsp").forward(request, response);
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String phone = request.getParameter("phone");

		Participant p = handler.getParticipant(phone);
		if (p == null) {
			error = "Må tilhøre registrert deltager";
			response.sendRedirect("login");
		} else {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			
			session.setAttribute("phone", p.getPhone());
			response.sendRedirect("ParticipantList");
		}
	}

}
