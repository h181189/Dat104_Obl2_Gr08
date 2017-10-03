package no.hvl.dat104.controller;

import java.io.IOException;
import java.util.Map;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat104.RegisterForm;
import no.hvl.dat104.handler.ParticipantHandler;
import no.hvl.dat104.model.Participant;

/**
 * Servlet implementation class RegisterServlet
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private final ParticipantHandler handler = new ParticipantHandler();
	
	private final RegisterForm form = new RegisterForm();
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = form.getErrors();
		
		request.setAttribute("nameError", errors.get("name"));
		request.setAttribute("oldName", form.old("name"));
		request.setAttribute("surnameError", errors.get("surname"));
		request.setAttribute("oldSurname", form.old("surname"));
		request.setAttribute("phoneError", errors.get("phone"));
		request.setAttribute("oldPhone", form.old("phone"));
		
		form.clear();
		request.getRequestDispatcher("register.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("firstname");
		String surname = request.getParameter("surname");
		String phone = request.getParameter("phone");
		boolean sex = request.getParameter("sex").equals("male");
		
		boolean validInput = form.validate(name, surname, phone);
		if (validInput) {
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			
			Participant p = new Participant();
			p.setFirstName(name);
			p.setSurname(surname);
			p.setPhone(phone);
			p.setSex(sex);
			p.setPaid(false);
			handler.saveParticipant(p);
			
			session.setAttribute("participant", p);
			response.sendRedirect("confirmation");
		} else {
			form.clear();
			response.sendRedirect("register");
		}
		
	}

}
