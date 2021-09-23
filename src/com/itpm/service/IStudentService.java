/**
 * OOP 2018
 * 
 * @author Udara Samaratunge  Department of Software Engineering, SLIIT 
 * 
 * @version 1.0
 * Copyright: SLIIT, All rights reserved
 * 
 */
package com.itpm.service;

import com.itpm.model.Student;

import java.util.ArrayList;
import java.util.logging.Logger;



public interface IStudentService {

	
	public static final Logger log = Logger.getLogger(IStudentService.class.getName());


	public void addStudent(Student student);


	public Student getStudentByID(String InNo);
	

	public ArrayList<Student> getStudents();
	

	public Student updateStudent(String InNo, Student student);

	
	public void removeStudent(String InNo);

}
