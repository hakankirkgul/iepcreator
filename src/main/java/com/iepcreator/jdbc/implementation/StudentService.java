package com.iepcreator.jdbc.implementation;

import java.sql.Types;
import java.util.Date;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.InitializingBean;

import com.iepcreator.jdbc.proc.ProcedureDefinition;
import com.iepcreator.jdbc.rowmappers.StudentModelRowMapper;
import com.iepcreator.jdbc.services.IStudentService;
import com.iepcreator.models.StudentModel;

public class StudentService implements InitializingBean, IStudentService {
	
	private ProcedureDefinition procgetStudents;
	private ProcedureDefinition procaddStudent;
	private ProcedureDefinition procdeleteStudent;
	private ProcedureDefinition procupdateStudent;
	private DataSource dataSource;

	@Override
	public void afterPropertiesSet() throws Exception {
		procgetStudents = new ProcedureDefinition(getDataSource(), "GET_STUDENTS", new StudentModelRowMapper(), Types.NUMERIC);
		procaddStudent = new ProcedureDefinition(getDataSource(), "ADD_STUDENT", false, Types.NUMERIC, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE);
		procdeleteStudent = new ProcedureDefinition(getDataSource(), "DELETE_STUDENT", false, Types.NUMERIC);
		procupdateStudent = new ProcedureDefinition(getDataSource(), "UPDATE_STUDENT", false, Types.NUMERIC, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.DATE);
	}
	
	@Override
	public List<StudentModel> getStudents(int userId) {
		List<StudentModel> students = (List<StudentModel>) procgetStudents.executeProcedure(userId);
		return students;
	}

	@Override
	public void addStudent(int userId, String name, String surname, String gender, String parentName, String parentSurname, Date birthDate) {
		procaddStudent.executeProcedureNoReturn(userId, name, surname, gender, parentName, parentSurname, birthDate); 
	}

	@Override
	public void deleteStudent(int studentId) {
		procdeleteStudent.executeProcedureNoReturn(studentId);
	}

	@Override
	public void updateStudent(int studentId, String name, String surname, String gender, String parentName, String parentSurname, Date birthDate) {
		procupdateStudent.executeProcedureNoReturn(studentId, name, surname, gender, parentName, parentSurname, birthDate); 
	}

	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

}
