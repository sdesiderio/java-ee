package com.sistemi.informativi.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sistemi.informativi.connection.ConnectionManager;
import com.sistemi.informativi.dto.StudentDTO;
import com.sistemi.informativi.vo.StudentVO;

public class StudentDAOImpl implements StudentDAO {

	private String sqlInsert = "insert into student(first_name,last_name,age) values (?,?,?)";

	private String sqlUpdate = "update student set first_name=?,last_name=?,age=? where id=?";

	private String sqlDelete = "delete from student where id=?";

	private String sqlRead = "select * from student";

	@Override
	public int addStudent(StudentDTO studentDTO) {

		ConnectionManager connectionManager = new ConnectionManager();

		int nRowsInserted = 0;

		try {

			// richiesta di un PreperedStatement già inizializzato per eseguire un insert
			PreparedStatement ps = connectionManager.getPreparedStatement(sqlInsert);
			// sql = "insert into student(first_name,last_name,age)values(?,?,?);
			ps.setString(1, studentDTO.getFirstName());
			ps.setString(2, studentDTO.getLastName());
			ps.setInt(3, studentDTO.getAge());
			nRowsInserted = ps.executeUpdate();

		}

		catch (SQLException ex) {

			ex.printStackTrace();
		}

		finally {

			connectionManager.closeConnection();

		}

		return nRowsInserted;
	}

	@Override
	public int updateStudent(StudentDTO studentDTO, int id) {

		ConnectionManager connectionManager = new ConnectionManager();

		int nRowsUpdated = 0;

		try {
			// richiesta di un PreperedStatement già inizializzato per eseguire un update
			PreparedStatement ps = connectionManager.getPreparedStatement(sqlUpdate);
			// "update student set first_name=?,last_name=?,age=? where id=?"
			ps.setString(1, studentDTO.getFirstName());
			ps.setString(2, studentDTO.getLastName());
			ps.setInt(3, studentDTO.getAge());
			ps.setInt(4, id);
			nRowsUpdated = ps.executeUpdate();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		finally {

			connectionManager.closeConnection();

		}

		return nRowsUpdated;

	}

	@Override
	public int removeStudent(int id) {

		ConnectionManager connectionManager = new ConnectionManager();

		int nRowsRemoved = 0;

		try {

			PreparedStatement ps = connectionManager.getPreparedStatement(sqlDelete);
			ps.setInt(1, id);
			nRowsRemoved = ps.executeUpdate();

		} catch (SQLException ex) {

			ex.printStackTrace();
		}

		finally {

			connectionManager.closeConnection();

		}

		return nRowsRemoved;

	}

	@Override
	public List<StudentVO> findAllStudents() {

		ConnectionManager connectionManager = new ConnectionManager();

		ResultSet rs = connectionManager.getResultSet(sqlRead);

		List<StudentVO> students = new ArrayList<>();

		try {

			while (rs.next()) {

				/*
				 * Per ogni Oggetto restituito dal ResultSet facciamo una copia in un
				 * corrispondente oggetto StudentVO che è sicuramente serializzabile, e ne
				 * stampiamo il contenuto
				 */

				StudentVO studentVO = new StudentVO(rs.getInt("id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("age"));

				students.add(studentVO);

			}
		} catch (SQLException ex) {

			ex.printStackTrace();

		}

		finally {

			connectionManager.closeConnection();

		}

		return students;

	}

}
