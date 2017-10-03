package no.hvl.dat104.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
	ParticipantHandler databaseHandler = new ParticipantHandler();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		
		HttpSession session = request.getSession(false);
		if (session == null || session.getAttribute("phone") == null) {
			response.sendRedirect("LoginServlet");
		} else {
			String cPhone = (String) session.getAttribute("phone");
			request.setAttribute("phone", cPhone);
			ArrayList<Participant> list = (ArrayList<Participant>) databaseHandler.getAllParticipants();
			
			Collections.sort(list, new Comparator<Participant>() {
		        @Override
		        public int compare(Participant par0, Participant par1)
		        {
		            return  (par0.getFirstName()+par0.getSurname()).compareTo((par1.getFirstName())+par1.getSurname());
		        }
		    });
			request.setAttribute("participant", list);

			request.getRequestDispatcher("/participant.jsp").forward(request, response);
			
			

		}
	}
}
