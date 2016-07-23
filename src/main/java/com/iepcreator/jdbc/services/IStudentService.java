package com.iepcreator.jdbc.services;

import java.util.Date;
import java.util.List;

import com.iepcreator.models.StudentModel;

public interface IStudentService {

	List<StudentModel> getStudents(int userId);
	
	void addStudent(int userId, String name, String surname, String gender, String parentName, String parentSurname, Date birthDate);
	
	void deleteStudent(int studentId);
	
	void updateStudent(int studentId, String name, String surname, String gender, String parentName, String parentSurname, Date birthDate);
	
}
