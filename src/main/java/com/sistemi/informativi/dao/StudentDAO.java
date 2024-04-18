package com.sistemi.informativi.dao;

import java.util.List;

import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.vo.StudentVO;


public interface StudentDAO {
	
	
	public int addStudent(StudentDTO studentDTO);
	
	public int updateStudent(StudentDTO studentDTO,int id);
	
	public int removeStudent(int id);
	
	public List<StudentVO> findAllStudents();
	

}


