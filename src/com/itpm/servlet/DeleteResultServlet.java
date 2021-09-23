package com.itpm.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itpm.service.ResultServiceImpl;
import com.itpm.service.IResultService;

@WebServlet("/DeleteResultServlet")
public class DeleteResultServlet extends HttpServlet {
	private static final long serialVersionUID = 1871871796669342804L;
       
  
    public DeleteResultServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		String ResultId = request.getParameter("ResultId");
		
		IResultService iResultService = new ResultServiceImpl();
		iResultService.removeResult(ResultId);
		
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/WEB-INF/views/ListResults.jsp");
		dispatcher.forward(request, response);
	}

}
