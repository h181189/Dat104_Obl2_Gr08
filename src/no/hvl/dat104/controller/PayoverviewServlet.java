package no.hvl.dat104.controller;

import java.io.IOException;
import java.util.List;

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
 * Servlet implementation class PayoverviewServlet
 */
@WebServlet("/payoverview")
public class PayoverviewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private final ParticipantHandler handler = new ParticipantHandler();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if (session == null) {
			response.sendRedirect("administratorlogin?timeout");
			return;
		} else if (session.getAttribute("admin") == null) {
			response.sendRedirect("administratorlogin?notAdmin");
			return;
		}

		List<Participant> participants = handler.getAllParticipants();
		request.setAttribute("participants", participants);
		request.getRequestDispatcher("WEB-INF/payoverview.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		doGet(request, response);
	}

}
