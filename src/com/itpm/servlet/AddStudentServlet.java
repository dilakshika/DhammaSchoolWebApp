package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Student;
import com.itpm.service.StudentServiceImpl;
import com.itpm.service.IStudentService;


public class AddStudentServlet extends HttpServlet {

	
	private static final long serialVersionUID = 1L;

	public AddStudentServlet() {
		super();
	}

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		Student student = new Student();
		
		student.setFname(request.getParameter("Fname"));
		student.setIName(request.getParameter("IName"));
		student.setBirthday(request.getParameter("Birthday"));
		student.setAddress(request.getParameter("Address"));
		student.setGender(request.getParameter("Gender"));
		student.setGuardian(request.getParameter("Guardian"));
		student.setMobile(request.getParameter("Mobile"));
		student.setADate(request.getParameter("ADate"));
		student.setComment(request.getParameter("Comment"));
		student.setPosition(request.getParameter("position"));
		
		
		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.addStudent(student);

		request.setAttribute("student", student);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStudents.jsp");
		dispatcher.forward(request, response);
	}

}
