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

import org.apache.commons.lang.StringEscapeUtils;

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
	private boolean userExists;
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Map<String, String> errors = form.getErrors();
		
		if (errors.containsKey("name")) {
			request.setAttribute("nameError", errors.get("name"));
		} else {
			request.setAttribute("oldName", form.old("name"));
		}

		if (errors.containsKey("surname")) {
			request.setAttribute("surnameError", errors.get("surname"));
		} else {
			request.setAttribute("oldSurname", form.old("surname"));
		}
		
		if (errors.containsKey("phone")) {
			request.setAttribute("phoneError", errors.get("phone"));
		} else if (userExists) {
			request.setAttribute("phoneError", "nummeret er allerede registrert");
		} else {
			request.setAttribute("oldPhone", form.old("phone"));
		}
		
		String male = "checked='checked'";
		String female = "";
		if (form.old("sex") != null) {
			if (!form.old("sex").equals("male")) {
				female = male;
				male = "";
			}
		}
		
		request.setAttribute("male", male);
		request.setAttribute("female", female);
		
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
		String sex = request.getParameter("sex");
		
		name = StringEscapeUtils.escapeHtml(name);
		surname = StringEscapeUtils.escapeHtml(surname);
		phone = StringEscapeUtils.escapeHtml(phone);
		
		userExists = handler.exists(phone);
		boolean validInput = form.validate(name, surname, phone, sex) && !userExists;
		if (validInput) {
			
			HttpSession session = request.getSession(false);
			if (session != null) {
				session.invalidate();
			}
			session = request.getSession(true);
			
			name = name.substring(0, 1).toUpperCase() + name.substring(1);
			surname = surname.substring(0, 1).toUpperCase() + surname.substring(1);

			boolean finalSex = sex.equals("male");
			Participant p = new Participant();
			p.setFirstName(name);
			p.setSurname(surname);
			p.setPhone(phone);
			p.setSex(finalSex);
			p.setPaid(false);
			handler.saveParticipant(p);
			
			form.clear();
			session.setAttribute("participant", p);
			response.sendRedirect("confirmation");
		} else {
			response.sendRedirect("register");
		}
		
	}

}
