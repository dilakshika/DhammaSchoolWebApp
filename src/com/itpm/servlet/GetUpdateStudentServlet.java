package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Student;
import com.itpm.service.StudentServiceImpl;
import com.itpm.service.IStudentService;


@WebServlet("/GetUpdateStudentServlet")
public class GetUpdateStudentServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	public GetUpdateStudentServlet() {
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
		Student student = iStudentService.getStudentByID(InNo);

		request.setAttribute("student", student);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/UpdateStudent.jsp");
		dispatcher.forward(request, response);
	}

}
