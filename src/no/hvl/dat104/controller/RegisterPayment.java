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

/**
 * Servlet implementation class RegisterPayment
 */
@WebServlet("/registerPayment")
public class RegisterPayment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private final ParticipantHandler handler = new ParticipantHandler();

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session == null) {
			response.sendRedirect("administratorlogin?timeout");
			return;
		}
		
		String phone = request.getParameter("participant-phone").toString();
		
		handler.payFor(phone);
		
		response.sendRedirect("payoverview");
	}

}
