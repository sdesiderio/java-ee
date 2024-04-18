package com.sistemi.informativi.ejb;

import javax.ejb.Local;
import javax.servlet.http.HttpSession;

import com.sistemi.informativi.dto.StudentDTO;

@Local
public interface StudentRegistrationEJBLocal {
	
	public String checkStudentAdded(StudentDTO studentDTO,HttpSession session);

}
