package com.sistemi.informativi.servlet;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dao.*;
import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.ejb.StudentRegistrationEJB;
import com.sistemi.informativi.ejb.StudentRegistrationEJBLocal;


@WebServlet("/registration")
public class StudentRegistrationServlet extends HttpServlet {
	
	/*
	 * Tramite l'annotation @EJB l'EJB Container comprende
	 * che dovrà istanziare una classe EJB
	 * 
	 * L'EJB Container controlla il tipo della variabile di istanza
	 * che si trova sotto l'annotation @EJB e si apetta di trovare 
	 * il tipo di una Interfaccia EJB
	 * 
	 * L'EJB Container dietro le quinte eseguirà la seguente riga
	 * di codice : 
	 * 
	 * StudentRegistrationEJBLocal registration = new StudentRegistrationEJB();
	 * 
	 * La Dependency Injection di una EJB in JAVA EE richiede la dichiarazione
	 * di una variabile di istanza del tipo dell'Interfaccia Padre della Classe
	 * EJB che si desidera fare istanziare dall'EJB Container
	 * 
	 */
	
	//DI
	@EJB
	private StudentRegistrationEJBLocal registration;
	
	
	
	private static final long serialVersionUID = 1L;
       
  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
		/*
		 * recupero delle informazioni contenute nel body
		 * della richiesta proveniente dal client
		 * studentRegistration.html
		 */
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String age = request.getParameter("age");
		
		StudentDTO studentDTO = new StudentDTO(firstname,lastname,Integer.parseInt(age));
		
		HttpSession session = request.getSession();
		
		// Invocazione del metodo dell'EJB
		response.sendRedirect(registration.checkStudentAdded(studentDTO, session));
		

		
	}

}
