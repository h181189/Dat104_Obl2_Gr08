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

@WebServlet("/ParticipantList")
public class ParticipantListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB
	ParticipantHandler databaseHandler = new ParticipantHandler();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("phone") == null) {
			response.sendRedirect("login");
		} else {
			String cPhone = (String) session.getAttribute("phone");
			request.setAttribute("phone", cPhone);
			List<Participant> list = databaseHandler.getAllParticipants();
			
			request.setAttribute("participant", list);

			request.getRequestDispatcher("/participant.jsp").forward(request, response);
		}
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		session.invalidate();
		resp.sendRedirect("done.html");
	}
}
