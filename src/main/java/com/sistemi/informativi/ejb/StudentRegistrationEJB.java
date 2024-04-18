package com.sistemi.informativi.ejb;

import javax.ejb.Stateless;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.dao.*;


@Stateless
public class StudentRegistrationEJB implements StudentRegistrationEJBLocal {
	

	
	/*
	 * metodo che si occupa di invocare lo strato applicativo DAO
	 * passando in input l'Oggetto DTO ricevuto dalla Servlet e, dopo
	 * la restituizione del risultato dell'operazione di CRUD compiuta 
	 * dal DAO, si occupa di gestire la logica della pagina web che poi
	 * dovrà restituire al Client la Servlet
	 */
   @Override	
   public String checkStudentAdded(StudentDTO studentDTO,HttpSession session) {
	   
	   
	   String page = "error.html";
	   
	   int nRowsInserted = 0;
	   
	   StudentDAO studentDAO =new StudentDAOImpl();
	   
	   nRowsInserted = studentDAO.addStudent(studentDTO);
	   
	   if (nRowsInserted>0) {
		   
		   session.setAttribute("studentDTO", studentDTO);
		   page = "successRegistration.jsp";
		  
	   }
	   
	  return page;
	   
	   
   }

}
