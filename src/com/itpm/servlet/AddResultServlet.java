package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.model.Result;
import com.itpm.service.ResultServiceImpl;
import com.itpm.service.IResultService;


@WebServlet("/AddResultServlet")
public class AddResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public AddResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		Result result = new Result();
		
		result.setSid(request.getParameter("sid"));
		result.setName(request.getParameter("name"));
		result.setYear(request.getParameter("year"));
		result.setGrade(request.getParameter("grade"));
		result.setExam(request.getParameter("exam"));
		result.setResult(request.getParameter("result"));
		result.setPassword(request.getParameter("password"));

		IResultService iResultService = new ResultServiceImpl();
		iResultService.addResult(result);

		request.setAttribute("result", result);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListResults.jsp");
		dispatcher.forward(request, response);
	}

}
