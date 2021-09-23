package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.itpm.service.StudentServiceImpl;
import com.itpm.service.IStudentService;

public class DeleteStudentServlet extends HttpServlet {


	
	private static final long serialVersionUID = 1871871796669342804L;

	public DeleteStudentServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");

		String InNo = request.getParameter("InNo");			
		
		IStudentService iStudentService = new StudentServiceImpl();
		iStudentService.removeStudent(InNo);

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListStudents.jsp");
		dispatcher.forward(request, response);
	}

}
